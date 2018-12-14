package es.exoPr.imageModification.imageFilters;


import java.util.Optional;

import org.opencv.core.Mat;

import es.exoPr.imageModification.imageFilters.filterEnums.FilterUser;
import es.exoPr.imageModification.imageFilters.filterEnums.PixelCombinationFilter;

public class CombineImagesFilter extends ImageFilter{

	
	private PixelCombinationFilter filter;
	
	public CombineImagesFilter(Mat image, Mat image2, PixelCombinationFilter filter, Channels c) {
		super(image, c);
		setFilter(filter);
		super.image.add(image2);
	}
	

	public void setImage(Mat image) {
		super.image.add(image);
	}
	


	@Override
	public Optional<Mat> applyFilter() {
		Optional<Mat> ret = Optional.empty();
		if(super.image.size() >= 2) {
			Mat ori1 = super.image.get(super.image.size()-2);
			Mat ori2 = super.image.get(super.image.size()-1);
		
			FilterUser fu = new FilterUser();
			
			ret = Optional.of(fu.use(ori1, ori2, filter, this.channels.getChannels()));
			
		}
		
		return ret;
	}

	public void setFilter(PixelCombinationFilter filter) {
		this.filter = filter;
	}



}
