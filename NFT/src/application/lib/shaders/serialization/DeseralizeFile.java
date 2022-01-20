package application.lib.shaders.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import application.lib.ref.FilePath;

public class DeseralizeFile {
	public static Object deserializeShader(FilePath fileLoc) {
		try {
			FileInputStream readData = new FileInputStream(fileLoc.getFile());
			ObjectInputStream readStream = new ObjectInputStream(readData);
			Object obj = readStream.readObject();
			readStream.close();
			return obj;
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return fileLoc;
	}
}
