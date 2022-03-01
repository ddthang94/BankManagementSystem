package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FirstPageController {
	static int id;
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
		try {
			String query1 = "SELECT id,password FROM bank.login WHERE username = '"+tUsername.getText()+"';";
			Statement st = Main.connect.createStatement();
			ResultSet rs = st.executeQuery(query1);
			rs.next();
			String dbpassword = rs.getString(2);
			
			if (dbpassword.contentEquals(tPassword.getText())) {
				System.out.println("Correct password");
				id = rs.getInt(1);
				new Main().changeScene("UserAccount.fxml");
			}
		} catch(SQLException sqlException) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setResizable(false);
			alert.setHeaderText("Please correct the username or password");
			alert.showAndWait();
		}
		//new Main().changeScene("UserAccount.fxml");
	}
	public void SignUp() {
		customer = new Customer(tUsername.getText(), tPassword.getText());
		new Main().changeScene("SignUpForm.fxml");
	}
	
	static public Customer downloadObj(int id) throws SQLException {
		String query2 = "SELECT * FROM bank.information WHERE id = '"+id+"';";
		Statement st = Main.connect.createStatement();
		st.executeQuery(query2);
		ResultSet rs = st.executeQuery(query2);
		rs.next();
		String fname = rs.getString(2);
		String lname = rs.getString(3);
		String username = rs.getString(4);
		String phoneNum = rs.getString(5);
		String email = rs.getString(6);
		String doBirth = rs.getString(7);
		String gender = rs.getString(8);
		Float balance = rs.getFloat(9);
		Customer cust = new Customer(fname, lname, username, phoneNum, email, doBirth, gender, balance);
		return cust;
	}
}
