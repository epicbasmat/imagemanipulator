package application.lib.layer;

import application.lib.util.pixels.ApplyPixelAbstract;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class LayerPixelApplier extends ApplyPixelAbstract{

	private WritableImage top;
	private WritableImage bottom;
	
	/**
	 * 
	 * @param x
	 * @param bottom
	 * @param top
	 */
	public LayerPixelApplier(int x, WritableImage bottom, WritableImage top) {		
		super(x, 0, (int) bottom.getHeight(), bottom);
		this.top = top;
		this.bottom = bottom;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param bottom
	 * @param top
	 */
	public LayerPixelApplier(int x, int y, WritableImage bottom, WritableImage top) {		
		super(x, y, (int) bottom.getHeight(), bottom);
		this.top = top;
		this.bottom = bottom;
	}

	@Override
	public void filter(int argb, PixelWriter pixelWriter, int x, int y) {
		if (top.getPixelReader().getArgb(x, y) != 0) {
			pixelWriter.setArgb(x, y, top.getPixelReader().getArgb(x, y));
		} else {
			pixelWriter.setArgb(x, y, argb);
		}
	}
}
