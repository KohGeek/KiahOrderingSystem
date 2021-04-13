package system.domain.login_module;

public interface IMember {

	public void addMember(Member member);

	public Member searchUsername(String username);

	public void updateDataToFile(String filename);

	public Member getMember(String username, String password);

	public Member getMember(String username);
}
