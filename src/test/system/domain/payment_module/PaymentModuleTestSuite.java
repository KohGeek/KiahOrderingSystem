package system.domain.payment_module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
	ProceedPaymentIntegrationTest.class,
	ProceedPaymentUnitTest.class
})

public class PaymentModuleTestSuite {

}
