package es.mine.imageModification.filters;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class FilterUser {
	
	Mat origin;
	Filters filter;
	FilterUser(Mat in, Filters f){
		origin = in;
		filter = f;
	}
	
	public Mat use() {
		Mat destiny = origin.clone();
		
		Size s = origin.size();
		int row = (int) s.height;
		int column = (int) s.width;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				double[] d = origin.get(i, j);
				for(int k = 0; k < d.length ; k++) {
					
					d  = filter.execute(d);
					
				}
				destiny.put(i, j, d);
			}
			System.out.println("linea " + i);
		}
		return destiny;
	}
}
