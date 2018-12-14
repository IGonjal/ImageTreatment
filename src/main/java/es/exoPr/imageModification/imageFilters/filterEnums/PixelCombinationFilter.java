package es.exoPr.imageModification.imageFilters.filterEnums;

public enum PixelCombinationFilter implements FilterExecutableInterface{
	BALANCED_MIX(PixelCombinationFilter::balancedMix),
	UNBALANCED_FIRST_STRONG_1_7(PixelCombinationFilter::strongFirstMix015),
	UNBALANCED_FIRST_STRONG_1_5(PixelCombinationFilter::averageIteratingFirst),
	PLUS_UPTO_TOP(PixelCombinationFilter::plusUpToTop);
	
	
	/**
	 * One kind of lambda expresion accepting two parameters and returning one
	 * @author ismael.gonjal
	 *
	 * @param <X> first argument
	 * @param <Y> second argument
	 * @param <Z> return type
	 */
	@FunctionalInterface
	interface Function<X,Y,Z>{
		public Z apply(X x, Y y);
	}
	
	/**
	 * definimos la existencia de la función 
	 */
	private Function<Double,Double,Double> function;
	private PixelCombinationFilter(Function<Double, Double, Double> foo) {
		function = foo;
	}
	
	
	public String getName() {
		return this.name().toLowerCase().replace("_", " ");
	}


	private static double balancedMix(double d1, double d2) {
		return d1 + d2 /2;
	}
	private static double plusUpToTop(double d1, double d2) {
		return (d1+d2>PublicVariables.getMinColor())? PublicVariables.getMinColor() : d1+d2;
	}
	private static double strongFirstMix015(double d1, double d2) {
		return (d1*1.7d) + (d2*0.3d) / 2;
	}
	
	private static double averageIteratingFirst(double d1, double d2) {
		return ((((d1+d2) /2) +d1) /2); 	
		}

	/**
	 * This function uses abstractly functions in class members
	 * @param d1
	 * @param d2
	 * @return
	 */
	@Override
	public double[] execute(double[]... d) {
		if (d.length != numOfParameters()) throw new UnsupportedOperationException("Operacion solo aceptada con 1 parametros");
		double[] d1 = d[0];
		double[] d2 = d[1];
		
		double[] d3= new double[d1.length];
		
		
		if(d1.length != d2.length) {
			return d3;
		}
		for(int i =0; i<d1.length; i++) {
			if(PublicVariables.getChannels()[i]) {
				if(PublicVariables.DEFAULT_MIX[i].equals(PublicVariables.MixingChannels.FIRST)) {
					d3[i] = d1[i];
				}else if(PublicVariables.DEFAULT_MIX[i].equals(PublicVariables.MixingChannels.SECOND)) {
					d3[i] = d2[i];
				}else {
					d3[i] = function.apply(d1[i], d2[i]);
				}
			}
		}
		
		
		return d3;
	}
	
	@Override
	public int numOfParameters() {
		return 2;
	}
}
