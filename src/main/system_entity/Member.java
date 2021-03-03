package system_entity;

// Member class
// Stores data about individual registered member
// For an array of member, check MemberList

public class Member extends User {

	private String username;
	private String password;
	private String phoneNumber;

	// Constructor
	public Member(String username, String password, String phoneNumber, String name, Address address) {

		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
		this.type = UserType.Member;

	}

	// getUsername()
	// Return type: String
	// returns username
	public String getUsername() {

		return this.username;

	}

	// getPassword()
	// Return type: String
	// returns password
	public String getPassword() {

		return this.password;

	}

	// getPhoneNumber()
	// Return type: String
	// returns phone number
	public String getPhoneNumber() {

		return this.phoneNumber;

	}

	// getName()
	// Return type: String
	// returns user's full name
	public String getName() {

		return this.name;

	}

	// getAddress()
	// Return type: Address object
	// returns address as an object
	public Address getAddress() {

		return this.address;

	}

}
