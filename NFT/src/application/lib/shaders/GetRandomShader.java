package application.lib.shaders;

import java.util.ArrayList;
import java.util.Random;

import application.lib.ref.FilePath;
import application.lib.shaders.serialization.DeserializeFile;
import application.lib.util.SerializableColor;
import javafx.scene.paint.Color;

public class GetRandomShader {
	
	private ArrayList<SerializableColor[]> shaders;
	private SerializableColor[] shader;
	private Color[] colour;
	
	public GetRandomShader() {
		getRandomShader();
	}
	
	private void getRandomShader() {
		shaders = (ArrayList<SerializableColor[]>) DeserializeFile.deserializeShader(FilePath.FILEPATH_COLOUR, shaders);
		this.shader = shaders.get(new Random().nextInt(shaders.size()));
	}
	
	public Color[] getShader() {
		colour = new Color[4];
		
		for (int i = 0; i < 4; i++) { 
			System.out.println(shader[i].getFXColor().getBlue());
			colour[i] = shader[i].getFXColor();
		}
		
		return colour;
	}
}
