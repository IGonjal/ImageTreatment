package es.mine.imageModification.main;

import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.FilterUser;
import es.exoPr.imageModification.imageFilters.ThresholdFilter;

public class MainImagesModification {

	public static void main(String[] args) {
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread("c:\\image.jpg");
		
		FilterUser filterUser = new FilterUser();
		
		// 7 al ser un número de 3 bits
		for(int i = 0; i <= 7; i++) {
			boolean[] channels = {(i&1)==1,(i&3)==3, (i&5)==5};
			System.out.println(Arrays.toString(channels));
			for(ThresholdFilter t : ThresholdFilter.values()) {
				Mat destiny = filterUser.use(origin,t, channels);
				Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\"+t.getName().replace(" ", "") +"_" +i +".jpg", destiny);
			}
		}		
	}

}
