package es.com.getChannelsFromZorke;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is used to write a string into a file
 * @author ismael.gonjal
 *
 */
public class FileWriter {
	
	private FileWriter() {}
	/**
	 * Writes the received text into the filename
	 * 
	 * @param fileName the file path
	 * @param text the string to write
	 */
	public static boolean write(String fileName, String text) {
		boolean ret = false;
		try {
			File f = new File(fileName);
			if (!f.exists()) {
				ret = f.createNewFile();
			}
			PrintWriter out = new PrintWriter(fileName, "UTF-8");
			
			out.print(text);
			out.close();
		} catch (IOException e) {
			IOException ioex =  new IOException("Error when writting " + fileName);
			ioex.setStackTrace(e.getStackTrace());
			ioex.printStackTrace();
		}
		return ret;
	}
	
}
