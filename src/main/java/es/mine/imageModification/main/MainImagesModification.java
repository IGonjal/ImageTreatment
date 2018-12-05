package es.mine.imageModification.main;

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
		
		FilterUser filterUser = new FilterUser(origin);
		int i = 1;
		for(ThresholdFilter t : ThresholdFilter.values()) {
			Mat destiny = filterUser.use(t);
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\"+t.getName().replace(" ", "") +".jpg", destiny);
		}
		
	}

}
