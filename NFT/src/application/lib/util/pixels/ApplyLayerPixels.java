package application.lib.util.pixels;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class ApplyLayerPixels extends ApplyPixel{

	private Image top;
	
	/**
	 * 
	 * @param x
	 * @param bottom
	 * @param top
	 * @param colors
	 */
	public ApplyLayerPixels(int x, WritableImage bottom, WritableImage top) {		
		super(x, 0, (int) bottom.getHeight(),  bottom);
		this.top = top;
	}
	
	public ApplyLayerPixels(int x, int y, WritableImage bottom, WritableImage top) {		
		super(x, y, (int) bottom.getHeight(),  bottom);
		this.top = top;
	}

	@Override
	public void filter(int argb, PixelWriter pixelWriter, int x, int y) {
		if ((argb>>24 & 0xff) > 0) {
			pixelWriter.setArgb(x, y, top.getPixelReader().getArgb(x, y));
		} 
	}
}
