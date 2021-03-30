package system.login;

//Super class for both Guest and Member 

public abstract class User {
	protected String name;
	protected Address address;

	public String getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// validate setting user name
	// 0 : successful
	// 1 : too short
	// 2 : only whitespace characters
	public int setName(String name) {
		int status = 0;

		if (name.isBlank()) {
			status = 2;
		} else if (name.length() < 5) { // TODO: considering changing this to .isEmpty, given names like "Ava" or "Izzy"
										// can be used.
			status = 1;
		} else {
			status = 0;
			this.name = name;
		}

		return status;
	}
}
