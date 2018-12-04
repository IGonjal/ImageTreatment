package es.mine.openCV.filters;

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
		THRESHOLD_TO_TOP( Filters::treshold_to_top );
	
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
	
	
	private static double[] treshold_to_top(double d[]) {

		double[] d2 = new double[d.length]; 
		for(int i =0; i<d.length; i++) {
			if(d2[i] >= PublicVariables.getThresholdColor()) {
				d2[i] = 255;
			}else {
				d2[i] = 0;
			}
		}
		
		return d2;
	}
}
