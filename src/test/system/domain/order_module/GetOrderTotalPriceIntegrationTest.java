package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;
import system.domain.login_module.Guest;
import system.domain.login_module.Member;
import system.domain.login_module.User;
import system.domain.order_module.Order;

@RunWith(JUnitParamsRunner.class)
public class GetOrderTotalPriceIntegrationTest {
	
	Item below25 = new Item("TestItem" , "Test", 10, 10, false);
	Item above25 = new Item("TestItem" , "Test2", 30, 30, false);
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 5.1.1 ~ 5.1.2
	 * - Boundary Value Analysis
	 */
	
	@Test
	@Parameters (method = "getOrderTotalPriceTest")
	public void getOrderTotalPriceTest (User user, Item item, int qty, double totalPrice) {
		Order order = new Order(user);
		order.addItem(item, qty);
		double actualResult = order.getTotalPrice();
		assertEquals(totalPrice, actualResult, 0);
	}
	
	private Object [] getOrderTotalPriceTest () {
		return new Object [] {
				new Object[] { new Member(), below25, 1, 13},
				new Object[] { new Member(), above25, 1, 30},
				new Object[] { new Guest(), below25, 1, 13},
				new Object[] { new Guest(), above25, 1, 30},
		};
	}
}
