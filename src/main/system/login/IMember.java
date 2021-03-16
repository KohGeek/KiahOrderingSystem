package system.login;

public interface IMember {

	public boolean validateMember(String username, String password);

	public void addMember(Member member);

	public boolean searchUsername(String username);

	public Member getMember(String username);

}
