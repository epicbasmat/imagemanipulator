package application.lib.ref;

public enum FilePath { 
	/**
	 * FilePath contains references to the file paths required to access and manipulate images.
	 * Access to the string names are provided with the public getFile() method.
	 * 
	 * @author fembasmat
	 */
	
	/**
	 * Root path
	 */
	FILEPATH("./test_asset/"),
	
	/**
	 * Asset path
	 */
	FILE_ASSETS(FILEPATH.getFile() + "assets/"),
	
	
	/**
	 * Colour resources
	 */
	FILE_COLOUR(FILEPATH.getFile() + "colour/"),
	FILENAME_COLOUR("hexvalues.ser"),
	FILEPATH_COLOUR(FILE_COLOUR.getFile() + FILENAME_COLOUR.getFile()),
	
	/**
	 * Shader resources
	 */
	FILE_SHADER(FILEPATH.getFile() + "shaders/"),
	
	/**
	 * Background resources
	 */
	FILEPATH_BG(FILE_ASSETS.getFile() + "bg/"),
	FILENAME_BG("bg_"),
	
	/**
	 * Primary object resources
	 */
	FILEPATH_OBJECT(FILE_ASSETS.getFile() + "primary_object/"),
	
	/**
	 * Accessories resources
	 */
	FILEPATH_ACCESSORIES(FILE_ASSETS.getFile() + "accessories/"),

	/**
	 * Backup resources
	 */
	FILEPATH_BACKUP(FILE_ASSETS.getFile() + "backup"),
	
	/**
	 * NFT Output
	 */
	FILEPATH_OUTPUT(FILEPATH.getFile() + "output/"),
	
	/**
	 * Frame resources
	 */
	FILEPATH_FRAME(FILE_ASSETS.getFile() + "frame/");
	
	//String logic
	private String path;
	FilePath(String path) { 
		this.path = path;
	}
	
	public String getFile() { 
		return this.path;
	}	
}