package system.domain.login_module;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.login_module.Member;
import system.domain.login_module.MemberList;

@RunWith(JUnitParamsRunner.class)
public class MemberLoginUnitTest {
	//Member member = new Member( "user0000", "pass0000", "", "", null);
	
	/* 
	 * Login Module
	 * Test Case 1.1.1
	 * Equivalence Partitioning
	 */
	@Test
	@Parameters (method = "loginMemberValidParam")
	public void loginMemberTestValid(String username, String password) { 
		 MemberList ml = new MemberList("memberData.txt");
		 Member m = ml.getMember(username, password); 
		 String aMResult = m.getUsername();
		 assertEquals(username, aMResult);
	}
	

	private Object [] loginMemberValidParam () {
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
	@Parameters (method = "loginMemberInvalidParams")
	public void loginMemberTestInvalid(String username, String password) { 
		 MemberList ml = new MemberList("memberData.txt");
		 Member m = ml.getMember(username, password); 
		 
	}
	

	private Object [] loginMemberInvalidParams () {
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
