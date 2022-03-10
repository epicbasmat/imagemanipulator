package application.lib.layer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.scene.image.WritableImage;

public class LayerApplier {
	
	private WritableImage bottom;
	private WritableImage top;
	
	/**
	 * 
	 * @param bottom
	 * @param top
	 */
	public LayerApplier(WritableImage bottom, WritableImage top) {
		this.bottom = bottom;
		this.top = top;
	}
	
	public void applyBottomToTop() throws InterruptedException  {
		System.out.println(top.getPixelReader().getArgb(40, 40));

		ExecutorService es = Executors.newCachedThreadPool();
		for (int x = 0; x < bottom.getWidth(); x++) {
			es.execute(new LayerPixelApplier(x, bottom, top));
		}
		
		es.shutdown();
		es.awaitTermination(1000, TimeUnit.MILLISECONDS);
	}
	
	public WritableImage getProduct() { 
		return this.bottom;
	}
}
