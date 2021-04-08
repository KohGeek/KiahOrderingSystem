package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;
import system.domain.login_module.Guest;
import system.domain.login_module.Member;
import system.domain.login_module.User;

@RunWith(JUnitParamsRunner.class)
public class GetCartDataUnitTest {
	
	Item promotionalItem = new Item("Promotional Item" , "Test1" , 10, 15, true);
	Item nonPromotionalItem = new Item("Non-Promotional Item" , "Test2" , 20, 25, false);

	/*
	 * Order Module Unit Test
	 * Test Cases 3.1.1
	 * 
	 */
	@Test
	@Parameters (method = "getCartDataParams")
	public void getCartDataUnitTesting (User user, Item item, int qty, double price) {
		Order order = new Order(user);
		order.addItem(item, qty);
		
		ArrayList<Object> expectedResult = new ArrayList<>();
		expectedResult.add(1); // item order in cart
		expectedResult.add(item.getName());
		expectedResult.add(price);
		expectedResult.add(qty);
		expectedResult.add(item.getIsPromotional() ? "Yes" : "No");
		ArrayList<Object> actualResult = order.getCartData().get(0);
		assertEquals(expectedResult, actualResult);
	}
	
	private Object [] getCartDataParams () {
		return new Object [] {
			new Object [] { new Member(), promotionalItem, 1 , promotionalItem.getMemberPrice() },
			new Object [] { new Member(), nonPromotionalItem, 5 , nonPromotionalItem.getMemberPrice() },
			new Object [] { new Guest(), promotionalItem, 10 , promotionalItem.getNonMemberPrice() },
			new Object [] { new Guest(), nonPromotionalItem, 15 , nonPromotionalItem.getNonMemberPrice() },
		};
	}
}
