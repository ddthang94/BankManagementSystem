package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccountController {
	@FXML
	private Button btnSignOut;
	
	public void SignOut() {
		new Main().changeScene("SignIn.fxml");
	}
}
