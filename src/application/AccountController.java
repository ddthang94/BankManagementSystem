package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AccountController implements Initializable {
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
    private TextField showBalance;
    @FXML
    private TextField showBalanceDP;
    @FXML
    private TextField showBalanceWD;
    @FXML
    private TextField numDeposit;
    @FXML
    private TextField numWithdraw;
	@FXML
	private Button btnSignOut;
	@FXML
	private Button btnDeposit;
	@FXML
	private Button btnWithdraw;
    
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
			showBalance.setText(cust.getBalance()+"$");
			showBalanceDP.setText(cust.getBalance()+"$");
			showBalanceWD.setText(cust.getBalance()+"$");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Deposit() throws SQLException {
		float depositMoney = Float.parseFloat(numDeposit.getText());
		float total = cust.getBalance() + depositMoney;
		String query = "UPDATE `bank`.`information` SET `balance` = '"+total+"' WHERE (`id` = '"+FirstPageController.id+"');";
		Statement st = Main.connect.createStatement();
		int i = st.executeUpdate(query);
		if (i==1) {
			System.out.println("Success add money");
			String getBalance = "SELECT balance FROM bank.information WHERE id="+FirstPageController.id+";";
			ResultSet rs = st.executeQuery(getBalance);
			rs.next();
			float dbBalance = rs.getFloat(1);
			System.out.println(dbBalance);
			showBalanceDP.setText(dbBalance+"$");
			showBalance.setText(dbBalance+"$");
			showBalanceWD.setText(dbBalance+"$");
			cust.setBalance(dbBalance);
			numDeposit.setText("");
		}
		else System.out.println("Failure");
	}
	
	public void Withdraw() throws SQLException {
		float withdrawMoney = Float.parseFloat(numWithdraw.getText());
		float total = cust.getBalance() - withdrawMoney;
		if (total >= 0) {
			String query = "UPDATE `bank`.`information` SET `balance` = '"+total+"' WHERE (`id` = '"+FirstPageController.id+"');";
			Statement st = Main.connect.createStatement();
			int i = st.executeUpdate(query);
			if (i==1) {
				System.out.println("Success withdraw money");
				String getBalance = "SELECT balance FROM bank.information WHERE id="+FirstPageController.id+";";
				ResultSet rs = st.executeQuery(getBalance);
				rs.next();
				float dbBalance = rs.getFloat(1);
				System.out.println(dbBalance);
				showBalanceDP.setText(dbBalance+"$");
				showBalance.setText(dbBalance+"$");
				showBalanceWD.setText(dbBalance+"$");
				cust.setBalance(dbBalance);
				numWithdraw.setText("");
			}
			else System.out.println("Failure");
		} else {
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Error");
			a.setResizable(false);
			a.setHeaderText("Money to withdraw is bigger than current balance!");
			a.showAndWait();
		}
	}
	
	public void processNumber (ActionEvent event) {
		Button button = (Button)event.getSource();
		String buttonText = button.getText();
		if (buttonText.matches("[0-9\\.]")) {
			numDeposit.appendText(buttonText);
			return;
		}
	}
	
	public void SignOut() {
		new Main().changeScene("SignIn.fxml");
	}
}
