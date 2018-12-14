package es.exoPr.imageModification.imageFilters;

public class Channels {
	
	private boolean one;
	private boolean two;
	private boolean three;
	
	/**
	 * The three channels
	 * @param one
	 * @param two
	 * @param three
	 */
	public Channels(boolean one, boolean two, boolean three){
		this.one = one;
		this.two = two;
		this.three = three;
	}
	/**
	 * The three channels in an array
	 * @param ch
	 */
	public Channels(boolean[] ch) {
		if(ch.length !=3) {
			throw new UnsupportedOperationException("Error, debe tener 3 posiciones");
		}
		this.one = ch[0];
		this.two = ch[1];
		this.three = ch[2];
	}
	
	/**
	 * Returns the channels
	 * @return
	 */
	public boolean[] getChannels() {
		boolean[] d = {one, two, three};
		
		return d;
	}
	
	/**
	 * Sets the channels
	 * @param one
	 * @param two
	 * @param three
	 */
	public void setChannels(boolean one, boolean two, boolean three){
		this.one = one;
		this.two = two;
		this.three = three;
	}
	/**
	 * Sets the three channels in an array
	 * @param ch
	 */
	public void setChannels(boolean[] ch) {
		if(ch.length !=3) {
			throw new UnsupportedOperationException("Error, debe tener 3 posiciones");
		}
		this.one = ch[0];
		this.two = ch[1];
		this.three = ch[2];
	}
}
