package system.login;

public class Member extends User {
	private String username;
	private String password;
	private String phoneNumber;

	public Member(String username, String password, String phoneNumber, String name, Address address) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
	}

	public Member(String username) {
		if (username.isBlank()) {
			throw new IllegalArgumentException("Name must not be blank!");
		} else if (username.length() < 5) {
			throw new IllegalArgumentException("Name must be at least 5 character long.");
		}
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	// validate password
	public void setPassword(String password, String password2) {

		if (password.isBlank()) {
			throw new IllegalArgumentException("Password must not be blank!");
		} else if (password.length() < 5) {
			throw new IllegalArgumentException("Password must be at least 5 character long.");
		} else if (!password.equals(password2)) {
			throw new IllegalArgumentException("Password does not match!");
		}

		this.password = password;

	}

	// validate phone number
	public void setPhoneNumber(String phoneNumber) {

		if (phoneNumber.matches("\\D+")) {
			throw new IllegalArgumentException("Input must be numerical only!");
		} else if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
			throw new IllegalArgumentException("Phone number must be between 10-11 characters long.");
		}

		this.phoneNumber = phoneNumber;

	}
}
