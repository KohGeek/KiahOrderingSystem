package system.domain.payment_module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import system.domain.item_module.*;
import system.domain.login_module.*;
import system.domain.order_module.*;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
		GetItemFromItemListTest.class,
		AddressInfoUnitTesting.class,
		MemberLoginTest.class,
		SignUpUnitTesting.class,
		AddItemsToCartUnitTest.class,
		EditItemsInCartUnitTest.class,
		GetCartDataUnitTest.class,
		GetCartSubtotalUnitTesting.class,
		GetCartTotalPriceUnitTesting.class,
		GetPriceDeliveryRateUnitTesting.class,
		IdentifyIfCartEmptyUnitTest.class,
		ProceedPaymentIntegrationTest.class,
		ProceedPaymentUnitTest.class,
		GetItemFromItemListTest.class
})

public class TestSuiteTesting {
}
