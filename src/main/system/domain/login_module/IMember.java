package system.domain.login_module;

public interface IMember {

	public Member getMember(String username, String password);

	public void addMember(Member member);

	public Member searchUsername(String username);

	public Member getMember(String username);
	
	public void updateDataToFile(String filename);
}
