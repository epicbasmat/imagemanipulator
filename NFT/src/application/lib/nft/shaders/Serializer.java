package application.lib.nft.shaders;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import application.lib.ref.files.FilePath;
import javafx.scene.paint.Color;

public class Serializer implements Serializable{
	
	/**
	 * Serializer contains methods to serialize and deserialize a 2d array that contains shaders stored as  array of R,G,B values from 0-255.
	 * @author fembasmat
	 */
	
	private static final long serialVersionUID = 6155491202546142745L;
	private static final String NAME = FilePath.FILE_COLOUR.getFile() + FilePath.FILENAME_COLOUR.getFile();
	private ArrayList<Color[][]> shader;
	
	public Serializer() { 
		shader = new ArrayList<Color[][]>();
	}
	
	public Color[][] getShader() {
		
	}

	/**
	 * Will serialize shader array to file
	 * @return boolean to indicate success state
	 */
	private boolean serializeShader() { 
		try {
			FileOutputStream writeData = new FileOutputStream(NAME);
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
			writeStream.writeObject(shader);
			writeStream.flush();
			writeStream.close();
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Will deserialize shader array from file to Serializer class.
	 * @return boolean to indicate success state
	 */
	@SuppressWarnings("unchecked")
	private boolean deserializeShader() {
		try {
			FileInputStream readData = new FileInputStream(NAME);
			ObjectInputStream readStream = new ObjectInputStream(readData);
			this.shader = (ArrayList<Color[][]>) readStream.readObject();
			readStream.close();
			return true;
			
		} catch (Exception e) { 
			e.printStackTrace();
			return false;
		}
	}
}