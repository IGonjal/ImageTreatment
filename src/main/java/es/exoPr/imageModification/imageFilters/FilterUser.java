package es.exoPr.imageModification.imageFilters;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class FilterUser {
	


	public FilterUser(){

	}
	
	/**
	 * Use a filter into a matrix
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	public Mat use(Mat origin, ThresholdFilter filter) {
		Mat destiny = origin.clone();
		
		Size s = origin.size();
		int row = (int) s.height;
		int column = (int) s.width;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				//get y put son operaciones a nivel pixel
				double[][] obtained = {origin.get(i, j)};
				double[] insertion = filter.execute(obtained);
				destiny.put(i, j, insertion);
			}
			
		}
		return destiny;
	}
	/**
	 * Use a filter into a matrix but only on a channel
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	public Mat use(Mat origin, ThresholdFilter filter, boolean[] channel) {
		boolean[] oldchan = PublicVariables.getChannels();
		PublicVariables.setChannels(channel);
		
		Mat ret =use(origin, filter);
		
		PublicVariables.setChannels(oldchan);
		return ret;
	}
	
}
