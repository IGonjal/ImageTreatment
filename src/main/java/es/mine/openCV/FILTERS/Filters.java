package es.mine.openCV.filters;

import java.util.function.Function;

public enum Filters {
		THRESHOLD_TO_TOP( Filters::treshold_to_top );
	
	private Filters(Function<double[], double[]>  f){
		foo = f;
	}
	
	public double[] execute(double d[]) {
		return foo.apply(d);
	}
	
	
	private Function<double[], double[]> foo;
	
	
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
