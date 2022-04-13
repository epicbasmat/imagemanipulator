package application;

import application.lib.fxlib.FxSetup;
import application.lib.imagegen.GenerateImage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static boolean gen;
	
	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GenerateImage image = new GenerateImage(new WritableImage(64, 64));
		image.setupImageGenerators();
		primaryStage.setTitle("NFT Generators.");
		new FxSetup(primaryStage, image).setupScene();
	}
}
