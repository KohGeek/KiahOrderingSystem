package system.domain.order_module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { 
		AddItemToCartUnitTest.class, 
		EditItemInCartUnitTest.class, 
		GenerateOrderIDUnitTest.class,
		GetCartDataUnitTest.class,
		GetCartTotalPriceIntegrationTest.class,
		GetItemFromCartUnitTest.class,
		GetOrderTotalPriceIntegrationTest.class,
		GetPriceDeliveryRateUnitTest.class, 
		IdentifyIsCartEmptyUnitTest.class 
})

public class OrderModuleTestSuite {

}
