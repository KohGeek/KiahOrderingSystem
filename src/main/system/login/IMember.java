package system.login;

public interface IMember {

	public Member getMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member getMember(String username);
	
	public void updateDataToFile(String filename);
}
