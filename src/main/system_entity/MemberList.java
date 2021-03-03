package system_entity;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public ArrayList<Member> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemberList(ArrayList<Member> memberList) {
		// TODO Auto-generated method stub
		
	}
}
