package application.lib.util;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class SerializableColor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5238481290425329854L;
	private double red;
	private double green;
	private double blue;
	private double alpha;
	
	public SerializableColor(Color color) {
		this.red = color.getRed();
		this.blue = color.getBlue();
		this.green = color.getGreen();
		this.alpha = color.getOpacity();
	}
	
	public Color getFXColor() {
		return new Color (red, green, blue, alpha);
	}
}
