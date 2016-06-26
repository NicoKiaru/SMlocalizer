package sm_localizer;

import java.awt.Color;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.DoublePoint;

import ij.IJ;

//import org.scijava.plugin.Plugin;

import ij.ImagePlus;
import ij.ImageStack;
import ij.WindowManager;
import ij.gui.Plot;
import ij.plugin.PlugIn;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;
import net.imagej.Dataset;
import net.imagej.ImageJ;

/** Loads and displays a dataset using the ImageJ API. */
//@Plugin(menuPath = "Plugins>Examples>Dataset", type = null)


public class Evaluate_ implements PlugIn {

	public static void main(final String... args) throws Exception {
		// create the ImageJ application context with all available services
		final ImageJ ij = new ImageJ();
		
		// ask the user for a file to open
//		final File file = ij.ui().chooseFile(null, "open");

		// load the dataset
	//	final Dataset dataset = ij.scifio().datasetIO().open(file.getPath());

		// display the dataset
		//ij.ui().show(dataset);
		ij.ui().showUI();

		
		// Find local extreme. 
		
		//float value = ip.getf(0, 0);
		//System.out.println(width + "x" + height + "x" + nFrames );

		Class<?> clazz = Evaluate_.class;
		String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
		String pluginsDir = url.substring("file:".length(), url.length() - clazz.getName().length() - ".class".length());
		System.setProperty("plugins.dir", pluginsDir);
		IJ.runPlugIn(clazz.getName(), "");
		
	}


	public void run(String arg0) { // Currently runs all sub algorithms, once plugin is done this will generate GUI to get user input and use button press to run sub algorithms.		
		/*
		 * Filter raw image.
		 */
		int W 			= 50; 	// Window width for median filtering, user input.
//		FilterRaw(W); 			// Filter selected image based on user input.

		
		
		/*
		 * Locate all events.
		 */
		double SN 					= 0.05;							// Future user input, signal to noise.
		int Distance 				= 5; 							// Future user input, minimum distance between center pixels in events to be included.
		int[] stepSize 				= {5,5};						// Stepsize in nm, user input.
		int gWindow 				= 7;							// Window width for gaussian fit.
	//	ArrayList<Particle> Results = Localize(SN,Distance, gWindow);	// Locate all particles.
		
		/*
		 * Filter out events based on user input quality settings and drift correct them.
		 */
		
		double[] lb 				= {-250,						// Allowed lower range of x drift in nm, user input.
									   -250,						// Allowed lower range of y drift in nm, user input.
									    0,						// Allowed lower range of sigma_x in nm, user input.
									    0,						// Allowed lower range of sigma_y in nm, user input.
									      0,						// Allowed lower range of precision_x in nm, user input.
									      0,						// Allowed lower range of precision_y in nm, user input.
									      0,						// Allowed lower range of chi_square, user input.
									    100							// Allowed lower range of photon count, user input.
										};  				
		double[] ub 				= {-250,						// Allowed upper range of x drift in nm, user input.
				   					   -250,						// Allowed upper range of y drift in nm, user input.
				   					   	300,						// Allowed upper range of sigma_x in nm, user input.
				   					   	300,						// Allowed upper range of sigma_y in nm, user input.
				   					   	300,						// Allowed upper range of precision_x in nm, user input.
				   					   	300,						// Allowed upper range of precision_y in nm, user input.
				   					   	1.0,						// Allowed upper range of chi_square, user input.
				   					   	5000							// Allowed upper range of photon count, user input.
											};  							
		double binFrac				= 0.02;							// Fraction of total frames in each bin for drift corrrection. User input.
		int nParticles 				= 1000;							// Maximal number of particles to use for drift correction in each step, user input.
		
		// test function
		int nFrames = 3000;
		int width	= 12800;
		int height 	= 12800;
		int perFrame= 10;
		int totalParticles = 1000;
 		ArrayList<Particle> Results = TestData.generate(nFrames, width, height, perFrame,totalParticles); // Replace with original version Localize above.
		 		
 		long start = System.nanoTime();
 		ArrayList<Particle> correctedResults = driftCorrect(Results, stepSize, lb,  ub, binFrac, nParticles);

 	//	int pixelsize = 5;
 		//generateImage.create("test",testResults, width, height, pixelsize);
 		//generateImage.create("test",correctedResults, width, height, pixelsize);
 		
 		
 		double epsilon  = 20;
 		int minPts 		= 3;
 		List<Cluster<DoublePoint>> ClustersFound = DBClust.Ident(epsilon, minPts, correctedResults);
/*	    for(Cluster<DoublePoint> c: ClustersFound){ // how to get access to all clusters.
	        System.out.println((c.getPoints().get(0)) +" "+  c.getPoints().size());	        
	    }*/   
	    System.out.println(ClustersFound.size());
	    
 		long stop = System.nanoTime();
 		System.out.println((stop-start)/1000000 + " ms");
		
		//System.exit(0);
	}
	
	/*
	 * FilterRaw does background corrections on selected image and creates a new imagestack of the same dimensions as output.
	 */
	public static void FilterRaw(int W){
		ImagePlus image 	= WindowManager.getCurrentImage();  	// Aquire the selected image.		
		ImageStack stack 	= image.getStack(); 					// This should be a stack
		int nFrames 		= image.getNFrames();					// Number of timepoints.
		int width 			= image.getHeight();					// Frame height (x);
		int height 			= image.getWidth(); 					// Frame width (y);					
		ImageStack ImStack 	= stack.convertToFloat(); 				// Change type, we want to work in double format.		
		double[][][] dataArray = new double[width][height][nFrames];// Array to put all data in.
		for (int Frame = 1; Frame <= nFrames; Frame++){ 			// Loop over the image and recast pixel data to double.
			float[] ImFrame = (float[]) ImStack.getPixels(Frame); 	// recast and pull out data. 
			int col = 0;
			int row = 0;
			for (int i = 0;i < ImFrame.length; i ++){
				dataArray[col][row][Frame-1] = ImFrame[i]; 			// Stack frame starts at 1, dataArray at 0.
				col++;
				if (col == width){
					col = 0;
					row++;
				}			
			}		
		} 
		double[] Corrected 	= BackgroundCorrection.medianFiltering2(dataArray, W); 	// Median filtered background with noise level.		
		ImageStack newStack = new ImageStack(width,height);							// Create new imagestack to hold background corrected data.
		for (int Frames = 0; Frames < nFrames; Frames++){ 							// Loop over all frames.
			float[] slice = new float[width*height]; 								// Hold pixel intensities for this slice.
			int count = 0; 															// Use to add data to the slice.
			for (int i = width*height*Frames; i < width*height*(Frames+1); i++){ 	// Loop over all pixels in the slice.
				slice[count] = (float) Corrected[i]; 								// Add pixel data.
				if (slice[count] < 0){ 												// Pixel data might be negative, set to 0 if so.
					slice[count] = 0;
				}	
				count++;															// Step forward in the slice.
			}
			newStack.addSlice(new FloatProcessor(width,height,slice)); 				// After slice has been populated, add it to the results stack at the end.
		}
		String Imtitle 			= "BackgroundCorrected_" + image.getTitle(); 		// Get the results stack new name.		
		ImagePlus FilteredImage =  new ImagePlus(Imtitle,newStack);					// Create new image from the result stack.
		FilteredImage.show(); 														// Make visible, ends FilterRaw
	} // end FilterRaw.

	/*
	 * Localize takes the currenly active imagestack and localizes particles based on user input settings. Returns an arraylist of non drift corrected particles.
	 */
	
	public static ArrayList<Particle> Localize( double SN, int Distance, int W){
		ImagePlus LocalizeImage = WindowManager.getCurrentImage();  // Aquire the selected image.
		ImageStack LocalizeStack = LocalizeImage.getStack(); 		// This should be a stack.
		ArrayList<Particle> Results = new ArrayList<Particle>();
		for (int Frame = 0; Frame < LocalizeStack.getSize();Frame++){
			ImageProcessor ImProc = LocalizeStack.getProcessor(Frame+1); 
			double Noise = 0;			
			Results.addAll(LocalizeEvents(ImProc,SN,Noise,Distance,W,Frame+1)); // Add fitted data.
		}					
		return Results;
	} // end Localize
	
	
	/*
	 * Correct for drift by maximizing the correlation function between bins of datapoints. return corrected arraylist of particles and plots the drift calculated.
	 */
	public static ArrayList<Particle> driftCorrect(ArrayList<Particle> locatedParticles, int[] stepSize, double[] lb, double[] ub,double BinFrac, int nParticles){
		
		
		ArrayList<Particle> correctedResults = new ArrayList<Particle>(); // Output arraylist, will contain all particles that fit user input requirements after drift correction. 
		int[] lb_xy 		= {(int) lb[0],(int) lb[1]};	// Pull out lower boundry of x and y drift.
		int[] ub_xy 		= {(int) ub[0],(int) ub[1]};	// Pull out upper boundry of x and y drift.		
		int idx 			= locatedParticles.size() - 1;
		
		double frameBin = Math.round( 				// Bin size for drift correction based on total number of frames and user input fraction. 
				locatedParticles.get(idx).frame * // Last frame that was used.
				BinFrac);							// User input fraction.
		ArrayList<Particle> filteredResults =  new ArrayList<Particle>(); // output arraylist.
		int[] timeIndex = new int[(int) (Math.round(1.0/BinFrac)+1)];
		double[] timeIndexDouble = new double[(int) (Math.round(1.0/BinFrac)+1)];
		int count = 0;		
		

		for (int i = 0; i < locatedParticles.size(); i++){
			if (	locatedParticles.get(i).sigma_x > lb[2] && // Check that all parameters are within user defined limits.
					locatedParticles.get(i).sigma_x < ub[2] &&
					locatedParticles.get(i).sigma_y > lb[3] &&
					locatedParticles.get(i).sigma_y < ub[3] &&
					locatedParticles.get(i).precision_x > lb[4] &&
					locatedParticles.get(i).precision_x < ub[4] &&					
					locatedParticles.get(i).precision_y > lb[5] &&
					locatedParticles.get(i).precision_y < ub[5] &&
					locatedParticles.get(i).chi_square > lb[6] &&
					locatedParticles.get(i).chi_square < ub[6] &&						
					locatedParticles.get(i).photons > lb[7] &&
					locatedParticles.get(i).photons < ub[7]
					){
					filteredResults.add(locatedParticles.get(i)); 	// Add particle							
			}
			if (locatedParticles.get(i).frame > frameBin*count){	// First time data from a new bin is added, register index.
				timeIndex[count] = i;
				timeIndexDouble[count] = locatedParticles.get(i).frame;
				count++;
			}
		}
		
		timeIndex[timeIndex.length-1] =  filteredResults.size(); 			// Final entry.
		timeIndexDouble[timeIndex.length-1] = locatedParticles.get(filteredResults.size()-1).frame; 		// Final entry.
		double[] lambdax = new double[(int) Math.round(1.0/BinFrac)];
		double[] lambday = new double[(int) Math.round(1.0/BinFrac)];
		lambdax[0] = 0;
		lambday[0] = 0;
		int maxTime =(int) timeIndexDouble[timeIndexDouble.length-1];
		double[][] lambda = new double[maxTime][2];
		for (int i = 1; i < Math.round(1.0/BinFrac) ; i++){ 				// Loop over all bins.
			ArrayList<Particle> Data1 	= new ArrayList<Particle>(); 	// Target particles.			
			int addedFrames1 			= 0;
			for (int j = timeIndex[i]; j < timeIndex[i+1];j++){
				if (addedFrames1 < nParticles &&
						filteredResults.get(j).frame < frameBin*(i+1)){
					Data1.add(filteredResults.get(j));
					addedFrames1++;
				}
			}			
			ArrayList<Particle> Data2 	= new ArrayList<Particle>(); 	// Change these particles so that the correlation function is maximized.
			int addedFrames2 			= 0;
			for (int j = timeIndex[i-1]; j < timeIndex[i];j++){
				if (addedFrames2 < nParticles &&
						filteredResults.get(j).frame < frameBin*i ){
					Data2.add(filteredResults.get(j));
					addedFrames2++;
				}
			}
			
			int[] roughStepsize  	= {stepSize[0]*5,stepSize[1]*5}; // increase stepSize for a first round of optimization. 
			double[] roughlambda	= AutoCorrelation.getLambda(Data1,Data2,roughStepsize,lb_xy,ub_xy); // Get rough estimate of lambda, drift.			
			int[] fineLb 			= {(int) (roughlambda[0] - stepSize[0]),(int) (roughlambda[1] - stepSize[1])}; 	// Narrow lower boundry.
			int[] fineUb 			= {(int) (roughlambda[0] + stepSize[0]),(int) (roughlambda[1] + stepSize[1])}; 	// Narrow upper boundry.
			double[] tempLamda 		= AutoCorrelation.getLambda(Data1,Data2,stepSize ,fineLb ,fineUb); 				// Get drift.
			lambdax[i] 				= tempLamda[0] + lambdax[i-1];
			lambday[i] 				= tempLamda[1] + lambday[i-1];	
		}
	
		
		int countx = lambda.length-1;
		int county = lambda.length-1;
		
		for (int j =  (int) (Math.round(1.0/BinFrac) - 1); j >0; j--){
			double[] temp 			= interp(lambdax[j],lambdax[j-1],(int) frameBin);
			for (int k = 0; k < temp.length; k++){
				lambda[countx][0] = temp[k];
				countx--;
			}
			double[] temp2 			= interp(lambday[j],lambday[j-1],(int) frameBin);
			for (int k = 0; k < temp2.length; k++){
				lambda[county][1] = temp2[k];
				county--;
			}
		}
		int[] timeV = new int[lambda.length];
		for (int i = 0; i < timeV.length;i++){
			timeV[i] = i;
		}		
		
		for (int i = 0; i < filteredResults.size(); i++){
			
			Particle tempPart = new Particle();
			tempPart.frame = filteredResults.get(i).frame;
			tempPart.chi_square = filteredResults.get(i).chi_square;
			tempPart.photons = filteredResults.get(i).photons;
			tempPart.precision_x = filteredResults.get(i).precision_x;
			tempPart.precision_y= filteredResults.get(i).precision_y;			
			tempPart.sigma_x = filteredResults.get(i).sigma_x;
			tempPart.sigma_y = filteredResults.get(i).sigma_x;

			tempPart.x = filteredResults.get(i).x - lambda[(int) tempPart.frame-1][0];
			tempPart.y = filteredResults.get(i).y - lambda[(int) tempPart.frame-1][1];
			correctedResults.add(tempPart);

			}
		double[] lx = new double[lambda.length];
		double[] ly = new double[lambda.length];
		for (int i = 0; i < lambda.length;i++){
			lx[i] = lambda[i][0];
			ly[i] = lambda[i][1];
		}
		plot(lx,ly,timeV);

		
		return correctedResults;
		
	}
	public static double[] interp(double X1, double X2, int n){
		double[] extendedX = new double[n]; 
		extendedX[0] = X1;
		extendedX[n-1] = X2;
		
		double step = (X2-X1)/(n-2);
		for (int i = 1; i < n-1; i++){
			extendedX[i] = extendedX[i-1] + step;
		}
		
		return extendedX;
	}
	
	public static ArrayList<Particle> LocalizeEvents(ImageProcessor IP, double SN, double Noise, int Distance, int Window, int Frame){
		float[][] DataArray 		= IP.getFloatArray();		
		ArrayList<int[]> Center 	= LocalMaxima.FindMaxima(DataArray, SN, Noise, Distance); // Get possibly relevant center coordinates.
		ArrayList<Particle> Results = ParticleFitter.Fitter(IP, Center, Window, Frame);			
		return Results;
					
	} // end LocalizeEvents
	
	static void plot(double[] values) {
	    double[] x = new double[values.length];
	    for (int i = 0; i < x.length; i++)
	        x[i] = i;
	    Plot plot = new Plot("Plot window", "x", "values", x, values);
	    plot.show();
	}
	static void plot(double[] values,int[] x_axis) {
	    double[] x = new double[values.length];
	    for (int i = 0; i < x.length; i++)
	        x[i] = x_axis[i];
	    Plot plot = new Plot("Plot window", "x", "values", x, values);
	    plot.show();
	}
	static void plot(double[] values, double[] values2,int[] x_axis) {
	    double[] x = new double[values.length];
	    for (int i = 0; i < x.length; i++)
	        x[i] = x_axis[i];
	    Plot plot = new Plot("Plot window", "x", "values", x, values);
	    plot.setColor(Color.GREEN);
	    plot.draw();
	    plot.addPoints(x, values, Plot.LINE);
	    
	    plot.setColor(Color.RED);
	    plot.draw();
	    plot.addPoints(x, values2, Plot.LINE);
	    
	    plot.addLegend("X: green" + "\n" + "Y: red");
	    plot.show();
	}
	
}