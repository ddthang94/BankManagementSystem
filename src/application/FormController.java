package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FormController {
	@FXML
	private Button btnBack;
	@FXML
	private Button btnSubmit;
	
	public void Submit() {
		new Main().changeScene("SignIn.fxml");
	}
	public void Back() {
		new Main().changeScene("SignIn.fxml");
	}
}
