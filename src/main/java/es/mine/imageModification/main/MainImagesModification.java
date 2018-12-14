package es.mine.imageModification.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.AverageLocalFilter;
import es.exoPr.imageModification.imageFilters.Channels;
import es.exoPr.imageModification.imageFilters.CombineImagesFilter;
import es.exoPr.imageModification.imageFilters.ImageFilter;
import es.exoPr.imageModification.imageFilters.ThresholdFilter;
import es.exoPr.imageModification.imageFilters.filterEnums.PixelCombinationFilter;
import es.exoPr.imageModification.imageFilters.filterEnums.ThresholdType;


public class MainImagesModification {
	private static final double THRESHOLD = 125d;
	public static void main(String[] args) {
		String s[] = {"c:\\enrico.jpg","c:\\enrico2.jpg"};
		// https://docs.opencv.org/java/2.4.9/
		System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread(s[0]);
		Mat origin2 = Imgcodecs.imread(s[1]);
		
		
		
		
		try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\ORIGINAL.jpg"));){
			Files.copy(new File(s[0]).toPath(), fos);
		} catch (IOException e) {}
		try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\ORIGINAL2.jpg"));){
			Files.copy(new File(s[1]).toPath(), fos);
		} catch (IOException e) {}
		
//		// 7 al ser un número de 3 bits
//		for(ThresholdType t : ThresholdType.values()) {
//			for(int i = 1; i <= 7; i++) {
//				if(i ==5) {
//					System.out.println("staph");
//				}
//				boolean[] channels = {(i&4)==4, (i&2)==2, (i&1)==1};
//				Channels chans = new Channels(channels);
//				
//				ImageFilter imFil = new ThresholdFilter(origin,chans,THRESHOLD,t);
//				System.out.println(Arrays.toString(channels) + " - "+ i +" - "+ Integer.toBinaryString(i) + " - " + t.getName());
//				Mat destiny = imFil.applyFilter().get();
//
//				Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\"+t.getName().replace(" ", "") +"_" +i +".jpg", destiny);
//			}
//		}
//		// 7 al ser un número de 3 bits
//		for(ThresholdType t1 : ThresholdType.values()) {
//			for(ThresholdType t2 : ThresholdType.values()) {
//				for(int i = 1; i <= 7; i++) {
//					boolean[] channels = {(i&4)==4, (i&2)==2, (i&1)==1};
//					for(PixelCombinationFilter f : PixelCombinationFilter.values()) {
//						Channels chans = new Channels(channels);
//						System.out.println(Arrays.toString(channels) + " - "+ i +" - "+ Integer.toBinaryString(i) + " - " +f.getName() + "("+ t1.getName() +" , "+t2.getName()+")" );
//						
//						ImageFilter imFil = new ThresholdFilter(origin,chans,THRESHOLD,t1);
//						Mat aux1 = imFil.applyFilter().get();
//						
//						
//						imFil = new ThresholdFilter(origin2,chans,THRESHOLD,t1);
//						Mat aux2 = imFil.applyFilter().get();
//						
//						imFil = new CombineImagesFilter(aux1, aux2, f, chans); 
//						Mat destiny = imFil.applyFilter().get();
//						
//						
//						File fil = new File("C:\\Users\\ismael.gonjal\\TrataImagenes\\combined\\"+
//								f.getName().replace(" ", "")+
//								"\\"+
//								t1.getName().replace(" ", "")+
//								"_"+
//								t2.getName().replace(" ", "")+
//								"_"+
//								i+
//								".jpg");
//						fil.mkdirs();
//						fil.delete();
//						Imgcodecs.imwrite(fil.getPath(), destiny);
//					}
//				}
//			}		
//		}
	
		boolean[] channels = {true, true, true};
		
		Channels chans = new Channels(channels);
		for(int k =30; k> 0 ; k-= 3) {
			int localSize = k;
				
			ImageFilter imFil = new AverageLocalFilter(origin,chans, localSize);
				
			Mat destiny = imFil.applyFilter().get();
				
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\TrataImagenes\\Average\\zavrg_size_"+ localSize + "_%.jpg", destiny);
		}
		
	}

}
