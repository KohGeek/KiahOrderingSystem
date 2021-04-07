package system.domain.payment_module;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import system.domain.item_module.*;
import system.domain.login_module.*;
import system.domain.order_module.AddItemsToCartUnitTesting;
import system.domain.order_module.EditItemsInCartUnitTesting;
import system.domain.order_module.GetCartData;
import system.domain.order_module.GetCartSubtotalUnitTesting;
import system.domain.order_module.GetCartTotalPriceUnitTesting;
import system.domain.order_module.GetPriceDeliveryRateUnitTesting;
import system.domain.order_module.IdentifyCartOrderUnitTesting;
import system.domain.order_module.OrderUnitTesting;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
		AddressInfoUnitTesting.class,
		MemberLoginTest.class,
		SignUpUnitTesting.class,
		AddItemsToCartUnitTesting.class,
		EditItemsInCartUnitTesting.class,
		GetCartData.class,
		GetCartSubtotalUnitTesting.class,
		GetCartTotalPriceUnitTesting.class,
		GetPriceDeliveryRateUnitTesting.class,
		IdentifyCartOrderUnitTesting.class,
		OrderUnitTesting.class,
		ProceedPaymentIntegrationTest.class,
		ProceedPaymentUnitTest.class
})

public class TestSuiteTesting {
}
