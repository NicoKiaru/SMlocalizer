//import java.awt.Color;

import java.io.File;
//import java.util.ArrayList;

import ij.IJ;

//import org.scijava.plugin.Plugin;
/*
import ij.ImagePlus;
import ij.ImageStack;
import ij.WindowManager;
import ij.gui.Plot;*/
import ij.plugin.PlugIn;
//import ij.process.ImageProcessor;
import net.imagej.Dataset;
import net.imagej.ImageJ;

/*
 * GUI should take these function calls with the listed pull out of user input.
 * Batch: Find out how to close windows, use the File file = ij.ui().chooseFile(null, "open"); several times to get the list of files (if not multiselect works. Close windows between calls.
 */

public class Evaluate implements PlugIn {

	public static void main(final String... args) throws Exception {
		// create the ImageJ application context with all available services
		final ImageJ ij = new ImageJ();

		// ask the user for a file to open
		final File file = ij.ui().chooseFile(null, "open");
		// load the dataset
		final Dataset dataset = ij.scifio().datasetIO().open(file.getPath());

		// display the dataset
		ij.ui().show(dataset);
		ij.ui().showUI();
		

		Class<?> clazz = Evaluate.class;
		String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
		String pluginsDir = url.substring("file:".length(), url.length() - clazz.getName().length() - ".class".length());
		System.setProperty("plugins.dir", pluginsDir);
		IJ.runPlugIn(clazz.getName(), "");
	}


	public void run(String arg0) { // Currently runs all sub algorithms, once plugin is done this will generate GUI to get user input and use button press to run sub algorithms.

		/*
		 * User input for filter background:
		 */
		int Window 	= 101;
		int W 		= (Window-1)/2;
		
		filterBackground.run(W); // Need to find out how multi channel images are organized for multi channel functions.
		
		
		/*
		 * User input for localization:
		 */
		
		int gWindow = 5;
		double SN = 2; 
		int Distance = 7;
		double Noise = 1000;
		int inputPixelSize = 100;
		
		localizeAndFit.run(SN, Distance, gWindow, Noise, inputPixelSize); // 2D. Need to find out how multi channel images are organized for multi channel functions.
	
		
		/*
		 * User input for drift correction:
		 */
		

		int[] lb 				= {-250,						// Allowed lower range of x drift in nm, user input.
									   -250,							// Allowed lower range of y drift in nm, user input.
									   0							// Allowed lower range of z drift in nm, user input.
		};  				
		int[] ub 				= {250,						// Allowed upper range of x drift in nm, user input.
									   250,						// Allowed upper range of y drift in nm, user input.
									   0						// Allowed upper range of z drift in nm, user input.
		};  							
		double BinFrac				= 0.02;							// Fraction of total frames in each bin for drift corrrection. User input.
		int nParticles 				= 1000;							// Maximal number of particles to use for drift correction in each step, user input.
		int minParticles 			= 500;
		int[] stepSize 				= {5,5,5};						// Stepsize in nm, user input.
		double Channels = 1;
		boolean AlignCh = false; // User input.
		cleanParticleList.run();
		correctDrift.run(lb, ub, BinFrac, nParticles, minParticles, stepSize,Channels,AlignCh); // 3D version now requires doublechecking. Also handles multi channel data.
		
		/*
		 * User input for cluster analysis
		 */
		double epsilon = 10;
		int minConnectingPoints = 5;
		DBClust.Ident(epsilon, minConnectingPoints); // Unsure if it handles 3D points, need to check. Not yet multi channel.
		
		/*
		 * User input for render results
		 */
		inputPixelSize 		= 100;
		int DesiredPixelSize 	= 5;
		renderImage.run(inputPixelSize,DesiredPixelSize); // Not 3D yet, how to implement? Need to find out how multi channel images are organized for multi channel functions.

	}
	

	/*
	 * FilterRaw does background corrections on selected image and creates a new imagestack of the same dimensions as output.
	 */
/*	public static void FilterRaw(int W){
		ImagePlus image 	= WindowManager.getCurrentImage();  	// Aquire the selected image.		
		ImageStack stack 	= image.getStack(); 					// This should be a stack
		ImageStack CorrectedStack 	= BackgroundCorrection.medianFiltering(stack, W); 	// Median filtered background with noise level.		
		String Imtitle 			= "BackgroundCorrected_" + image.getTitle(); 		// Get the results stack new name.		
		ImagePlus FilteredImage =  new ImagePlus(Imtitle,CorrectedStack);					// Create new image from the result stack.
		FilteredImage.show(); 														// Make visible, ends FilterRaw*/
//	} // end FilterRaw.


	/*
	 * Localize takes the currenly active imagestack and localizes particles based on user input settings. Returns an arraylist of non drift corrected particles.
	 */
/*	public static void Localize(double SN, int Distance, int W,int pixelSize, double Noise){
		ImagePlus LocalizeImage = WindowManager.getCurrentImage();  // Acquire the selected image.
		ImageStack LocalizeStack = LocalizeImage.getStack(); 		// This should be a stack.
		ArrayList<Particle> Results = new ArrayList<Particle>();
		for (int Frame = 0; Frame < LocalizeStack.getSize();Frame++){
			ImageProcessor ImProc = LocalizeStack.getProcessor(Frame+1); 			
			Results.addAll(LocalizeEvents(ImProc,SN,Noise,Distance,W,Frame+1,pixelSize)); // Add fitted data.
		}					
		
		TableIO.Store(Results);
	} // end Localize


	/*
	 * Correct for drift by maximizing the correlation function between bins of datapoints. return corrected arraylist of particles and plots the drift calculated.
	 */
/*	public static void driftCorrect(int minNrParticles, int[] stepSize, double[] lb, double[] ub,double BinFrac, int nParticles){
		ArrayList<Particle> locatedParticles = TableIO.Load(); // Get current table data.
		System.out.println("driftCorrect: " + locatedParticles.size());
		ArrayList<Particle> correctedResults = new ArrayList<Particle>(); // Output arraylist, will contain all particles that fit user input requirements after drift correction. 
		int[] lb_xy 		= {(int) lb[0],(int) lb[1]};	// Pull out lower boundry of x and y drift.
		int[] ub_xy 		= {(int) ub[0],(int) ub[1]};	// Pull out upper boundry of x and y drift.		
		int idx 			= locatedParticles.size() - 1;

		double frameBin = Math.round( 				// Bin size for drift correction based on total number of frames and user input fraction. 
				locatedParticles.get(idx).frame * 	// Last frame that was used.
				BinFrac);							// User input fraction.
		ArrayList<Particle> filteredResults =  new ArrayList<Particle>(); // output arraylist.
		int[] timeIndex = new int[(int) (Math.round(1.0/BinFrac)+1)];
		double[] timeIndexDouble = new double[(int) (Math.round(1.0/BinFrac)+1)];
		int count = 0;		

		// Check which particles are within user set parameters.
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
				filteredResults.add(locatedParticles.get(i)); 	// Add particles that match user set parameters.					

				if (filteredResults.get(filteredResults.size()-1).frame > frameBin*count){	// First time data from a new bin is added, register index.
					timeIndex[count] = filteredResults.size() - 1; // Get the index for the first entry with the new bin.
					timeIndexDouble[count] = filteredResults.get(filteredResults.size()-1).frame;
					count++;
				}
			}
		}

		timeIndex[timeIndex.length-1] =  filteredResults.size(); 									// Final entry.
		timeIndexDouble[timeIndex.length-1] = filteredResults.get(filteredResults.size()-1).frame; 	// Final entry.
		double[] lambdax = new double[(int) Math.round(1.0/BinFrac)];								// Holds drift estimate between all bins in x.
		double[] lambday = new double[(int) Math.round(1.0/BinFrac)];								// Holds drift estimate between all bins in y.
		lambdax[0] = 0;																				// Drift for first bin is 0.
		lambday[0] = 0;																				// Drift for first bin is 0.
		int maxTime =(int) timeIndexDouble[timeIndexDouble.length-1]; 								// Last frame included.
		double[][] lambda = new double[maxTime][2];													// Holds interpolated drift corrections in x and y.
		int okBins = 0;																				// If all bins are ok, this will still be 0.
		for (int i = 1; i < timeIndex.length ; i++){ 												// Loop over all bins.
			if ((timeIndex[i] - timeIndex[i-1])<minNrParticles){									// If the bin lacks enough points to meet user minimum criteria.
				okBins++;				
			}
		}
		if (okBins == 0){ 														// If all bins were ok.
			for (int i = 1; i < Math.round(1.0/BinFrac) ; i++){ 				// Loop over all bins.
				ArrayList<Particle> Data1 	= new ArrayList<Particle>(); 		// Target particles.			
				int addedFrames1 			= 0;								// Number of particles added to the bin.
				for (int j = timeIndex[i]; j < timeIndex[i+1];j++){
					if (addedFrames1 < nParticles &&
							filteredResults.get(j).frame < frameBin*(i+1)){
						Data1.add(filteredResults.get(j));
						addedFrames1++;
					}
				}			
				ArrayList<Particle> Data2 	= new ArrayList<Particle>(); 		// Change these particles so that the correlation function is maximized.
				int addedFrames2 			= 0;								// Number of particles added to the bin.
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

				Particle tempPart 	= new Particle();
				tempPart.frame	 	= filteredResults.get(i).frame;
				tempPart.chi_square = filteredResults.get(i).chi_square;
				tempPart.photons 	= filteredResults.get(i).photons;
				tempPart.precision_x= filteredResults.get(i).precision_x;
				tempPart.precision_y= filteredResults.get(i).precision_y;			
				tempPart.sigma_x 	= filteredResults.get(i).sigma_x;
				tempPart.sigma_y 	= filteredResults.get(i).sigma_x;

				tempPart.x = filteredResults.get(i).x - lambda[(int) tempPart.frame-1][0];
				tempPart.y = filteredResults.get(i).y - lambda[(int) tempPart.frame-1][1];
				correctedResults.add(tempPart);
			}
			double[] lx = new double[lambda.length];
			double[] ly = new double[lambda.length];
			for (int i 	= 0; i < lambda.length;i++){
				lx[i] 	= lambda[i][0];
				ly[i]	= lambda[i][1];
			}
			plot(lx,ly,timeV);
			TableIO.Store(correctedResults);
		}
		System.out.println("No drift correction possible, not enough particles in each bin.");		
	}
	
	/*
	 * Interpolate between two values for n number of total entries in the new vector.
	 */
/*	public static double[] interp(double X1, double X2, int n){
		double[] extendedX 	= new double[n]; 
		extendedX[0] 		= X1;
		extendedX[n-1] 		= X2;

		double step 		= (X2-X1)/(n-2);
		for (int i = 1; i < n-1; i++){
			extendedX[i] = extendedX[i-1] + step;
		}

		return extendedX;
	}
	
	/*
	 * Localize all events in the frame represented by ImageProcessor IP. Starts by finding regions of interest and follows by doing gaussian fitting of the regions.
	 */
/*	public static ArrayList<Particle> LocalizeEvents(ImageProcessor IP, double SN, double Noise, int Distance, int Window, int Frame,int pixelSize){
		float[][] DataArray 		= IP.getFloatArray();												// Array representing the frame.
		ArrayList<int[]> Center 	= LocalMaxima.FindMaxima(DataArray, Window, SN, Noise, Distance); 	// Get possibly relevant center coordinates.	
		ArrayList<Particle> Results = ParticleFitter.Fitter(IP, Center, Window, Frame, pixelSize);		// Fit all found centers to gaussian.
		return Results;																					// Results contain all particles located.
	} // end LocalizeEvents

	/*
	 * Supporting plot functions
	 */
/*	static void plot(double[] values) {
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
*/
}