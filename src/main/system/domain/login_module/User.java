package system.domain.login_module;

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

	public void setName(String name) {

		if (name.isBlank()) {
			throw new IllegalArgumentException("Name must not be blank!");
		} else if (name.length() < 5) { //Consider < 3, since Ava, Ash, etc are all valid names
			throw new IllegalArgumentException("Name must be at least 5 character long.");
		}
		this.name = name;

	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
