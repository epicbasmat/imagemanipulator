package application.lib.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import application.lib.ref.files.FileExtension;
import application.lib.ref.files.FilePath;
import javafx.scene.image.Image;

public class Files {
	
	private File file;
	private Image image;
	private File[] fileArr;
	private ArrayList<Integer[][]> shader;
	
	public Files(FilePath path) {
		this.retrieveFolderFiles(path);
		this.getFileFromList();
		this.getImageFromFile();
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public File getFile() {
		return this.file;
	}
	
	private void getImageFromFile() {
		try {
			this.image = new Image(new FileInputStream(file.getPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getFileFromList() {
			this.file = fileArr[new Random().nextInt(fileArr.length)];
	}
	
	
	private File[] retrieveFolderFiles(FilePath files) {
		return new File(files.getFile()).listFiles();
	}
	
	/**
	 * Bulk renames files given a path and a name, and saves them as a .png file.
	 * @param path
	 * @param name
	 */
	@Deprecated
	public void renameFiles(FilePath path, FilePath name, FileExtension extension) { 
		String ext = "." + extension.getExtension();
		String filePath = path.getFile();
		String fileName = name.getFile();
		File[] retrieveFolderFiles = retrieveFolderFiles(path);
		Long i = Arrays.stream(retrieveFolderFiles).filter(x -> x.getName().contains(fileName)).count();
		for (File file : retrieveFolderFiles) {
			if (file.getName().contains(fileName) == false) { 
				renameFile(filePath, fileName, i, file, extension);
				i++;
			}
		}
	}

	/**
	 * Renames file given parameters.
	 * @param filePath
	 * @param fileName
	 * @param i the unique id of the file
	 * @param file
	 * @param fileExtention
	 */
	@Deprecated
	public static void renameFile(String filePath, String fileName, Long i, File file, FileExtension extension) {
		file.renameTo(new File(filePath + fileName + i + extension.getExtension()));
	}
}
