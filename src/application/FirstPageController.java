package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FirstPageController {
	
	@FXML
	private TextField tUsername;
	@FXML
	private PasswordField tPassword;
	@FXML
	private Button btnSignIn;
	@FXML
	private Button btnSignUp;
		
	public void SignIn() {
		try {
			
		} catch (Exception e) {
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Messages");
			a.setResizable(false);
			a.setHeaderText("To continue, you have to fill in the Username and Password!");
			a.showAndWait();
		}
			new Main().changeScene("UserAccount.fxml");
	}
	public void SignUp() {
		new Main().changeScene("SignUpForm.fxml");
	}
}
