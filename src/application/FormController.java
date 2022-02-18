package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FormController {
	@FXML
    private TextField fname;
	@FXML
    private TextField lname;
	@FXML
    private TextField username;
	@FXML
    private PasswordField password;
	@FXML
    private TextField phoneNum;
	@FXML
    private TextField email;
	@FXML
    private DatePicker doBirth;
	@FXML
    private ComboBox<String> gender;
	@FXML
    private Button btnBack;
    @FXML
    private Button btnSubmit;
        
    @FXML
    void Back(ActionEvent event) {
    	new Main().changeScene("SignIn.fxml");
    }

    @FXML
    void Submit(ActionEvent event) {
    	new Main().changeScene("UserAccount.fxml");
    }
}
