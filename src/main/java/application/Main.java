package application;

import picture.Picture;

public class Main {

	public static void main(String[] args) {
		Picture picture = new Picture("https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg");

		// convert to grey scale
		Filter filter = new Filter(picture);
		//picture = filter.greyScaleFilter();
		//picture = filter.sepiaFilter();
		picture = filter.revertColorFilter();
		picture.show();
		
	}
}
