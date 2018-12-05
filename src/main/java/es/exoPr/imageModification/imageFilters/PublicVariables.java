package es.mine.imageModification.imageFilters;

public class PublicVariables {
	
	private static final int DEFAULT_THRESHOLD_COLOR = 125;
	private static int THRESHOLD_COLOR = DEFAULT_THRESHOLD_COLOR;
	public static void setThresholdColor(int neww) {
		THRESHOLD_COLOR = neww;
	}
	public static int getThresholdColor() {
		return THRESHOLD_COLOR;
	}
	private static final int DEFAULT_MAX_COLOR = 255;
	private static int MAX_COLOR = DEFAULT_MAX_COLOR;
	public static void setMaxColor(int neww) {
		MAX_COLOR = neww;
	}
	public static int getMaxColor() {
		return MAX_COLOR;
	}
	private static final int DEFAULT_MIN_COLOR = 0;
	
	private static int MIN_COLOR = DEFAULT_MIN_COLOR;
	public static void setMinColor(int neww) {
		MIN_COLOR = neww;
	}
	public static int getMinColor() {
		return MIN_COLOR;
	}
}
