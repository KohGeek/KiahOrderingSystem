package system.main;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import system.domain.item_module.*;
import system.domain.login_module.*;
import system.domain.order_module.*;
import system.domain.payment_module.*;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
	ItemModuleTestSuite.class,
	LoginModuleTestSuite.class,
	OrderModuleTestSuite.class,
	PaymentModuleTestSuite.class
})

public class CompleteTestSuite {
	
}
