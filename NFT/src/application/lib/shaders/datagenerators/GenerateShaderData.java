package application.lib.shaders.datagenerators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import application.lib.ref.FilePath;
import application.lib.ref.ShaderCoordinates;
import application.lib.shaders.serialization.DeserializeFile;
import application.lib.shaders.serialization.SerializeFile;
import application.lib.util.GetFileFromDirectory;
import application.lib.util.SerializableColor;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

public class GenerateShaderData {
	
	ArrayList<SerializableColor[]> shaders;
	SerializableColor[] shaderColours;
	
	public GenerateShaderData() {
		shaders = new ArrayList<SerializableColor[]>();
	}
	
	/**
	 * From a file system, will generate and serialize shader data.
	 * @throws IOException
	 */
	public void generateShaderData() throws IOException { 
		this.getColorFromShaders();
		this.serialize();
	}
	
	public void getColorFromShaders() throws IOException {
		System.out.println("Generating data");
		File[] filesFromDirectory = GetFileFromDirectory.getFilesFromDirectory(FilePath.FILEPATH_SHADERS);
		int j = 0;
		for (File file : filesFromDirectory) {
			shaderColours = new SerializableColor[4];
			int i = 0;
			PixelReader image = new Image(file.getAbsolutePath()).getPixelReader();
			for (ShaderCoordinates coords : ShaderCoordinates.values()) {
				shaderColours[i++] = new SerializableColor(image.getColor(coords.getX(), coords.getY()));
			}
			shaders.add(shaderColours);
			//System.out.println(shaderColours[2].getFXColor().getRed());
			System.out.println(Integer.toString(j++) + "/" + Integer.toString(filesFromDirectory.length) + ", " + file.getAbsolutePath().toString());
		}
	}
	
	public void clear() throws IOException { 
		shaders = (ArrayList<SerializableColor[]>) DeserializeFile.deserializeShader(FilePath.FILEPATH_COLOUR, shaders);
		shaders.clear();
	}
	
	public void serialize() throws IOException {
		SerializeFile.serializeShader(FilePath.FILEPATH_COLOUR, shaders);
	}
}
