package system_interface;

import system_entity.Member;

public interface IMember {

	public boolean verifyMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member getMember(String username);

}
