package es.com.getChannelsFromZorke;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileRead {
	
	private int position;
	private String file;
	private BufferedReader br;
	public FileRead(String file) throws FileNotFoundException {
		position = 0;
		this.file = file;
		this.initRead(file);
	}
	public FileRead(String file, Charset charSet) throws FileNotFoundException {
		position = 0;
		this.file = file;
		this.initRead(file, charSet);
	}
	public static int countLines(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean endsWithoutNewLine = false;
			while ((readChars = is.read(c)) != -1) {
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n')
						++count;
				}
				endsWithoutNewLine = (c[readChars - 1] != '\n');
			}
			if(endsWithoutNewLine) {
				++count;
			} 
			return count;
		} finally {
			is.close();
		}
	}


	static String readWholeFile(String file) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file), "UTF-8"));
		for(String line; (line = br.readLine()) != null; ) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}


	public static Map<String, String>getLabels(String str){
		HashMap<String,String> ret = new HashMap<String,String>();


		int openIni = 0;
		int openFin = 0;
		int posicion = 0;


		String key = "";
		String value = "";

		while(posicion <= str.length()-1) {
			openIni = posicion + str.substring(posicion).indexOf("<Unidades documentales>");
			openFin = posicion + str.substring(posicion).indexOf("</Unidades documentales>") + ("<Unidades documentales>".length());
			key = str.substring(openIni+1,openFin);
			posicion = openFin+1;

			openIni = posicion + str.substring(posicion).indexOf("</");
			value = str.substring(openFin+2,openIni);
			openFin = posicion + str.substring(posicion).indexOf(">");
			posicion = openFin+1;

			key = key.replaceAll("\n", "");
			value = value.replaceAll("\n", "");
			ret.put(key, value);
		}
		return ret;
	}


	
	public void initRead(String f, Charset charSet) throws FileNotFoundException {
		br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file), charSet));
	}
	public void initRead(String f) throws FileNotFoundException {
		br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file),StandardCharsets.ISO_8859_1));
	}
	
	public void endRead() throws IOException {
		if (br!= null)
			br.close();
		br = null;
		file = "";
	}

	public String readNextLine() throws IOException {

		String line = br.readLine();
		position++;

		return line;
	}

	public  int getPosition() {
		return this.position;
	}

	public  void restartPosition() {
		position=0;
	}
}
