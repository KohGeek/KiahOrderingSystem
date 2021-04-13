package system.domain.login_module;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MemberSignUpUnitTest {
	
	
	/*
	* Login Module Unit Test
	* Test case 3.1.1
	* -Equivalence Partitioning
	*/
	@Test
	@Parameters(method = "nameValidTestParams")
	public void nameValidTest(String name) {
		User $name = new Guest(name);
		$name.setName(name);
		String actualResult = $name.getName();
		assertEquals(name, actualResult);
	}
	
	private Object[] nameValidTestParams() {
		return new Object[] {
				new Object[] {"Lim Xiao Ming"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.1.2 ~ 3.1.3
	* -Equivalence Partitioning 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "nameInvalidTestParams")
	public void nameInvalidTest(String name) {
		User $name = new Guest(name);
		$name.setName(name);
	}
	
	private Object[] nameInvalidTestParams() {
		return new Object[] {
				new Object[] {"Lim"},
				new Object[] {""}
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.2.1
	* ----- 
	*/
	@Test
	@Parameters(method = "usernameValidTestParams")
	public void usernameValidTest(String username) {
		MemberList $memberlist = new MemberList("memberData.txt"); // Username is taken //
		Member actualResult = $memberlist.searchUsername(username); // Username is taken //
		assertEquals(username, actualResult.getUsername());
	}
	
	private Object[] usernameValidTestParams() {
		return new Object[] {
				new Object[] {"XiaoMing00"}

		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.2.2 ~ 3.2.4
	* -----
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "usernameInvalidTestParams")
	public void usernameInvalidTest(String username) {
		MemberList $memberlist = new MemberList("memberData.txt"); // Username is taken //
		$memberlist.searchUsername(username); // Username is taken //
	}
	
	private Object[] usernameInvalidTestParams() {
		return new Object[] {
				new Object[] {"user1111"},
				new Object[] {""},
				new Object[] {"user"}
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.3.1
	* -Equivalence Partitioning
	*/
	@Test
	@Parameters(method = "passwordValidTestParams")
	public void passwordValidTest(String password, String password2) {
		Member $member = new Member(null, password, null , null, null);
		$member.setPassword(password, password2);
		String actualResult = $member.getPassword();
		assertEquals(password, actualResult);
	}
	
	private Object[] passwordValidTestParams() {
		return new Object[] {
				new Object[] {"password1234", "password1234"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.3.2 ~ 3.3.4
	* -Equivalence Partitioning
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "passwordInvalidTestParams")
	public void passwordInvalidTest(String password, String password2) {
		Member $member = new Member("user1111");
		$member.setPassword(password, password2);
	}
	
	private Object[] passwordInvalidTestParams() {
		return new Object[] {
				new Object[] {"pass1234", "pass123"},
				new Object[] {"pass", "pass"},
				new Object[] {"", ""}
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.4.1
	* -Equivalence Partitioning
	*/
	@Test
	@Parameters(method="phoneNumberValidTestParams")
	public void phoneNumberValidTest(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
		String actualResult = $member.getPhoneNumber();
		assertEquals(phoneNumber, actualResult);
	}
	
	private Object[] phoneNumberValidTestParams() {
		return new Object[] {
				new Object[] {"0123456789"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.4.2 ~ 3.4.5
	* -Equivalence Partitioning
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="phoneNumberInvalidTestParams")
	public void phoneNumberInvalidTest(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
	}
	
	private Object[] phoneNumberInvalidTestParams() {
		return new Object[] {
				new Object[] {"012345678"},
				new Object[] {"0112233456789"},
				new Object[] {""},
				new Object[] {"asdasdasda"}
		};
	}
	
	
}
	