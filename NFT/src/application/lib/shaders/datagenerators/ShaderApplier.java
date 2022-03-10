package application.lib.shaders.datagenerators;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import application.lib.shaders.GetRandomShader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ShaderApplier {

	Color[] shader;
	WritableImage image;
	
	/**
	 * This will pick a random shader from a deserialized list of shaders and apply it to the passed {@code WritableImage}
	 * @param image
	 */
	public ShaderApplier(WritableImage image) {
		this.image = image;
		shader = new GetRandomShader().getShader();
	}
	
	public void applyShaderToImage() throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int x = 0; x < image.getWidth(); x++) {
			es.execute(new ShaderPlxelApplier(x, (int) image.getWidth(), image, shader));
		}
		es.shutdown();
		es.awaitTermination(5000, TimeUnit.MILLISECONDS);
	}
}
