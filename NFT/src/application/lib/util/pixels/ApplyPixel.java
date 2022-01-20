package application.lib.util.pixels;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public abstract class ApplyPixel implements Runnable {

	private int x;
	private int y;
	private int max;

	private WritableImage image;
	
	ApplyPixel(int x, int y, int max, WritableImage image) {
		this.x = x;
		this.y = y;
		this.max = max;
		this.image = image;
	}
	
	@Override
	public void run() {
		PixelReader pixelReader = image.getPixelReader();
		PixelWriter pixelWriter = image.getPixelWriter();	
		do {
			int argb = pixelReader.getArgb(x, y);
			for (int y = 0; y < max; y++) {
				filter(argb, pixelWriter, x, y);
			}
		} while (y < max);
	}
	
	abstract public void filter(int argb, PixelWriter pixelWriter, int x, int y);
	
}
