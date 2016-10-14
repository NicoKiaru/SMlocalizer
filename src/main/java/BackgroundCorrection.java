/* Copyright 2016 Kristoffer Bernhem.
 * This file is part of SMLocalizer.
 *
 *  SMLocalizer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SMLocalizer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SMLocalizer.  If not, see <http://www.gnu.org/licenses/>.
 */
import static jcuda.driver.JCudaDriver.cuCtxCreate;
import static jcuda.driver.JCudaDriver.cuCtxSynchronize;
import static jcuda.driver.JCudaDriver.cuDeviceGet;
import static jcuda.driver.JCudaDriver.cuInit;
import static jcuda.driver.JCudaDriver.cuLaunchKernel;
import static jcuda.driver.JCudaDriver.cuMemFree;
import static jcuda.driver.JCudaDriver.cuMemcpyDtoH;
import static jcuda.driver.JCudaDriver.cuModuleGetFunction;
import static jcuda.driver.JCudaDriver.cuModuleLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.process.ImageStatistics;
import jcuda.Pointer;
import jcuda.Sizeof;
import jcuda.driver.CUcontext;
import jcuda.driver.CUdevice;
import jcuda.driver.CUdeviceptr;
import jcuda.driver.CUfunction;
import jcuda.driver.CUmodule;


/* This class contains all relevant algorithms for background corrections. Handles 2D and 3D stacks with single slice per frame.
 * V 2.0 2016-07-18 Kristoffer Bernhem, kristoffer.bernhem@gmail.com
 */

class BackgroundCorrection {

	/* Main function for background filtering using the time median based method described in:
	 * The fidelity of stochastic single-molecule super-resolution reconstructions critically depends upon robust background estimation
	 *	E. Hoogendoorn, K. C. Crosby, D. Leyton-Puig, R. M.P. Breedijk, K. Jalink, T. W.J. Gadella & M. Postma
	 *	Scientific Reports 4, Article number: 3854 (2014)	
	 */
	public static void medianFiltering(final int[] W, ImagePlus image, int selectedModel){		
		int nChannels 	= image.getNChannels();
		int nFrames 	= image.getNFrames();
		if (nFrames == 1)
			nFrames = image.getNSlices();  				// some formats store frames as slices, some as frames.
		int columns = image.getWidth();
		int rows	= image.getHeight();		
		System.out.println(image.getNChannels());
		System.out.println(image.getNFrames());
		System.out.println(image.getNSlices());
		System.out.println(image.getWidth());
		System.out.println(image.getHeight());
		
			if(selectedModel == 0) // parallel.
			{
				for (int Ch = 1; Ch <= nChannels; Ch++){ // Loop over all channels.
					float[] MeanFrame = new float[nFrames]; 		// Will include frame mean value.
					float[][] timeVector = new float[rows*columns][nFrames];
					ImageProcessor IP = image.getProcessor();		// get image processor for the stack.´


					for (int Frame = 1; Frame < nFrames+1; Frame++){			
						if (image.getNFrames() == 1)
						{
							image.setPosition(							
									Ch,			// channel.
									Frame,			// slice.
									1);		// frame.
						}
						else
						{														
							image.setPosition(
									Ch,			// channel.
									1,			// slice.
									Frame);		// frame.
						}
						IP 						= image.getProcessor(); 			// Update processor to next slice.


						for (int i = 0; i < rows*columns; i++)
						{
							MeanFrame[Frame-1] += IP.get(i);
						}
						MeanFrame[Frame-1] /= rows*columns;

						if (MeanFrame[Frame-1] < 1)
							MeanFrame[Frame-1] = 1;
						for (int i = 0; i < rows*columns; i++)
						{
//							timeVector[i][Frame-1] = (float) (IP.get(i %rows , i / columns)/MeanFrame[Frame-1]); // load data. 
							timeVector[i][Frame-1] = (float) (IP.get(i )/MeanFrame[Frame-1]); // load data. 
						
						}
					} // Data loading.

					List<Callable<float[]>> tasks = new ArrayList<Callable<float[]>>();	// Preallocate.
					for (int i = 0; i < rows*columns; i++)
					{
						final float[] timeVectorF = timeVector[i];

						final int chFinal = Ch - 1;
						Callable<float[]> c = new Callable<float[]>() {				// Computation to be done.
							@Override
							public float[] call() throws Exception {
								return runningMedian(timeVectorF, W[chFinal]);						// Actual call for each parallel process.
							}
						};
						tasks.add(c);
					}

					int processors 			= Runtime.getRuntime().availableProcessors();	// Number of processor cores on this system.
					ExecutorService exec 	= Executors.newFixedThreadPool(processors);		// Set up parallel computing using all cores.
					try {
						List<Future<float[]>> parallelCompute = exec.invokeAll(tasks);				// Execute computation.    
						for (int i = 0; i < parallelCompute.size(); i++){							// Loop over and transfer results.
							try {
								float[] data = parallelCompute.get(i).get();

								for (int k = 0; k < data.length; k++){	
									timeVector[i][k] = (int)(data[k]*MeanFrame[k]);								
								}			
							} catch (ExecutionException e) {
								e.printStackTrace();
							}
						}

					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					finally {
						exec.shutdown();
					}
					int value = 0;
					for (int Frame = 1; Frame <= nFrames; Frame++) // store data.
					{						
						if (image.getNFrames() == 1)
						{
							image.setPosition(							
									Ch,			// channel.
									Frame,			// slice.
									1);		// frame.
						}
						else
						{														
							image.setPosition(
									Ch,			// channel.
									1,			// slice.
									Frame);		// frame.
						}
						IP 						= image.getProcessor(); 			// Update processor to next slice.

						for (int i = 0; i < rows*columns; i++)
						{
//							value = IP.get(i % rows, i / columns) - (int)timeVector[i][Frame-1];
							value = IP.get(i ) - (int)timeVector[i][Frame-1];
							if (value < 0)
								value = 0;
							//IP.set(i % rows, i / columns, value);							
							IP.set(i , value);	
					//		if ( i % rows == 29 && i / columns == 17)
								//System.out.println("final: " + value + " from " + IP.get(i % rows, i / columns) + " and " + (int)timeVector[i][Frame-1]);
						}
					}
					image.updateAndDraw();
				} // Channel loop.

			}else // end parallel.
				if(selectedModel == 2) // GPU.
				{					
					// Initialize the driver and create a context for the first device.
					cuInit(0);
					CUdevice device = new CUdevice();
					cuDeviceGet(device, 0);
					CUcontext context = new CUcontext();
					cuCtxCreate(context, 0, device);
					// Load the PTX that contains the kernel.
					CUmodule module = new CUmodule();
					cuModuleLoad(module, "medianFilter.ptx");
					// Obtain a handle to the kernel function.
					CUfunction function = new CUfunction();
					cuModuleGetFunction(function, module, "medianKernel");

					for(int Ch = 1; Ch <= nChannels; Ch++)
					{
						float[] timeVector = new float[nFrames * rows * columns];
						float[] MeanFrame = new float[nFrames]; 		// Will include frame mean value.
						ImageProcessor IP = image.getProcessor();
						for (int Frame = 1; Frame <= nFrames; Frame++)
						{			
							if (image.getNFrames() == 1)
							{
								image.setPosition(							
										Ch,			// channel.
										Frame,			// slice.
										1);		// frame.
							}
							else
							{														
								image.setPosition(
										Ch,			// channel.
										1,			// slice.
										Frame);		// frame.
							}
							IP = image.getProcessor();

							for (int i = 0; i < rows*columns; i ++)
							{
								timeVector[(Frame-1) + nFrames*i] = IP.get(i);			
								MeanFrame[Frame-1] += IP.get(i);
							}
							MeanFrame[Frame-1] /= columns*rows;


						} // frame loop for mean calculations.

						CUdeviceptr device_window 		= CUDA.allocateOnDevice((float)((2 * W[Ch] + 1) * rows * columns)); // swap vector.
						CUdeviceptr device_Data 		= CUDA.copyToDevice(timeVector);
						CUdeviceptr device_meanVector 	= CUDA.copyToDevice(MeanFrame);
						CUdeviceptr deviceOutput 		= CUDA.allocateOnDevice((int)timeVector.length);

						int filteWindowLength 		= (2 * W[0] + 1) * rows * columns;
						int testDataLength 			= timeVector.length;
						int meanVectorLength 		= MeanFrame.length;
						Pointer kernelParameters 	= Pointer.to(   
								Pointer.to(new int[]{W[Ch]}),
								Pointer.to(device_window),
								Pointer.to(new int[]{filteWindowLength}),
								Pointer.to(new int[]{nFrames}),
								Pointer.to(device_Data),
								Pointer.to(new int[]{testDataLength}),
								Pointer.to(device_meanVector),
								Pointer.to(new int[]{meanVectorLength}),
								Pointer.to(deviceOutput),
								Pointer.to(new int[]{testDataLength})
								);
						int blockSizeX 	= 1;
						int blockSizeY 	= 1;				   
						int gridSizeX 	= columns;
						int gridSizeY 	= rows;
						cuLaunchKernel(function,
								gridSizeX,  gridSizeY, 1, 	// Grid dimension
								blockSizeX, blockSizeY, 1,  // Block dimension
								0, null,               		// Shared memory size and stream
								kernelParameters, null 		// Kernel- and extra parameters
								);
						cuCtxSynchronize();

						// Pull data from device.
						int hostOutput[] = new int[timeVector.length];
						cuMemcpyDtoH(Pointer.to(hostOutput), deviceOutput,
								timeVector.length * Sizeof.INT);

						// Free up memory allocation on device, housekeeping.
						cuMemFree(device_window);   
						cuMemFree(device_Data);    
						cuMemFree(deviceOutput);
						// return data.

						for (int Frame = 1; Frame <= nFrames; Frame++)
						{			
							if (image.getNFrames() == 1)
							{
								image.setPosition(							
										Ch,			// channel.
										Frame,			// slice.
										1);		// frame.
							}
							else
							{														
								image.setPosition(
										Ch,			// channel.
										1,			// slice.
										Frame);		// frame.
							}
							IP = image.getProcessor();		

							for (int i = 0; i < rows*columns; i ++)
							{																
				//				int x = i % rows;
				//				int y = i / columns;
								//int value = hostOutput[(Frame-1) + nFrames*i];

								int value  = hostOutput[(Frame-1)*columns*rows + i];

								if (value < 0)
									value = 0;
//								IP.set(x,y, value);
								IP.set(i, value);

								//	System.out.print(hostOutput[(Frame-1) + nFrames*i]);
							}
							//	System.out.println("\n");
							image.setProcessor(IP);

						} // frame loop for mean calculations.
					} // Channel loop.				
					image.updateAndDraw();
				} // end GPU.
		//return outputArray;

	} // medianfiltering with image output.

	
	/*
	 * float precision version.
	 */
	public static float[] runningMedian(float[] Vector, int W){
		// Preallocate variables.				
		float[] medianVector = new float[Vector.length]; // Output vector.
		float[] V = new float[2*W+1];  // Vector for calculating running median.		

		int low = 0;
		int high = W;			   

		for(int i = 0; i < V.length; i++){ // Transfer first 2xW+1 entries.
			V[i] = Vector[i];
		//	quickSort(V, low, high); // Quicksort first W entries.	
			if (i> W)
			{
				
			//	V[i] = Vector[i];
				
				quickSort(V, low, high); // Quicksort first W entries.	
				if (i % 2 == 0){
					medianVector[i-W-1] = (float) ((V[i/2]+V[i/2+1])/2.0);
				}else{
					medianVector[i-W-1] = V[i/2];

				}	
				high++;

			}
			
		}

			
		for(int i = W; i < Vector.length-W-1; i++){ // Main loop, middle section.			
			medianVector[i] = V[W]; // Pull out median value.
			replaceEntry(V,Vector[i-W],Vector[i+W+1]);
			/*V = removeEntry(V,Vector[i-W]);
			V = sortInsert(V,Vector[i+W+1]);	*/

		}
		for (int i = Vector.length-W-1; i < Vector.length; i++){ // Last section, without access to data on right.			
			if (i % 2 == 0){				
				medianVector[i] = V[W-(i-Vector.length + W + 1)/2];
			}else{
				medianVector[i] = (float) ((V[W-(i-Vector.length + W)/2]+V[W-(i-Vector.length + W)/2-1])/2.0);
			}
			V = removeEntry(V,Vector[i-W]); // Remove items from V once per loop, ending with a W+1 large vector.	
		}		
		return medianVector;
		//	return Vector;
	}

	public static void replaceEntry(float[] vector, float oldEntry, float newEntry)
	{
		int index = 0;
		boolean searching = true;
		while (searching)
		{
			if (vector[index]== oldEntry)
			{
				searching = false;
			}else
				index++;
			
			if (index == vector.length)
				searching = false;
		}		
		vector[index] = newEntry; // replace entry.
		quickSort(vector,0,vector.length-1);
		/*if (oldEntry != newEntry) 
		{
			if(index == 0)  // replaced first entry-
			{
				while (vector[index+1] < newEntry && index < vector.length)
				{
					// move entry upwards until this is not true.
					vector[index] = vector[index+1];
					vector[index+1] = newEntry;
					index++;
				}
			}else if(index == vector.length-1) // replaced final entry.
			{
				while(vector[index-1] > newEntry)
				{
					vector[index] = vector[index-1];
					vector[index-1] = newEntry;
					index--;
				}
			}else
			{
				if(vector[index-1] == newEntry || vector[index+1] == newEntry)
				{
					// do nothing.
				}else if(vector[index-1] > newEntry)
				{
					while (vector[index+1] < newEntry && index < vector.length)
					{
						// move entry upwards until this is not true.
						vector[index] = vector[index+1];
						vector[index+1] = newEntry;
						index++;
					}
				}else
				{
					while(vector[index-1] > newEntry)
					{
						vector[index] = vector[index-1];
						vector[index-1] = newEntry;
						index--;
					}
				}
			}
		}*/
		
	}
	public static float[] removeEntry(float[] inVector, float entry) { // Return vector with element "entry" missing.
		int found = 0;
		float[] vectorOut = new float[inVector.length -1];
		for (int i = 0; i < inVector.length - 1;i++){
			if (inVector[i] == entry){
				found = 1;				
			}
			vectorOut[i] = inVector[i+found];
		}
		return vectorOut;
	} 

	public static int indexOfIntArray(float[] array, float key) {
		int returnvalue = -1;
		for (int i = 0; i < array.length; ++i) {
			if (key == array[i]) {
				returnvalue = i;
				break;
			}
		}
		return returnvalue;
	}

	public static float[] sortInsert(float[] Vector, float InsVal){ // Assumes sorted input vector.
		float[] bigVector = new float[Vector.length + 1]; // Add InsVal into this vector		
		int indexToInsert = 0;
		if (InsVal > Vector[Vector.length-1]){ // If the value to be inserted is larger then the last value in the vector.

			System.arraycopy(Vector, 0, bigVector, 0, Vector.length);
			bigVector[bigVector.length-1] = InsVal;
			return bigVector;
		}else if (InsVal < Vector[0]){  // If the value to be inserted is smaller then the first value in the vector.
			bigVector[0] = InsVal;
			System.arraycopy(Vector, 0, bigVector, 1, Vector.length);
			return bigVector;
		}else{
			for (int i = 1; i < Vector.length; i++){
				if (InsVal < Vector[i]){
					indexToInsert = i;

					System.arraycopy(Vector, 0, bigVector, 0, indexToInsert);
					bigVector[indexToInsert] = InsVal;
					System.arraycopy(Vector, indexToInsert, bigVector, indexToInsert+1, Vector.length-indexToInsert);
					return bigVector;
				}

			}
		}
		return bigVector;
	}

	public static void quickSort(float[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		float pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				float temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	public static double[] removeEntry(double[] inVector, double entry) { // Return vector with element "entry" missing.
		int found = 0;
		double[] vectorOut = new double[inVector.length -1];
		for (int i = 0; i < inVector.length - 1;i++){
			if (inVector[i] == entry){
				found = 1;				
			}
			vectorOut[i] = inVector[i+found];
		}
		return vectorOut;
	} 

	public static int indexOfIntArray(double[] array, double key) {
		int returnvalue = -1;
		for (int i = 0; i < array.length; ++i) {
			if (key == array[i]) {
				returnvalue = i;
				break;
			}
		}
		return returnvalue;
	}

	public static double[] sortInsert(double[] Vector, double InsVal){ // Assumes sorted input vector.
		double[] bigVector = new double[Vector.length + 1]; // Add InsVal into this vector		
		int indexToInsert = 0;
		if (InsVal > Vector[Vector.length-1]){ // If the value to be inserted is larger then the last value in the vector.

			System.arraycopy(Vector, 0, bigVector, 0, Vector.length);
			bigVector[bigVector.length-1] = InsVal;
			return bigVector;
		}else if (InsVal < Vector[0]){  // If the value to be inserted is smaller then the first value in the vector.
			bigVector[0] = InsVal;
			System.arraycopy(Vector, 0, bigVector, 1, Vector.length);

			return bigVector;
		}else{
			for (int i = 1; i < Vector.length; i++){
				if (InsVal < Vector[i]){
					indexToInsert = i;

					System.arraycopy(Vector, 0, bigVector, 0, indexToInsert);
					bigVector[indexToInsert] = InsVal;
					System.arraycopy(Vector, indexToInsert, bigVector, indexToInsert+1, Vector.length-indexToInsert);
					return bigVector;
				}

			}
		}
		return bigVector;
	}

	public static void quickSort(double[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		double pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				double temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}
}