package application.lib.ref.files;

public enum FilePath { 
	
	
	/**
	 * Root path
	 */
	BASE_FILEPATH("./assets/"),
	
	/**
	 * Asset path
	 */
	FILE_ASSETS(BASE_FILEPATH.getFile() + "assets/"),
	
	
	/**
	 * Colour resources
	 */
	FILE_COLOUR(BASE_FILEPATH.getFile() + "colour/"),
	FILENAME_COLOUR(FILE_COLOUR + "hexvalues.ser"),
	
	/**
	 * Shader resources
	 */
	FILE_SHADER(BASE_FILEPATH.getFile() + "shaders/"),
	
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
	FILEPATH_OUTPUT(BASE_FILEPATH.getFile() + "output/"),
	
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