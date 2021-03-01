package system_entity;

import system_interface.isMember;

public class Member implements isMember {

	private String username;
	private String password;
	private String phoneNumber;
	private String name;
	private Address address;

	@Override
	public boolean verifyMember(String username, String password) {

		return false;
	}

	public Member(String username, String password, String phoneNumber, String[] addressDetails) {

		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		// TODO addressdetails

	}

	public String getUsername() {

		return null;
	}

	public String getPassword() {

		return null;
	}

}
