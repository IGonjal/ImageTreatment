package es.exoPr.imageModification.imageFilters.filterEnums;

import java.util.function.Function;

/**
 * This enum file has bonded functions (all of them present on this same class) in order to
 * run them when running the method "execute", this will make easier the execution of different
 * functions with the type double[] -> double[]
 * 
 * @author ismael.gonjal
 *
 */
public enum ThresholdType implements FilterExecutableInterface{
		INVERT(ThresholdType::invert),
		ABSOLUTE(ThresholdType::absolute),
		LOWER_MANTAIN(ThresholdType::lowerMantain),
		UPPER_MANTAIN(ThresholdType::upperMantain),
		LOWER_ENHANCE(ThresholdType::lowerEnhance),
		UPPER_ENHANCE(ThresholdType::upperEnhance),
		TO_HIGH(ThresholdType::toHigh),
		TO_LOW(ThresholdType::toLow);

	
	private Function<Double, Double> function;
	/**
	 * This function
	 * @param f
	 */
	private ThresholdType(Function<Double, Double>  f){
		function = f;
	}

	@Override
	public double[] execute(double[]... d) {
		if (d.length != numOfParameters()) throw new UnsupportedOperationException("Operacion solo aceptada con 1 parametros");
		
		double[] d1 = d[0];
		double[] d2 = new double[d1.length];
		
		for(int i =0; i<d1.length; i++) {
			if(PublicVariables.getChannels()[i]) {
				
				d2[i] = function.apply(d1[i]);
				
			}else {
				d2[i] = d1[i];
			}
		}
		return d2;
	}
	@Override
	public int numOfParameters() {
		return 1;
	}
	
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
	 * @param d the double 
	 * @return the thresholded double
	 */
	private static double absolute(double d) { 
		
		if(d > getThreshold()) {
			return getMaxColor();
		}else{
			return getMinColor();
		}
	}
	
	/**
	 * This method applies a threshold puting to the max value everything 
	 * bigger than the threshold and to the min value everything lower
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double invert(double d) {
		if(d >= getThreshold()) {
			return d - getThreshold();
		}else{
			return d + getThreshold();
		}
	}
	/**
	 * This method applies a threshold mantainining everything higher than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double upperMantain(double d) {
		if(d >= getThreshold()) {
			return d;
		}else {
			return getThreshold();
		}
	}
	/**
	 * This method applies a threshold mantainining everything lower than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double lowerMantain(double d) {
		if(d <= getThreshold()) {
			return d;
		}else {
			return getMinColor();
		}

	}
	/**
	 * This method applies a threshold enhancing to the max value everything higher than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double upperEnhance(double d) {

			if(d >= getThreshold()) {
				return getMaxColor();
			}else {
				return d;
			}
	}
	/**
	 * This method applies a threshold enhancing to the max value everything lower than the threshold
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double lowerEnhance(double d) {
			if(d <= getThreshold()) {
				return getMaxColor();
			}else {
				return d;
			}
	}
	/**
	 * This method sets the value to the highest value
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double toHigh(double d) {

		return getMaxColor();

	}
	/**
	 * This method sets the value to the highest value
	 * 
	 * @param d the double array
	 * @return the thresholded array
	 */
	private static double toLow(double d) {
		return getMinColor();
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
