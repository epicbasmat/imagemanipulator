package application;

import application.lib.imagegen.GenerateImage;
import application.lib.shaders.datagenerators.GenerateShaderData;
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
		primaryStage.setTitle("le test has arrived");
		ImageView view = new ImageView();
		view.setImage(image.getImage());
		Group root = new Group(view);
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		image.setupImageGenerators();
		//GenerateShaderData data = new GenerateShaderData();
		//data.generateShaderData();
	}
}
