package es.exoPr.imageModification.imageFilters;

/**
 * This filter implements a method to execute functional interfaces with double values
 * 
 * @author ismael.gonjal
 *
 */
public interface FilterExecutableInterface {
	/**
	 * runs an execution of a filter
	 * @param d the parameters
	 * @return a resolved array with pixels
	 */
	public double[] execute(double[] ... d);
	
	public int numOfParameters();
	
	
	
}
