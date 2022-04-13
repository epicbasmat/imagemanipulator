package application.lib.fxlib;

import application.lib.imagegen.GenerateImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FxSetup extends BorderPane{
	
	private Stage stage;
	private GenerateImage image;
	private Label displayText;
	private Button shdrButton;
	private Button nftButton;
	
	
	public static String strGeneric = "Messages will appear here";
	public static String strFilePath = "File location of selected image: ";
	public static String strDataGen = "Generating data";
	public static String strProgress = "Generated: ";
	public static String strSavedAs = "File saved as: ";
	
	public FxSetup(Stage stage, GenerateImage image) {
		this.stage = stage;
		this.image = image;
	}
	
	public void setupScene() {
		
		//Setup of message view
		displayText = new Label(strGeneric);
		StackPane sp = new StackPane();
		sp.getChildren().add(displayText);
		this.setBottom(sp);
		
		//Setup of generic flowpane
		FlowPane fp = new FlowPane();
		fp.setHgap(20);
		fp.setVgap(20);
		fp.setPadding(new Insets(20));
		this.setCenter(fp);
		
		Insets inset5 = new Insets(5);
		
		//Setup of labels & buttons
		
		//Overarching vbox
		VBox container = new VBox();
		container.setPadding(new Insets(5));
		
		// - HBox to contain labels
		HBox labelBox = new HBox();
		
		// - - Label for generating shader data
		Label shader = new Label("Generate shader data");
		shader.setFont(Font.font("Calibri", 16));
		shader.setPadding(new Insets(5));
		labelBox.getChildren().add(shader);
		
		// - - Label for generating NFTs
		Label nft = new Label ("Generate NFT");
		nft.setFont(Font.font("Calibri", 16));
		nft.setPadding(new Insets(5));
		labelBox.getChildren().add(nft);
		
		//Apply label hbox to vbox container
		container.getChildren().add(labelBox);
		
		// - HBox to contain buttons
		HBox buttonBox = new HBox();
		buttonBox.setPadding(inset5);
		
		// - - Button to generate shader data
		shdrButton = new Button("Generate shader data");
		shdrButton.setPrefSize(100, 50);
		shdrButton.setPadding(new Insets(5));
		buttonBox.getChildren().add(shdrButton);
		
		// - - Button to generate NFTs
		nftButton = new Button("Generate NFTs");
		nftButton.setPrefSize(100, 50);
		nftButton.setPadding(inset5);
		buttonBox.getChildren().add(nftButton);
		
		//Apply button hbox to vbox container
		container.getChildren().add(buttonBox);
		
		
		//Apply vbox container to fp
		fp.getChildren().add(container);
		
		
		//Setup of image view
		ImageView view = new ImageView();
		view.setImage(image.getImage());	
		HBox hbox = new HBox(view);
		hbox.setScaleX(3);
		hbox.setScaleY(3);

		Group root = new Group(this);
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public void attachNFTButtonHandler(EventHandler<ActionEvent> event ) {
		
	}
	
}
