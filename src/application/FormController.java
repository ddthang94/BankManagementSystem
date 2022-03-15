package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FormController implements Initializable {
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
	private Button btnSubmit;
	@FXML
	private Button btnBack;
    
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		doBirth.setValue(LocalDate.now());
		gender.setItems(FXCollections.observableArrayList("Male","Female"));
	}	
    
    public void Back() {
    	new Main().changeScene("SignIn.fxml");
    }
    
    public void Submit() throws SQLException {
    	Customer cust = new Customer(fname.getText(), lname.getText(), username.getText(), password.getText(), phoneNum.getText(), 
    								email.getText(), doBirth.getValue().toString(), gender.getSelectionModel().getSelectedItem());
    	objUpload(cust);
    	new Main().changeScene("SignIn.fxml");
    }
    
    public void objUpload(Customer cust) throws SQLException {
    	String query1 = "INSERT INTO `bank`.`information` VALUES (NULL,'"+cust.getFname()+"','"+cust.getLname()+"','"+cust.getUsername()+"','"+cust.getPhoneNum()+"',"
    															+ "'"+cust.getEmail()+"','"+cust.getDoBirth()+"','"+cust.getGender()+"', "+0+");";
    	PreparedStatement ps = Main.connect.prepareStatement(query1);
    	int checkquery1 = ps.executeUpdate();
    	if (checkquery1==1) {
    		System.out.println("Succeed!");
    	} else {
    		System.out.println("Succeed!");
    	}
    	String query2 = "INSERT INTO `bank`.`login` VALUES (NULL,'"+cust.getUsername()+"','"+cust.getPassword()+"');";
    	ps = Main.connect.prepareStatement(query2);
    	int checkquery2 = ps.executeUpdate();
    	if (checkquery2==1) {
    		System.out.println("Succeed!");
    	} else {
    		System.out.println("Succeed!");
    	}
    }
}
