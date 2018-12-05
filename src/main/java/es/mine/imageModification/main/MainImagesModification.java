package es.mine.imageModification.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.FilterUser;
import es.exoPr.imageModification.imageFilters.ThresholdFilter;

public class MainImagesModification {

	public static void main(String[] args) {
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread("c:\\image.jpg");
		
		FilterUser filterUser = new FilterUser();
		
		try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\ORIGINAL.jpg"));){
			Files.copy(new File("c:\\image.jpg").toPath(), fos);
		} catch (IOException e) {
		}
		
		// 7 al ser un número de 3 bits
		for(ThresholdFilter t : ThresholdFilter.values()) {
			for(int i = 1; i <= 7; i++) {
				boolean[] channels = {(i&4)==4, (i&2)==2, (i&1)==1};
				System.out.println(Arrays.toString(channels) + " - "+ i +" - "+ Integer.toBinaryString(i) + " - " + t.getName());
				Mat destiny = filterUser.use(origin,t, channels);
				Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\"+t.getName().replace(" ", "") +"_" +i +".jpg", destiny);
			}
		}		
	}

}
