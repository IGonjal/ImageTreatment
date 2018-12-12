package es.exoPr.imageModification.imageFilters;

import java.util.function.Function;

public enum LocalFilter implements FilterExecutableInterface {
	
	;
	
	
	private Function<Double,Double> function;
	/**
	 * This function
	 * @param f
	 */
	private LocalFilter(Function<Double, Double>  f){
		function = f;
	}

	@Override
	public double[] execute(double[]... d) {
		if(d.length != 1) {
			throw new UnsupportedOperationException("Numero incorrecto de operaciones");
		}
		double[] d2 = new double[d[0].length];
		double[] dd = d[0];
		
		for(int i =0; i<d.length; i++) {
			if(PublicVariables.getChannels()[i]) {
				d2[i] = function.apply(dd[i]);
			}else {
				d2[i] = dd[i];
			}
		}
		return null;
	}

	
	@Override
	public int numOfParameters() {
		// TODO Auto-generated method stub
		return 0;
	}

}
