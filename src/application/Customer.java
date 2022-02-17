package application;

public class Customer {
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String phoneNum;
	private String email;
	private String doBirth;
	private String gender;
	private float balance;
	
	/* Constructors */
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Customer(String fname, String lname, String username, String phoneNum, String email, String doBirth, String gender, float balance) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.phoneNum = phoneNum;
		this.email = email;
		this.doBirth = doBirth;
		this.gender = gender;
		this.balance = balance;
	}

	public Customer(String fname, String lname, String username, String password, String phoneNum, String email, String doBirth, String gender) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.phoneNum = phoneNum;
		this.email = email;
		this.doBirth = doBirth;
		this.gender = gender;
		this.balance = 0f;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public String getDoBirth() {
		return doBirth;
	}

	public String getGender() {
		return gender;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
