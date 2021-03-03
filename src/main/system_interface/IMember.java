package system_interface;

import system_entity.Member;

//Interface for the MemberList class

public interface IMember {

	public boolean verifyMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member getMember(String username);

}
