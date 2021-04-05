package system.menu;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.Member;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)
public class IdentifyCartOrderUnitTesting {
		
	Item OrderItemTest = new Item("TestOrderEmpty" , "Test", 10, 15, true);
	Item invalid_item = null;
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "IdentifyCart") 
	public void IdentifyCartOrderUnitTest (Item item, int qty) {
		Order order = new Order();
		order.addItem(item, qty);
	}
	
	private Object[] IdentifyCart () {
		return new Object[] {
				new Object[] { "", 1},
		};
	}

}
