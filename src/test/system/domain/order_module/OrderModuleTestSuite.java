package system.domain.order_module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { AddItemsToCartUnitTest.class, EditItemsInCartUnitTest.class, GetCartDataUnitTest.class,
		GetCartTotalPriceIntegrationTest.class, GetOrderTotalPriceIntegrationTest.class,
		GetPriceDeliveryRateUnitTest.class, IdentifyIfCartEmptyUnitTest.class, })

public class OrderModuleTestSuite {

}