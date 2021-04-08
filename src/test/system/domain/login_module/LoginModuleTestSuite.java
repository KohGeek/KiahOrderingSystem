package system.domain.login_module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
	AddressInfoUnitTest.class,
	MemberLoginUnitTest.class,
	MemberSignUpUnitTest.class
})

public class LoginModuleTestSuite {

	
}
