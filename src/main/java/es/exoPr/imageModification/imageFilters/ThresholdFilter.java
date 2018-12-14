package es.exoPr.imageModification.imageFilters;

import java.util.Optional;

import org.opencv.core.Mat;

import es.exoPr.imageModification.imageFilters.filterEnums.FilterUser;
import es.exoPr.imageModification.imageFilters.filterEnums.ThresholdType;

public class ThresholdFilter extends ImageFilter{

	private double threshold; 
	private ThresholdType type;
	
	public ThresholdFilter(Mat image, Channels c, double threshold, ThresholdType type) {
		super(image, c);
		this.setThreshold(threshold);
		this.setThresholdType(type);
	}

	
	/**
	 * Gets the threshold
	 * @return
	 */
	public double getThreshold() {
		return threshold;
	}
	/**
	 * Sets the threshold
	 * @param threshold
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	/**
	 * gets the threshold type
	 * @return
	 */
	public ThresholdType getThresholdType() {
		return type;
	}
	/**
	 * Sets the threshold type
	 * @param type
	 */
	public void setThresholdType(ThresholdType type) {
		this.type = type;
	}


	@Override
	public Optional<Mat> applyFilter() {	

		return Optional.ofNullable((new FilterUser())
					.use	(this.image.stream().findFirst().get(), 
							this.type, 
							this.threshold, 
							this.channels.getChannels()));
	}
	
	
	
}
