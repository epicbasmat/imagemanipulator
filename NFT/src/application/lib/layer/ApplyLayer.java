package application.lib.layer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import application.lib.util.pixels.ApplyLayerPixels;
import javafx.scene.image.WritableImage;

public class ApplyLayer {
	private WritableImage bottom;
	private WritableImage top;
	
	ApplyLayer(WritableImage bottom, WritableImage top) {
		this.bottom = bottom;
		this.top = top;
	}
	
	public void applyBottomToTop() throws InterruptedException  {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int x = 0; x < bottom.getWidth(); x++) {
			es.execute(new ApplyLayerPixels(x, 0, bottom, top));
		}
		es.shutdown();
		es.awaitTermination(1000, TimeUnit.MILLISECONDS);
	}
	
	public WritableImage getProduct() { 
		return this.bottom;
	}
}
