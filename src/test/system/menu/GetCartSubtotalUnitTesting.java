package system.menu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.Guest;
import system.login.Member;
import system.login.User;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)

public class GetCartSubtotalUnitTesting {
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 4.1.1 ~ 4.1.4
	 * - Boundary Value Analysis
	 */
	
	Item nonPromotionalItem = new Item("TestNonPromotional" , "Test", 10, 15, false);
	Item promotionalItem = new Item("TestPromotional" , "Test2", 10, 15, true);
	Item invalid_item = null;
	
	@Test 
	@Parameters (method = "GetCartSubtotal")
	public void getCartSubtotalUnitTest (User user, Item item, int qty, double cartPrice) {
		Order order = new Order(user);
		order.addItem(item, qty);
		double actualResult = order.getCartTotalPrice();
		assertEquals(cartPrice, actualResult,0.001);
	}
	
	private Object [] getCartSubtotal () {
		return new Object [] {
				new Object[] { new Member("user0000"), promotionalItem, 10, 10*10*0.95 },
				new Object[] { new Guest("Susin"), promotionalItem, 10, 10*15*0.95 },
				new Object[] { new Member("user0000"), nonPromotionalItem, 10, 10*10 },
				new Object[] { new Guest("Susin"), nonPromotionalItem, 10, 10*15 }, 
		};
	}
}
