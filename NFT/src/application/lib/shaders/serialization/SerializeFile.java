package application.lib.shaders.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import application.lib.ref.FilePath;

public class SerializeFile implements Serializable{

	private static final long serialVersionUID = -8945232274657625094L;
	
	/**
	 * 
	 * @param <T>
	 * @param obj
	 * @param fileLoc path to serialise to 
	 * @throws IOException 
	 */
	public static <T extends Object> void serializeShader(FilePath fileLoc, T t) throws IOException { 
		try {
			FileOutputStream writeData = new FileOutputStream(fileLoc.getFile());
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
			writeStream.writeObject(t);
			writeStream.flush();
			writeStream.close();				
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
	
	

}
