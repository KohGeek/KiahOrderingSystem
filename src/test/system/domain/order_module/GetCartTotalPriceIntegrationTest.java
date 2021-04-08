package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;
import system.domain.login_module.Guest;
import system.domain.login_module.Member;
import system.domain.login_module.User;

@RunWith(JUnitParamsRunner.class)

public class GetCartTotalPriceIntegrationTest {
	
	/*
	 * Order Module Integration Testing
	 * Test Cases 4.1.1 ~ 4.1.4
	 * - Decision Table 
	 */
	
	Item nonPromotionalItem = new Item("TestNonPromotional" , "Test", 10, 15, false);
	Item promotionalItem = new Item("TestPromotional" , "Test", 10, 15, true);
	
	@Test 
	@Parameters (method = "getCartTotalPriceTest")
	public void getCartTotalPriceTest (User user, Item item, int qty, double cartPrice) {
		Order order = new Order(user);
		order.addItem(item, qty);
		double actualResult = order.getCartTotalPrice();
		assertEquals(cartPrice, actualResult, 0);
	}
	
	private Object [] getCartTotalPriceTest () {
		return new Object [] {
				new Object[] { new Member(), promotionalItem, 10, 95 },
				new Object[] { new Guest(), promotionalItem, 10, 142.5 },
				new Object[] { new Member(), nonPromotionalItem, 10, 100},
				new Object[] { new Guest(), nonPromotionalItem, 10, 150 }, 
		};
	}
}
