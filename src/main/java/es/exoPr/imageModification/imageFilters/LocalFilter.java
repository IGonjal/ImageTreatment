package es.exoPr.imageModification.imageFilters;

import org.opencv.core.Mat;

public abstract class LocalFilter extends ImageFilter {

	protected int localSize;
	public LocalFilter(Mat image, Channels c, int localSize) {
		super(image, c);
		setLocalSize(localSize);
	}
	public int getLocalSize() {
		return localSize;
	}
	public void setLocalSize(int localSize) {
		this.localSize = localSize;
	}



}
