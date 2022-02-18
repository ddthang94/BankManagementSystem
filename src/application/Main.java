package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	static Stage pstage;

	@Override
	public void start(Stage primaryStage) {
		pstage = primaryStage;
		changeScene("SignIn.fxml");
	}
	
	// changeScene() function is used to switch between Scenes(Page)
	public void changeScene(String gui) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(gui)); // loading the FXML file
			Scene scene = new Scene(root);
			Image icon = new Image("icon.png"); // create object icon
			
			pstage.setTitle("Bank Management System"); // set the software title
			pstage.getIcons().add(icon); // add icon on title
			pstage.setScene(scene); //scene=content inside window
			pstage.setResizable(false); //window cannot resize
			pstage.show(); // showing window on screen
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		// connect to local instance in the secured mode
				
		// launching the window
		launch(args);
	}
}
