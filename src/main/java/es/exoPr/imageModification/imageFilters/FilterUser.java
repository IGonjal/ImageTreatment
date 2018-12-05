package es.exoPr.imageModification.imageFilters;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class FilterUser {
	
	Mat origin;

	public FilterUser(Mat in){
		origin = in;

	}
	
	public Mat use(Filters filter) {
		Mat destiny = origin.clone();
		
		Size s = origin.size();
		int row = (int) s.height;
		int column = (int) s.width;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				
				destiny.put(i, j, filter.execute(origin.get(i, j)));
				
			}
			
		}
		return destiny;
	}
	
}
