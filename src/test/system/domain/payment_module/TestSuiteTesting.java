package system.domain.payment_module;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import system.domain.item_module.*;
import system.domain.login_module.*;
import system.domain.order_module.*;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
		AddressInfoUnitTesting.class,
		MemberLoginTest.class,
		SignUpUnitTesting.class,
		AddItemsToCartUnitTest.class,
		EditItemsInCartUnitTesting.class,
		GetCartData.class,
		GetCartSubtotalUnitTesting.class,
		GetCartTotalPriceUnitTesting.class,
		GetPriceDeliveryRateUnitTesting.class,
		IdentifyCartOrderUnitTesting.class,
		ProceedPaymentIntegrationTest.class,
		ProceedPaymentUnitTest.class
})

public class TestSuiteTesting {
}
