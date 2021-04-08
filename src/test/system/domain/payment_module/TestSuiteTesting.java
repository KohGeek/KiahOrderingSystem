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
		AddressInfoUnitTest.class,
		MemberLoginTest.class,
		MemberSignUpUnitTest.class,
		AddItemsToCartUnitTest.class,
		EditItemsInCartUnitTest.class,
		GetCartDataUnitTest.class,
		GetCartTotalPriceIntegrationTest.class,
		GetOrderTotalPriceIntegrationTest.class,
		GetPriceDeliveryRateUnitTest.class,
		IdentifyIfCartEmptyUnitTest.class,
		ProceedPaymentIntegrationTest.class,
		ProceedPaymentUnitTest.class,
		GetItemFromItemListTest.class
})

public class TestSuiteTesting {
	
}
