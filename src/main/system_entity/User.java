package system_entity;

import system_interface.aMember;
import system_interface.aUser;

public class User implements aUser {

	private UserType type;
	private aMember memberList;
	private Member member;
	private Address address;
	private String guestName;

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guestLogin(String name, Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void signUp(String username) {
		// TODO Auto-generated method stub

	}

	public User() {

	}

}
