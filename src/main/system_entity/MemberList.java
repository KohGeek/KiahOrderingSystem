package system_entity;

import java.util.ArrayList;

import system_interface.Database;
import system_interface.aMember;

public class MemberList implements aMember, Database {

	private ArrayList<Member> memberList;

	@Override
	public void initDataFromFile(String filename) {

	}

	@Override
	public void updateDataToFile(String filename) {

	}

	@Override
	public boolean validateMember(String username, String password) {

		return false;
	}

	@Override
	public void addMember(Member member) {

	}

	@Override
	public boolean searchUsername(String username) {

		return false;
	}

	@Override
	public Member fillMemberDetails(String username) {

		return null;
	}

	public MemberList() {

	}

	@Override
	public Member getMember() {

		return null;
	}

}
