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
			// declare the query to select all from bank.login where username equal input
			String query1 = "SELECT * FROM bank.login WHERE username = '"+tUsername.getText()+"';";
			// create java statement
			Statement st = Main.connect.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query1);
			// moving the cursor from default position to 1st row
			rs.next();
			String dbusername = rs.getString(2);
			String dbpassword = rs.getString(3);			
			String inputUsername = tUsername.getText();
			String inputPassword = tPassword.getText();
			
			if (inputUsername.equals(dbusername) && inputPassword.equals(dbpassword)) {
				System.out.println("Correct information");
				id = rs.getInt(1);
				System.out.println(id);
				System.out.println(dbusername + " " + dbpassword);
				new Main().changeScene("UserAccount.fxml");
			} else if (inputUsername.equals(dbusername) && inputPassword!=dbpassword) {
				Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setTitle("Alert");
				a.setResizable(false);
				a.setHeaderText("Please insert the correct password!");
				a.showAndWait();
			}
		} catch(SQLException sqlException) {
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Alert");
			a.setResizable(false);
			a.setHeaderText("Account is not available!");
			a.showAndWait();
		}
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
