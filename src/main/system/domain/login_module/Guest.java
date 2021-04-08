package system.domain.login_module;

// User who are non-registered, aka non-member
public class Guest extends User {
	
	public Guest(String name) {
		this.name = name;
	}
	
	public Guest() {
		
	}
}
