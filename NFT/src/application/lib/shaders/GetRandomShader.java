package application.lib.shaders;

import java.util.ArrayList;

import application.lib.ref.FilePath;
import application.lib.shaders.serialization.DeseralizeFile;
import javafx.scene.paint.Color;

public class GetRandomShader {
	
	ArrayList<Color[]> shaders;
	Color[] shader;
	
	GetRandomShader() {
		getShaders();
	}
	
	@SuppressWarnings("unchecked")
	private void getShaders() {
		shaders = (ArrayList<Color[]>) DeseralizeFile.deserializeShader(FilePath.FILEPATH_COLOUR);
		this.shader = shaders.get((int) Math.random() * shaders.size() - 0);
	}
	
	public Color[] getShader() {
		return shader;
	}
}
