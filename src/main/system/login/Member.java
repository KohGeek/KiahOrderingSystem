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

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
