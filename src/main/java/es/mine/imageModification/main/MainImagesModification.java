package es.mine.imageModification.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.FilterUser;
import es.exoPr.imageModification.imageFilters.PixelCombinationFilter;
import es.exoPr.imageModification.imageFilters.ThresholdFilter;

public class MainImagesModification {

	public static void main(String[] args) {
		String s[] = {"c:\\enrico.jpg","c:\\enrico2.jpg"};
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread(s[0]);
		Mat origin2 = Imgcodecs.imread(s[1]);
		FilterUser filterUser = new FilterUser();
		
		
		try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\ORIGINAL.jpg"));){
			Files.copy(new File(s[0]).toPath(), fos);
		} catch (IOException e) {}
		try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\ORIGINAL2.jpg"));){
			Files.copy(new File(s[1]).toPath(), fos);
		} catch (IOException e) {}
		
		// 7 al ser un número de 3 bits
		for(ThresholdFilter t : ThresholdFilter.values()) {
			for(int i = 1; i <= 7; i++) {
				if(i ==5) {
					System.out.println("staph");
				}
				boolean[] channels = {(i&4)==4, (i&2)==2, (i&1)==1};
				System.out.println(Arrays.toString(channels) + " - "+ i +" - "+ Integer.toBinaryString(i) + " - " + t.getName());
				Mat destiny = filterUser.use(origin,t, channels);
				Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\"+t.getName().replace(" ", "") +"_" +i +".jpg", destiny);
			}
		}
		// 7 al ser un número de 3 bits
		for(ThresholdFilter t1 : ThresholdFilter.values()) {
			for(ThresholdFilter t2 : ThresholdFilter.values()) {
				for(int i = 1; i <= 7; i++) {
					boolean[] channels = {(i&4)==4, (i&2)==2, (i&1)==1};
					for(PixelCombinationFilter f : PixelCombinationFilter.values()) {
						System.out.println(Arrays.toString(channels) + " - "+ i +" - "+ Integer.toBinaryString(i) + " - " +f.getName() + "("+ t1.getName() +" , "+t2.getName()+")" );
						Mat aux1 = filterUser.use(origin,t1, channels);
						Mat aux2 = filterUser.use(origin2,t2, channels);
						Mat destiny = filterUser.use(aux1,aux2,f, channels);
						
						Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\combined\\"+
											f.getName().replace(" ", "")+
											"\\"+
											t1.getName().replace(" ", "")+
											"_"+
											t2.getName().replace(" ", "")+
											"_"+
											i+
											".jpg", destiny);
					}
				}
			}		
		}
	}

}
