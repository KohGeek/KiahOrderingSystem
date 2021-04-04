package system.menu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)
public class AddItemsToCartUnitTesting {
	
	Item valid_item = new Item("Test Item", "Test", 10, 15, false);
	Item invalid_item = null;
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 1.1.1, 1.1.3
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "AddItemsToCartIllegalArgumentParams")
	public void AddItemsToCartIllegalArgumentTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] AddItemsToCartIllegalArgumentParams() {
		return new Object[] {
			new Object[] { valid_item, 0 },
			new Object[] { valid_item, 101 },
		};
	}
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 1.1.2
	 * - Boundary Value Analysis
	 */
	@Test 
	@Parameters (method = "AddItemsToCartValidParams")
	public void AddItemsToCartValidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
		assertEquals(item, order.getItemFromCart(0));
	}
	
	private Object[] AddItemsToCartValidParams() {
		return new Object[] {
			new Object[] { valid_item, 1 },
			new Object[] { valid_item, 100 }
		};
	}
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 1.1.4 ~ 1.1.6
	 * - Boundary Value Analysis
	 */
	@Test (expected = NullPointerException.class)
	@Parameters (method = "AddItemsToCartNullPointerParams")
	public void AddItemsToCartNullPointerTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] AddItemsToCartNullPointerParams() {
		return new Object[] {
			new Object[] { invalid_item, 0 },
			new Object[] { invalid_item, 1 },
			new Object[] { invalid_item, 100 },
			new Object[] { invalid_item, 101 }
		};
	}
}


