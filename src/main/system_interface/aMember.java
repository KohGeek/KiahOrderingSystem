package system_interface;

import system_entity.Member;

public interface aMember {

	public boolean validateMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member fillMemberDetails(String username);

	public Member getMember();

}
