package application.lib.shaders.generators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import application.lib.ref.FilePath;
import application.lib.ref.ShaderCoordinates;
import application.lib.shaders.serialization.SerializeFile;
import application.lib.util.GetFileFromDirectory;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class ShaderDataGen {
	ArrayList<Color[]> shaders;
	Color[] shaderColors;
	
	ShaderDataGen() {
		shaders = new ArrayList<Color[]>();
	}
	
	public void getColorFromShaders() {
		for (File file : GetFileFromDirectory.getFilesFromDirectory(FilePath.FILEPATH_COLOUR)) {
			shaderColors = new Color[4];
			int i = 0;
			PixelReader image = new Image(file.getAbsolutePath()).getPixelReader();
			for (ShaderCoordinates coords : ShaderCoordinates.values()) {
				shaderColors[i++] = image.getColor(coords.getX(), coords.getY());
			}
			
		}
	}
	
	public void serialize() throws IOException {
		SerializeFile.serializeShader(shaders, FilePath.FILENAME_COLOUR);
	}
}
