package application.lib.render;

import application.lib.misc.Files;
import application.lib.ref.files.FilePath;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class RenderNFT {
	
	private Scene scene;
	
	public RenderNFT(Scene scene) {
		this.scene = scene;
	}
	
	public Scene loadNFT() {
		Group group = new Group();
		Image image = new Files(FilePath.FILEPATH_OBJECT).getImage();
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(640);
		imageView.setFitWidth(640);
		VBox root = new VBox();
		root.getChildren().addAll(imageView);
		scene.setRoot(root);
		return scene;
	}
	
}
