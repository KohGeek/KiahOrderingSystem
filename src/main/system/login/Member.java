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

	public Member() {

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

	// validate username
	// 0 : successful
	// 1 : too short
	// 2 : only whitespace character
	public int setUsername(String username) {
		int status = 0;

		if (username.isBlank()) {
			status = 2;
		} else if (username.length() < 5) {
			status = 1;
		} else {
			status = 0;
			this.username = username;
		}

		return status;
	}

	// validate password
	// 0 : successful
	// 1 : too short
	// 2 : only whitespace character
	// 3 : password mismatch
	public int setPassword(String password, String password2) {
		int status = 0;

		if (password.isBlank()) {
			status = 2;
		} else if (password.length() < 5) {
			status = 1;
		} else if (!password.equals(password2)) {
			status = 3;
		} else {
			status = 0;
			this.password = password;
		}

		return status;
	}

	// validate phone number
	// 0 : successful
	// 1 : out of range
	// 2 : contains non-number
	public int setPhoneNumber(String phoneNumber) {
		int status = 0;

		if (phoneNumber.matches("\\D+")) {
			status = 2;
		} else if (phoneNumber.length() < 11 || phoneNumber.length() > 12) {
			status = 1;
		} else {
			status = 0;
			this.phoneNumber = phoneNumber;
		}

		return status;
	}
}
