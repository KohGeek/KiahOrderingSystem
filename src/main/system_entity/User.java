package system_entity;

import system_interface.Database;
import system_interface.aMember;
import system_interface.aUser;

public class User implements aUser {

	private UserType type;
	private aMember memberList;
	private Member member;
	private Address address;
	private String guestName;
	private Database memberListFromFile;

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
		this.memberList = new MemberList();
		this.memberListFromFile = new MemberList();

		memberListFromFile.initDataFromFile("fileName");
		
		memberList.setMemberList(memberListFromFile.getData());

	}

}
