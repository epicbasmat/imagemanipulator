package application.lib.shaders.datagenerators;

import application.lib.util.pixels.ApplyPixelAbstract;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ShaderPlxelApplier extends ApplyPixelAbstract {

	Color[] shader;
	private int max;

	/**
	 * This will apply a shader to a {@code WritableImage}, provided the {@code WritableImage} contains
	 * the specified RGB colours for a shader to be applied.
	 * @param x the X coordinate of the row to apply to.
	 * @param image the {@code WritableImage} image to apply the shader to.
	 * @param shader the shader you want to apply the image to
	 */
	public ShaderPlxelApplier(int x, WritableImage image, Color[] shader) {
		super(x, 0, (int) image.getWidth(), image);
		this.shader = shader;
		this.max = 64;
	} 
	
	/**
	 * This will apply a shader to a {@code WritableImage}, provided the {@code WritableImage} contains
	 * the specified RGB colours for a shader to be applied.
	 * @param x the X coordinate of the row to apply to.
	 * @param max the maximum Y coordinate to go down to.
	 * @param image the {@code WritableImage} to apply the shader to.
	 * @param shader the shader  to apply the image to
	 */
	public ShaderPlxelApplier(int x, int max, WritableImage image, Color[] shader) {
		super(x, 0, max, image);
		this.shader = shader;
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
