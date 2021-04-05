package system.menu;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.Member;
import system.login.User;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)
public class GetCartData {
	
	Item cartItem = new Item("TestCartItem" , "Test" , 10, 15, true);

	@Test
	@Parameters (method = "GetCartData")
	public void getCartDataUnitTesting (Item item, int qty) {
		Member member = new Member("user0000");
		Order order = new Order(member);
		ArrayList<Object> cartList = new ArrayList<>();
		order.addItem(item, qty);
		cartList.add(1);
		cartList.add(item.getName());
		cartList.add(item.getMemberPrice());
		cartList.add(qty);
		cartList.add("Yes");
		ArrayList<Object> actualResult = order.getCartData().get(0);
		assertEquals(cartList, actualResult);
	}
	
	private Object [] GetCartData () {
		return new Object [] {
				new Object [] { cartItem, 1 },
		};
	}
}
