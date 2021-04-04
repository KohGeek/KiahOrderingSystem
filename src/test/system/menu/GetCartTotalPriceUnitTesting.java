package system.menu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.User;
import system.payment.Order;
import system.login.Guest;
import system.login.Member;

@RunWith(JUnitParamsRunner.class)
public class GetCartTotalPriceUnitTesting {
	
	Item nonPromotionalItem = new Item("TestNonPromotional" , "Test", 10, 15, false);
	Item promotionalItem = new Item("TestPromotional" , "Test2", 10, 15, true);
	Item invalid_item = null;
	
	@Test
	@Parameters (method = "GetCartTotalPrice")
	public void GetCartTotalPriceUnitTest (Item item, int qty, double totalPrice) {
		Member member = new Member("user0000");
		Order order = new Order(member);
		order.addItem(item, qty);
		double actualResult = order.getTotalPrice();
		assertEquals(totalPrice, actualResult,0.001);
	}
	
	private Object [] GetCartTotalPrice () {
		return new Object [] {
				new Object[] { nonPromotionalItem, 1, (1*10)+3 },
				new Object[] { nonPromotionalItem, 10, 10*10 },
			
		};
	}
}
