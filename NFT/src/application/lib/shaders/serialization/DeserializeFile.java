package application.lib.shaders.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import application.lib.ref.FilePath;

public class DeserializeFile {
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> T deserializeShader(FilePath fileLoc, T t) {
		try {
			FileInputStream readData = new FileInputStream(fileLoc.getFile());
			ObjectInputStream readStream = new ObjectInputStream(readData);
			T obj = (T) readStream.readObject();
			readStream.close();
			return obj;
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return (T) new ClassCastException();
	}
}
