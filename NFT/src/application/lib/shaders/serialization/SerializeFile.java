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
	 * @param obj
	 * @param fileLoc path to serialise to 
	 * @return
	 * @throws IOException 
	 */
	public static void serializeShader(Object obj, FilePath fileLoc) throws IOException { 
		try {
			FileOutputStream writeData = new FileOutputStream(fileLoc.getFile().toString());
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
			writeStream.writeObject(obj);
			writeStream.flush();
			writeStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
	
	

}
