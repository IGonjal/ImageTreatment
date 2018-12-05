package es.mine.imageModification.imageFilters;

import java.util.function.Function;

/**
 * This enum file has bonded functions (all of them present on this same class) in order to
 * run them when running the method "execute", this will make easier the execution of different
 * functions with the type double[] -> double[]
 * 
 * @author ismael.gonjal
 *
 */
public enum Filters {
		UPPER_THRESHOLD_TO_TOP( Filters::thresholdToTop ),
		UPPER_THRESHOLD_MANTAIN(Filters::upperThresholdMantain);
	
	/**
	 * This function
	 * @param f
	 */
	private Filters(Function<double[], double[]>  f){
		doubleToDoubleFunction = f;
	}
	
	public double[] execute(double d[]) {
		return doubleToDoubleFunction.apply(d);
	}
	
	
	private Function<double[], double[]> doubleToDoubleFunction;
	
	
	
	
	
	
	
	/*
	 * Functions are the ones bonded to the enumeration members 
	 * 
	 */
	
	
	
	/**
	 * This method applies a threshold puting to the max value everything 
	 * bigger than the threshold 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] thresholdToTop(double[] d) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] >= PublicVariables.getThresholdColor()) {
				d2[i] = PublicVariables.getMaxColor();
			}else {
				d2[i] = PublicVariables.getMinColor();
			}
		}
		
		return d2;
	}
	/**
	 * This method applies a threshold mantainining everything bigger than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] upperThresholdMantain(double[] d) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] >= PublicVariables.getThresholdColor()) {
				d2[i] = d[i];
			}else {
				d2[i] = PublicVariables.getMinColor();
			}
		}
		
		return d2;
	}
}
