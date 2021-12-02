package application.lib.ref.files;

public enum FileExtension {
	
	PNG("png"),
	JPG("jpg");
	
	//String logic
	private String ext;
	
	FileExtension(String ext) { 
		this.ext = ext;
	}
	
	public String getExtension() { 
		return this.ext;
	}	
}
