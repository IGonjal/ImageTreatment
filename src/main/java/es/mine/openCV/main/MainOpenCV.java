package es.mine.openCV.main;

import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.core.Range;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MainOpenCV {

	public static void main(String[] args) {
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread("c:\\image.jpg");
		Mat destiny = origin.clone();
		Size s = origin.size();
		int row = (int) s.height;
		int column = (int) s.width;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < column ; j++) {
				double[] d = origin.get(i, j);
				for(int k = 0; k < d.length ; k++) {
					if(d[k] > 125d) {
						d[k] = 255d;
					}else {
						d[k] = 0d;
					}
				}
				destiny.put(i, j, d);
			}
			System.out.println("linea " + i);
		}
		
		
		
		
		//destiny = origin.colRange(new Range(0,3));
		
		
		/*
		Size size = origin.size();
		Imgproc.cvtColor(origin, destiny, Imgproc.COLOR_BGR2RGB);
		for(double i = 0d; i< size.height; i++) {
			for(double j = 0d; j < size.width; j++) {
				origin.get(i, j);
			}
		}*/
		//System.out.println(origin.get(0, 0));
		
		
		
		Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\NuevoArch.jpg", destiny);
	}

}
