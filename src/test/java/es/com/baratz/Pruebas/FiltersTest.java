package es.com.baratz.Pruebas;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import es.exoPr.imageModification.imageFilters.FilterUser;
import es.exoPr.imageModification.imageFilters.ThresholdFilter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltersTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltersTest( String testName )
    {
        super( testName );
        
System.load("C:\\Users\\ismael.gonjal\\Downloads\\opencv\\build\\java\\x64\\opencv_java343.dll");
		
		Mat origin = Imgcodecs.imread("c:\\image.jpg");
		
		FilterUser filterUser = new FilterUser();
		int i = 1;
		for(ThresholdFilter t : ThresholdFilter.values()) {
			Mat destiny = filterUser.use(origin,t);
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\"+t.getName().replace(" ", "") + "_all" +".jpg", destiny);
		}
		
		boolean [] channelRed = {true, false, false};
		for(ThresholdFilter t : ThresholdFilter.values()) {
			Mat destiny = filterUser.use(origin,t, channelRed);
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\"+t.getName().replace(" ", "") + "_red" +".jpg", destiny);
		}
		
		boolean [] channelGreen = {false, true, false};
		for(ThresholdFilter t : ThresholdFilter.values()) {
			Mat destiny = filterUser.use(origin,t, channelGreen);
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\"+t.getName().replace(" ", "") + "_red" +".jpg", destiny);
		}
		
		boolean [] channelBlue = {true, false, false};
		for(ThresholdFilter t : ThresholdFilter.values()) {
			Mat destiny = filterUser.use(origin,t, channelBlue);
			Imgcodecs.imwrite("C:\\Users\\ismael.gonjal\\"+t.getName().replace(" ", "") + "_red" +".jpg", destiny);
		}
		
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltersTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
