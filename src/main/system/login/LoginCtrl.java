package system.login;

public class LoginCtrl {

	private IMember memberList;

	public LoginCtrl(IMember memberList) {
		this.memberList = memberList;
	}

	public boolean validateMember(String username, String password) {
		String $username = username;
		String $password = password;
		boolean VAL = this.memberList.validateMember($username, $password);
		return VAL; // VAL = validate status
	}

	public Member getMember(String username) {
		String $username = username;
		Member member = this.memberList.getMember($username);
		return member;
	}

	public boolean searchUsername(String username) {
		String $username = username;
		boolean VAL = this.memberList.searchUsername($username);
		return VAL;
	}
	
	public void addMember(Member member) {
		Member $member = member;
		this.memberList.addMember($member);
	}
}
