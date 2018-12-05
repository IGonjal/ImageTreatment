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
public enum ThresholdFilter {
		INVERT(ThresholdFilter::invert),
		ABSOLUTE(ThresholdFilter::absolute),
		LOWER_MANTAIN(ThresholdFilter::lowerMantain),
		UPPER_MANTAIN(ThresholdFilter::upperMantain),
		LOWER_ENHANCE(ThresholdFilter::lowerEnhance),
		UPPER_ENHANCE(ThresholdFilter::upperEnhance),
		TO_HIGH(ThresholdFilter::toHigh),
		TO_LOW(ThresholdFilter::toLow);

	/**
	 * This function
	 * @param f
	 */
	private ThresholdFilter(Function<double[], double[]>  f){
		doubleToDoubleFunction = f;
	}
	
	public double[] execute(double[] d) {
		return doubleToDoubleFunction.apply(d);
	}
	
	
	private Function<double[], double[]> doubleToDoubleFunction;
	
	
	
	/**
	 * Returns the name of the filter
	 * @return the name
	 */
	public String getName() {
		return this.name().replaceAll("_", " ").toUpperCase();
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
		for(int i = 0 ; i < d.length ; i++) {
			if(PublicVariables.getChannels()[i]) {
				if(d[i] > getThreshold()) {
					d2[i] = getMaxColor();
				}else{
					d2[i] = getMinColor();
				}
			}else {
				d2[i] = d[i];
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
		
		double[] d2 = new double[d.length]; 
		for(int i = 0 ; i < d.length ; i++) {
			if(PublicVariables.getChannels()[i]) {
				if(d[i] > getThreshold()) {
					d2[i] = d[i] - getThreshold();
				}else if(d[i] < getThreshold()){
					d2[i] = d[i] + getThreshold();
				}
			}else {
				d2[i] = d[i];
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
			if(PublicVariables.getChannels()[i]) {
				if(d[i] >= getThreshold()) {
					d2[i] = d[i];
				}else {
					d2[i] = getThreshold();
				}
			}else {
				d2[i] = d[i];
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
			if(PublicVariables.getChannels()[i]) {
				if(d[i] <= getThreshold()) {
					d2[i] = d[i];
				}else {
					d2[i] = getMinColor();
				}
			}else {
				d2[i] = d[i];
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
			
			if(d[i] >= getThreshold() && PublicVariables.getChannels()[i]) {
				d2[i] = getMaxColor();
			}else {
				d2[i] = d[i];
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
			if(d[i] <= getThreshold() && PublicVariables.getChannels()[i]) {
				d2[i] = getMaxColor();
			}else {
				d2[i] = d[i];
			}
		}
		
		return d2;
	}
	/**
	 * This method sets the value to the highest value
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] toHigh(double[] d) {
		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(PublicVariables.getChannels()[i]) {
				d2[i] = getMaxColor();
			}else {
				d2[i] = d[i];
			}
		}
		return d2;
	}
	/**
	 * This method sets the value to the highest value
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double[] toLow(double[] d) {
		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(PublicVariables.getChannels()[i]) {
				d2[i] = getMinColor();
			}else {
				d2[i] = d[i];
			}
		}
		return d2;
	}	
	
	private static double getMaxColor() {
		return PublicVariables.getMaxColor();
	}
	private static double getMinColor() {
		return PublicVariables.getMinColor();
	}
	private static double getThreshold() {
		return PublicVariables.getThresholdColor();
	}
}
