package application;

import javafx.fxml.FXML;
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
	
	static Customer customer;
	
	public void SignIn() {
		new Main().changeScene("UserAccount.fxml");
	}
	public void SignUp() {
		new Main().changeScene("SignUpForm.fxml");
	}
}
