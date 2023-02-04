package application;

import java.awt.Color;

import picture.Picture;

public class Filter {
	private Picture picture;

	public Filter(Picture picture) {
		this.picture = picture;
	}

	/**
	 * The input picture should be converted to a grey scale. To achieve a grey
	 * image we need to sum up the red, green and blue value and divide it by 3.
	 * 
	 * @return converted picture
	 */
	public Picture greyScaleFilter() {

		for (int height = 0; height < picture.width(); height++){
			for(int width = 0; width < picture.width(); width++){

				Color color = picture.get(height, width);
				//System.out.println(color);
				float greyScale = (color.getBlue() + color.getGreen() + color.getBlue()) / 3;
				float greyScalePercent = greyScale / 255;
				color = new Color(greyScalePercent, greyScalePercent, greyScalePercent);
				picture.set(height, width, color);
			}
		}

		return picture;
	}

	/**
	 * As we have a range until 255 inclusive getting the inverted image is easy.
	 * Just subtract the color value from 255.
	 * 
	 * @return converted picture
	 */
	public Picture revertColorFilter() {

		for (int height = 0; height < picture.width(); height++){
			for(int width = 0; width < picture.width(); width++){

				Color color = picture.get(height, width);

				float red = (color.getRed() - 255) * -1;
				float green = (color.getGreen() - 255) * -1;
				float blue = (color.getBlue() - 255) * -1;

				color = new Color(Math.min(red, 255) / 255, Math.min(green, 255) / 255, Math.min(blue, 255) / 255);
				picture.set(height, width, color);
			}
		}

		return picture;
	}

	//@formatter:off
	/**
	 * A sepia filter is a little more difficult to calculate.
	 * to get the
	 * 
	 * sepia red: (current red * 0.393) + (current green * 0.769) + (current blue * 0.189)
	 * sepia green: (current red * 0.349) + (current green * 0.686) + (current blue * 0.168)
	 * sepia blue: (current red * 0.292) + (current green * 0.534) + (current blue * 0.131)
	 * 
	 * the new value is then Math.min(sepia red, 255) and so on.
	 * 
	 * @return converted picture
	 */
	//@formatter:on

	public Picture sepiaFilter() {


		for (int height = 0; height < picture.width(); height++){
			for(int width = 0; width < picture.width(); width++){

				Color color = picture.get(height, width);

				float red = (float)((color.getRed()  * 0.393) + (color.getGreen() * 0.769) + (color.getBlue()* 0.189));
				float green = (float)((color.getRed() * 0.349) + (color.getGreen() * 0.686) + (color.getBlue() * 0.168));
				float blue = (float)((color.getRed() * 0.292) + (color.getGreen() * 0.534) + (color.getBlue() * 0.131));

				color = new Color(Math.min(red, 255) / 255, Math.min(green, 255) / 255, Math.min(blue, 255) / 255);
				picture.set(height, width, color);
			}
		}


		return picture;
	}
}
