package system.login;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MemberLoginTest {
	//Member member = new Member( "user0000", "pass0000", "", "", null);
	
	/* 
	 * Login Module
	 * Test Case 1.1.1
	 * Equivalence Partitioning
	 */
	@Test
	@Parameters (method = "LoginMemberValidParam")
	public void LoginMemberTestValid(String username, String password) { 
		 MemberList ml = new MemberList("memberData.txt");
		 Member m = ml.getMember(username, password); 
		 String aMResult = m.getUsername();
		 assertEquals(username, aMResult);
	}
	

	private Object [] LoginMemberValidParam () {
		return new Object[] {
		new Object [] { "user0000", "pass0000" },
		
		};
	}
	
	/*
	 * Login Module
	 * Test Case 1.1.2~1.1.9
	 * Equivalence Partitioning
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "LoginMemberInvalidParam")
	public void LoginMemberTestInvalid(String username, String password) { 
		 MemberList ml = new MemberList("memberData.txt");
		 Member m = ml.getMember(username, password); 
		 
	}
	

	private Object [] LoginMemberInvalidParam () {
		return new Object[] {
		new Object [] { "user0000", "pass9999" },
		new Object [] { "user9999", "pass0000" },
		new Object [] { "user9999", "pass9999" },
		new Object [] { "", "pass9999" },
		new Object [] { "", "pass0000" },
		new Object [] { "user9999", "" },
		new Object [] { "user0000", "" },
		new Object [] { "", "" },
		
		};
	}
	
	
}
