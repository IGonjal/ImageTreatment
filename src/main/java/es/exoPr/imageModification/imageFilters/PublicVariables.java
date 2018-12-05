package es.exoPr.imageModification.imageFilters;

public class PublicVariables {
	
	/**
	 * Threshold for thresholded filters
	 */
	private static double DEFAULT_THRESHOLD_COLOR = 125d;
	private static double THRESHOLD_COLOR = DEFAULT_THRESHOLD_COLOR;
	public static void setThresholdColor(double neww) {
		THRESHOLD_COLOR = neww;
	}
	public static double getThresholdColor() {
		return THRESHOLD_COLOR;
	}
	public static void restoreDefaultThreshold() {
		THRESHOLD_COLOR=DEFAULT_THRESHOLD_COLOR;
	}
	
	/**
	 * The max value of color (0,0,0 being black)
	 */
	private static final double DEFAULT_MAX_COLOR = 0d;
	private static double MAX_COLOR = DEFAULT_MAX_COLOR;
	public static void setMaxColor(double neww) {
		MAX_COLOR = neww;
	}
	public static double getMaxColor() {
		return MAX_COLOR;
	}
	public static void restoreDefaultMaxColor() {
		MAX_COLOR=DEFAULT_MAX_COLOR;
	}
	
	/**
	 * The max value of color (255,255,255 being white)
	 */
	private static final double DEFAULT_MIN_COLOR = 255d;
	private static double MIN_COLOR = DEFAULT_MIN_COLOR;
	public static void setMinColor(double neww) {
		MIN_COLOR = neww;
	}
	public static double getMinColor() {
		return MIN_COLOR;
	}
	public static void restoreDefaultMincolor() {
		MIN_COLOR=DEFAULT_MIN_COLOR;
	}
	
	/**
	 * The channels for knowing if apply the filters (RGB)
	 */
	private static boolean[] DEFAULT_CHANNELS = {true,true,true};
	private static boolean[] CHANNELS = DEFAULT_CHANNELS;
	public static void setChannels(boolean[] neww) {
		if(neww.length== 3) {
			CHANNELS = neww;
		}
	}
	public static boolean[] getChannels() {
		return CHANNELS;
	}
	public static void restoreDefaultChannels() {
		CHANNELS=DEFAULT_CHANNELS;
	}
}
