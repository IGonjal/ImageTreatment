package es.exoPr.imageModification.imageFilters.filterEnums;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class FilterUser {
	
	/**
	 * Use a filter into a matrix
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	private Mat use(Mat origin, ThresholdType filter, double threshold) {
		Mat destiny = origin.clone();
		
		double thr = PublicVariables.getThresholdColor();
		PublicVariables.setThresholdColor(threshold);
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
		PublicVariables.setThresholdColor(thr);
		return destiny;
	}
	
	/**
	 * Use a filter into a matrix but only on a channel
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	public Mat use(Mat origin, ThresholdType filter,double thr , boolean[] channel) {
		boolean[] oldchan = PublicVariables.getChannels();
		PublicVariables.setChannels(channel);
		
		Mat ret =use(origin, filter, thr);
		
		PublicVariables.setChannels(oldchan);
		return ret;
	}
	
	/**
	 * Use a filter into a matrix but only on a channel
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	public Mat use(Mat origin1, Mat origin2, PixelCombinationFilter filter, boolean[] channel) {
		boolean[] oldchan = PublicVariables.getChannels();
		PublicVariables.setChannels(channel);
		
		Mat ret =use(origin1, origin2, filter);
		
		PublicVariables.setChannels(oldchan);
		return ret;
	}
	
	/**
	 * Use a filter into a matrix
	 * 
	 * @param filter the filter
	 * @return the matrix with the filter processed
	 */
	public Mat use(Mat origin1,Mat origin2 , PixelCombinationFilter filter) {
		Mat destiny = origin1.clone();
		
		Size s = origin1.size();
		
		int row = (int) s.height;
		int column = (int) s.width;
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				//get y put son operaciones a nivel pixel
				double[][] obtained = {origin1.get(i, j), origin2.get(i, j)};
				double[] insertion = filter.execute(obtained);
				destiny.put(i, j, insertion);
			}
			
		}
		return destiny;
	}
}
