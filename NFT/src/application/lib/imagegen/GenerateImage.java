package application.lib.imagegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import application.lib.layer.LayerApplier;
import application.lib.ref.FilePath;
import application.lib.shaders.datagenerators.ShaderApplier;
import application.lib.util.GetFileFromDirectory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class GenerateImage {
	
	private WritableImage primary;
	
	public GenerateImage(WritableImage primary) { 
		this.primary = primary;
	}
	
	/**
	 * 
	 * @param image The image to apply to the base image
	 * @throws InterruptedException
	 */
	public void applyImageToPrimary(WritableImage image) throws InterruptedException { 
		new LayerApplier(primary, image).applyBottomToTop();
		new ShaderApplier(primary).applyShaderToImage();
	}
	
	public WritableImage getNewWritableImage(FilePath path) throws FileNotFoundException {
		return new WritableImage(new Image(new FileInputStream(GetFileFromDirectory.getFile(path)
					.getAbsolutePath()))
				.getPixelReader(), 64, 64);
	}
	
	public WritableImage getImage() {
		return this.primary;
	}
	
	public void setupImageGenerators() throws IOException, InterruptedException {
		System.out.println("== Applying Backgrounds ==");
		applyImageToPrimary(getNewWritableImage(FilePath.FILEPATH_BG));
		System.out.println("== Applying Frames ==");
		applyImageToPrimary(getNewWritableImage(FilePath.FILEPATH_FRAME));
		System.out.println("== Applying Primary Object ==");
		applyImageToPrimary(getNewWritableImage(FilePath.FILEPATH_OBJECT));
		System.out.println("== Finished == ");
		ImageIO.write(SwingFXUtils.fromFXImage(primary, null), "png", new File(FilePath.FILEPATH_OUTPUT.getFile() + UUID.randomUUID() + ".png"));
	}
	
}
