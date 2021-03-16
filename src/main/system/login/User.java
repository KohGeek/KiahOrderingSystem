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
}
