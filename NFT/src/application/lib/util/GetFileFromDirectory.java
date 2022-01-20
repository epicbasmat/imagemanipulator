package application.lib.util;

import java.io.File;

import application.lib.ref.FilePath;

public class GetFileFromDirectory {
	
	public static File[] getFilesFromDirectory(FilePath files) {
		return new File(files.getFile()).listFiles();
	}
	
	public static File getFile(FilePath files) {
		return getFilesFromDirectory(files)[(int) (Math.random() * getFilesFromDirectory(files).length - 0)];
		
	}
}
