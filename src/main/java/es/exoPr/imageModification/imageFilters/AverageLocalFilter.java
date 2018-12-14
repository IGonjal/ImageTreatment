package es.exoPr.imageModification.imageFilters;

import java.util.Optional;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class AverageLocalFilter extends LocalFilter {

	public AverageLocalFilter(Mat image, Channels c, int localSize) {
		super(image, c, localSize);
	}

	@Override
	public Optional<Mat> applyFilter() {
		
		Mat ret = this.image.get(0).clone();
		
		Size siz = ret.size();
		
		
		for(int i = 0 ; i < siz.height ; i++) {
			
			for(int j = 0 ; j < siz.width ; j++) {
				
				int inix = ( i-localSize<0) ? 0:i-localSize;
				int finx =( i+localSize < siz.height)? i+localSize : (int) siz.height;
				
				int iniy =(j-localSize<0)?0: j-localSize;
				int finy = (j+localSize<siz.width)? j+localSize : (int) siz.width;
				
				double [] d = image.get(0).get(i, j);
				
				int num =0;
				for(int u = inix ; u < finx ; u++) {
					for(int v = iniy ; v < finy ; v ++) {
						
						double [] daux = this.image.get(0).get(u, v);
						
						for(int w = 0; w<d.length; w++) {
							if(this.channels.getChannels()[w]) {
								d[w] += daux[w];
							}
						}
						num++;
					}
				}
				num = (num == 0)? 1 : num;
				for(int w =0; w< d.length; w++) {
					if(this.channels.getChannels()[w]) {
						d[w] = d[w] / num;
					}
				}
				ret.put(i, j, d);
				
			}
			System.out.println("Linea " + i + " - channels [" 
			+ this.channels.getChannels()[0] + ","
			+ this.channels.getChannels()[1] + ","
			+ this.channels.getChannels()[2] + "]");
		}
		
		return Optional.of(ret);
	}
	

}
