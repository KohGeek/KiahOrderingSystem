package system.domain.login_module;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.login_module.Guest;
import system.domain.login_module.Member;
import system.domain.login_module.MemberList;
import system.domain.login_module.User;

@RunWith(JUnitParamsRunner.class)
public class SignUpUnitTesting {
	
	
	/*
	* Login Module Unit Test
	* Test case 3.1.1
	* -Equivalence Partitioning
	*/
	@Test
	@Parameters(method="getNameTestValid")
	public void testNameInformationValid(String name) {
		User $name = new Guest(name);
		$name.setName(name);
		String actualResult = $name.getName();
		assertEquals(name, actualResult);
	}
	
	private Object[] getNameTestValid() {
		return new Object[] {
				new Object[] {"Lim Xiao Ming"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.1.2 ~ 3.1.3
	* --Equivalence Partitioning 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "getNameTestInvalid")
	public void testNameInformationInvalid(String name) {
		User $name = new Guest(name);
		$name.setName(name);
	}
	
	private Object[] getNameTestInvalid() {
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
	@Parameters(method="getUserNameTestValid")
	public void testUserNameValid(String username) {
		MemberList $memberlist = new MemberList("memberData.txt"); // Username is taken //
		Member actualResult = $memberlist.searchUsername(username); // Username is taken //
		assertEquals(username, actualResult.getUsername());
	}
	
	private Object[] getUserNameTestValid() {
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
	@Parameters(method="getUserNameTestInvalid")
	public void testUserNameInvalid(String username) {
		MemberList $memberlist = new MemberList("memberData.txt"); // Username is taken //
		Member actualResult = $memberlist.searchUsername(username); // Username is taken //
	}
	
	private Object[] getUserNameTestInvalid() {
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
	@Parameters(method="getPasswordTestValid")
	public void testPasswordValid(String password, String password2) {
		Member $member = new Member(null, password, null , null, null);
		$member.setPassword(password, password2);
		String actualResult = $member.getPassword();
		assertEquals(password, actualResult);
	}
	
	private Object[] getPasswordTestValid() {
		return new Object[] {
				new Object[] {"password1234", "password1234"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.3.2 ~` 3.3.4
	* -Equivalence Partitioning
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="getPasswordTestInvalid")
	public void testPasswordInvalid(String password, String password2) {
		Member $member = new Member("user1111");
		$member.setPassword(password, password2);
		String actualResult = $member.getPassword();
	}
	
	private Object[] getPasswordTestInvalid() {
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
	@Parameters(method="getPhoneNumTestValid")
	public void testPhoneNumberValid(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
		String actualResult = $member.getPhoneNumber();
		assertEquals(phoneNumber, actualResult);
	}
	
	private Object[] getPhoneNumTestValid() {
		return new Object[] {
				new Object[] {"0123456789"},
		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.4.2 ~` 3.4.4
	* -Equivalence Partitioning
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="getPhoneNumTestInvalid")
	public void testPhoneNumberInvalid(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
		String actualResult = $member.getPhoneNumber();
	}
	
	private Object[] getPhoneNumTestInvalid() {
		return new Object[] {
				new Object[] {"012345678"},
				new Object[] {"0112233456789"},
				new Object[] {""},
				new Object[] {"asdasdasda"}
		};
	}
	
	
}
	