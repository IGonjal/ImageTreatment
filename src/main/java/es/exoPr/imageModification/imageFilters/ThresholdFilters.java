package es.exoPr.imageModification.imageFilters;

import java.util.function.Function;

/**
 * This enum file has bonded functions (all of them present on this same class) in order to
 * run them when running the method "execute", this will make easier the execution of different
 * functions with the type double[] -> double[]
 * 
 * @author ismael.gonjal
 *
 */
public enum ThresholdFilters {
		INVERT(ThresholdFilters::invert),
		ABSOLUTE(ThresholdFilters::absolute),
		LOWER_MANTAIN(ThresholdFilters::lowerMantain),
		UPPER_MANTAIN(ThresholdFilters::upperMantain),
		LOWER_ENHANCE(ThresholdFilters::lowerEnhance),
		UPPER_ENHANCE(ThresholdFilters::upperEnhance);
	

	/**
	 * This function
	 * @param f
	 */
	private ThresholdFilters(Function<double[], double[]>  f){
		doubleToDoubleFunction = f;
	}
	
	public double[] execute(double d[]) {
		return doubleToDoubleFunction.apply(d);
	}
	
	
	private Function<double[], double[]> doubleToDoubleFunction;
	
	
	
	/**
	 * Returns the name of the filter
	 * @return the name
	 */
	public String getName() {
		return this.getName().replaceAll("_", " ").toUpperCase();
	}
	
	
	/*
	 * Functions are the ones bonded to the enumeration members 
	 * 
	 */
	
	
	
	/**
	 * This method applies a threshold puting to the max value everything 
	 * bigger than the threshold and to the min value everything lower
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] absolute(double[] d) {

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
	 * This method applies a threshold puting to the max value everything 
	 * bigger than the threshold and to the min value everything lower
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] invert(double[] d) {
		int treshold = PublicVariables.getThresholdColor();
		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] > treshold) {
				
				d2[i] = d2[i] - treshold;
			}else if(d2[i] < treshold){
				d2[i] = d2[i] + treshold;
			}
		}
		
		return d2;
	}
	/**
	 * This method applies a threshold mantainining everything higher than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] upperMantain(double[] d) {

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
	/**
	 * This method applies a threshold mantainining everything lower than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] lowerMantain(double[] d) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] <= PublicVariables.getThresholdColor()) {
				d2[i] = d[i];
			}else {
				d2[i] = PublicVariables.getMinColor();
			}
		}
		
		return d2;
	}
	/**
	 * This method applies a threshold enhancing to the max value everything higher than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] upperEnhance(double[] d) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] >= PublicVariables.getThresholdColor()) {
				d2[i] = PublicVariables.getMaxColor();
			}
		}
		
		return d2;
	}
	/**
	 * This method applies a threshold enhancing to the max value everything lower than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] lowerEnhance(double[] d) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] <= PublicVariables.getThresholdColor()) {
				d2[i] = PublicVariables.getMaxColor();
			}
		}
		
		return d2;
	}

}
