package es.com.getChannelsFromZorke;


import java.io.IOException;
import java.util.HashMap;


public class Main {

	    

	    public static void main(String[] args) {
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("#EXTM3U\n");
			try {
				FileRead fr = new FileRead("json");
				int lineas = FileRead.countLines("json");
			
		    	fr.initRead("json");
		    	int position = 0;
		    	fr.readNextLine();
		    	
		    	while (fr.getPosition() < lineas-1) {
		    		position = fr.getPosition();
		    		String line = fr.readNextLine().replace("\\/","/").replace("\"", "").replace("{", "").replace("}", "");
		    		line = line.substring(0, line.length()-1);
		    		System.out.println(line);
		    		String s[] = line.split(",");
		    		HashMap<String, String> hm = new HashMap<>();
		    		for(int i= 0; i<s.length; i++) {
		    			try {
		    				String[] aux = s[i].split(":");
		    				if(aux.length == 2)
		    					hm.put(aux[0], aux[1]);
		    				else  {
		    					String a = "";
		    					for(int k =1; k<aux.length;k++) {
		    						if(k!=1) {
		    							a = a+":"; 
		    						}
		    						a = a + aux[k];
		    					}
		    					hm.put(aux[0],a);
		    				}
		    			}catch(ArrayIndexOutOfBoundsException e) {
		    				e.printStackTrace();
		    				break;
		    			}
		    		}
		    		sb.append("#EXTINF:-1");
		    		
		    		
		    		if(hm.get("gr") != null) {
		    			sb.append("group-title=\"");
		    			sb.append(hm.get("gr").replace("#", ""));
		    			sb.append("\"");
		    		}
		    		sb.append(",");
		    		sb.append(hm.get("chName"));
		    		sb.append("\n");
		    		sb.append(hm.get("chUrl"));
		    		sb.append("\n");
		    	}
		    		FileWriter.write("jsonProcessed", sb.toString());
	    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
