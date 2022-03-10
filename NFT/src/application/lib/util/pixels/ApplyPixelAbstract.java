package application.lib.util.pixels;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public abstract class ApplyPixelAbstract implements Runnable {

	private int x;
	private int y;
	private int max;

	private WritableImage image;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param max
	 * @param image
	 */
	public ApplyPixelAbstract(int x, int y, int max, WritableImage image) {
		this.x = x;
		this.y = y;
		this.max = max;
		this.image = image;
	}
	
	@Override
	public void run() {
		PixelReader pixelReader = image.getPixelReader();
		PixelWriter pixelWriter = image.getPixelWriter();	
		for (y = 0; y < max; y++) {
			filter(pixelReader.getArgb(x, y), pixelWriter, x, y);
		}
	}
	
	abstract public void filter(int argb, PixelWriter pixelWriter, int x, int y);
	
}
