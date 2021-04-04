package system.login;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class SignUpUnitTesting {
	
	private Object[] getNameTestValid() {
		return new Object[] {
				new Object[] {"Lim Xiao Ming"},
		};
	}
	
	private Object[] getNameTestInvalid() {
		return new Object[] {
				new Object[] {"Lim"},
				new Object[] {""}
		};
	}
	
	private Object[] getUserNameTestValid() {
		return new Object[] {
				new Object[] {"XiaoMing00"}

		};
	}
	
	private Object[] getUserNameTestInvalid() {
		return new Object[] {
				new Object[] {"user1111"},
				new Object[] {""},
				new Object[] {"user"}
		};
	}
	
	private Object[] getPasswordTestValid() {
		return new Object[] {
				new Object[] {"password1234", "password1234"},
		};
	}
	
	private Object[] getPasswordTestInvalid() {
		return new Object[] {
				new Object[] {"pass1234", "pass123"},
				new Object[] {"pass", "pass"},
				new Object[] {"", ""}
		};
	}
	
	private Object[] getPhoneNumTestValid() {
		return new Object[] {
				new Object[] {"0123456789"},
		};
	}
	
	private Object[] getPhoneNumTestInvalid() {
		return new Object[] {
				new Object[] {"012345678"},
				new Object[] {"0112233456789"},
				new Object[] {""},

		};
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.1.1
	* -- 
	*/
	@Test
	@Parameters(method="getNameTestValid")
	public void testNameInformationValid(String name) {
		User $name = new Guest(name);
		$name.setName(name);
		String actualResult = $name.getName();
		assertEquals(name, actualResult);
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.1.2 ~ 3.1.3
	* -- 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "getNameTestInvalid")
	public void testNameInformationInvalid(String name) {
		User $name = new Guest(name);
		$name.setName(name);
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.2.1
	* -- 
	*/
	@Test
	@Parameters(method="getUserNameTestValid")
	public void testUserNameValid(String username) {
		Member $member = new Member(username);
		MemberList $member1 = new MemberList("memberData.txt"); // Username is taken //
		String actualResult = $member.getUsername(); 
		boolean actualResult1 = $member1.searchUsername("user1111"); // Username is taken //
		assertEquals(username, actualResult);
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.2.2 ~ 3.2.4
	* -- 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="getUserNameTestInvalid")
	public void testUserNameInvalid(String username) {
		Member $member = new Member(username);
		String actualResult = $member.getUsername(); // Username is taken //
		MemberList $member1 = new MemberList("memberData.txt");
		boolean actualResult1 = $member1.searchUsername("user1111"); // Username is taken //
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.3.1
	* -- 
	*/
	@Test
	@Parameters(method="getPasswordTestValid")
	public void testPasswordValid(String password, String password2) {
		Member $member = new Member(null, password, null , null, null);
		$member.setPassword(password, password2);
		String actualResult = $member.getPassword();
		password.equals(password2);
		assertEquals(password, actualResult);
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.3.2 ~` 3.3.4
	* -- 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="getPasswordTestInvalid")
	public void testPasswordInvalid(String password, String password2) {
		Member $member = new Member("user1111");
		$member.setPassword(password, password2);
		String actualResult = $member.getPassword();
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.4.1
	* -- 
	*/
	@Test
	@Parameters(method="getPhoneNumTestValid")
	public void testPhoneNumberValid(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
		String actualResult = $member.getPhoneNumber();
		assertEquals(phoneNumber, actualResult);
	}
	
	/*
	* Login Module Unit Test
	* Test case 3.4.2 ~` 3.4.4
	* -- 
	*/
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method="getPhoneNumTestInvalid")
	public void testPhoneNumberInvalid(String phoneNumber) {
		Member $member = new Member("user1111");
		$member.setPhoneNumber(phoneNumber);
		String actualResult = $member.getPhoneNumber();
	}
	
	
	
	
}
	