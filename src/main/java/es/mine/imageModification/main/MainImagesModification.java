package es.mine.imageModification.main;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.FilterUser;
import es.exoPr.imageModification.imageFilters.Filters;

public class MainImagesModification {

	public static void main(String[] args) {
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread("c:\\image.jpg");
		
		FilterUser filterUser = new FilterUser(origin);
		
		Mat destiny = filterUser.use(Filters.ABSOLUTE);
				
		Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\NuevoArch.jpg", destiny);
	}

}
