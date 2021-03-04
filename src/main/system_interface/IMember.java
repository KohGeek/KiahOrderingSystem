package system_interface;

import java.util.ArrayList;

import system_entity.Member;

public interface IMember {

	public boolean validateMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member fillMemberDetails(String username);

	public Member getMember(String username);
	
	public void setMemberList(ArrayList<Member> memberList);

}
