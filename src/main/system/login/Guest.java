package system.login;

// User who are non-registered, aka non-member
public class Guest extends User {
	public Guest(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Guest() {

	}
}
