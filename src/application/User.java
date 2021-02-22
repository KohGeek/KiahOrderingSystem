package application;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	// default serialVersion id
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String phoneNumber;
	private String name;
	private Address address;

	public User(String username, String password, String phoneNumber, String name, Address address) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public boolean verifyMember(ArrayList<User> userList) {
		for (int i = 0; i < userList.size(); i++) {
			if (this.username.trim().equals(userList.get(i).getUsername().trim()))
				if (this.password.trim().equals(userList.get(i).getPassword().trim()))
					return true;
		}

		return false;
	}

	public User(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	private String getUsername() {
		return this.username;
	}

	private String getPassword() {
		return this.password;
	}

	public void setUser(ArrayList<User> userList) {
		for (int i=0; i<userList.size();i++)
			if (this.username == userList.get(i).getUsername()) {
				this.name = userList.get(i).getName();
				this.phoneNumber = userList.get(i).getPhoneNumber();
				this.address = userList.get(i).getAddress();
			}
	}

	public User signUp(String userFile, String addressFile) {
		// ask user to key-in member's details, then store the new member into the file,
		// and return a User account.
		
		return;
	}

}
