package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class AccountController implements Initializable {
    @FXML
    private Tab myInfo;
    @FXML
    private TextField showFname;
    @FXML
    private TextField showLname;
    @FXML
    private TextField showUsername;
    @FXML
    private TextField showPhone;
    @FXML
    private TextField showEmail;
    @FXML
    private TextField showBirthday;
    @FXML
    private TextField showGender;
    @FXML
    private TextField showBalanceInfo;
    @FXML
    private TextField showBalance;
	@FXML
	private Button btnSignOut;
	
	Customer cust;
	
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		try {
			cust = FirstPageController.downloadObj(FirstPageController.id);
			showFname.setText(cust.getFname());
			showLname.setText(cust.getLname());
			showUsername.setText(cust.getUsername());
			showPhone.setText(cust.getPhoneNum());
			showEmail.setText(cust.getEmail());
			showBirthday.setText(cust.getDoBirth());
			showGender.setText(cust.getGender());
			showBalanceInfo.setText(cust.getBalance()+"$");
			showBalance.setText(cust.getBalance()+"$");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void SignOut() {
		new Main().changeScene("SignIn.fxml");
	}
	
	
}
