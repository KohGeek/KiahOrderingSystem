package system_interface;

import system_entity.Address;

public interface aUser {

	public void login(String username, String password);

	public void guestLogin(String name, Address address);

	public void signUp(String username);

}
