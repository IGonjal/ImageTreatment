package es.exoPr.imageModification.imageFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.opencv.core.Mat;

public abstract class ImageFilter {
	protected List<Mat> image;
	protected Channels channels;
	
	/**
	 * Creates a filter 
	 * @param image
	 * @param c
	 */
	public ImageFilter (Mat image, Channels c) {
		this.image = new ArrayList<>();
		if(image != null) {
			this.image.add(image);
		}
		this.channels = c;
	}
	
	/**
	 * Sets the image
	 * 
	 * @param im
	 */
	public void putImage(Mat im) {
		if(im != null) {
			this.image = new ArrayList<>();
			this.image.add(im);
		}
	}

	/**
	 * sets the channels
	 * @param c
	 */
	public void setChannels(Channels c) {
		this.channels = c;
	}
	
	/**
	 * Applies the filter
	 * @return
	 */
	public abstract Optional<Mat> applyFilter();
	
}
