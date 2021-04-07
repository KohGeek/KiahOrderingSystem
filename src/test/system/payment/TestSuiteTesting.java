package system.payment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import system.login.*;
import system.menu.*;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
//		AddressInfoUnitTesting.class,
//		MemberLoginTest.class,
//		SignUpUnitTesting.class,
		AddItemsToCartUnitTesting.class,
		EditItemsInCartUnitTesting.class,
		GetCartData.class,
		GetCartSubtotalUnitTesting.class,
		GetCartTotalPriceUnitTesting.class,
		GetPriceDeliveryRateUnitTesting.class,
		IdentifyCartOrderUnitTesting.class,
		OrderUnitTesting.class,
//		ProceedPaymentIntegrationTest.class,
//		ProceedPaymentUnitTest.class
})

public class TestSuiteTesting {
}
