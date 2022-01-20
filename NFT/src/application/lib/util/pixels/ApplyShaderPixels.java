package application.lib.util.pixels;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ApplyShaderPixels extends ApplyPixel {

	Color[] shader;

	public ApplyShaderPixels(int x, int max, WritableImage image, Color[] shader) {
		super(x, 0, max, image);
		this.shader = shader;
		// TODO Auto-generated constructor stub

	}

	@Override
	public void filter(int argb, PixelWriter pixelWriter, int x, int y) {
		switch (argb) {
		case(-1):
			pixelWriter.setColor(x, y, shader[0]);
			break;
		case(-65536):
			pixelWriter.setColor(x, y, shader[1]);
			break;
		case(-16711936):
			pixelWriter.setColor(x, y, shader[2]);
			break;
		case(-16776961):
			pixelWriter.setColor(x, y, shader[3]);
			break;
	}
		
	}
}
