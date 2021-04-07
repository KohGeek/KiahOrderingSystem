package system.menu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)
public class editItemsInCartUnitTesting {
	
	Item valid_item = new Item("Test Item", "Test", 10, 15, false);
	Item invalid_item = null;
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 2.1.1, 2.1.4
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "EditItemsInCartInvalidQuantity")
	public void EditItemsInCartInvalidQuantityTests(Item item, int quantity) {
		Order order = new Order();
		order.editItem(item, quantity);
	}
	
	private Object[] EditItemsInCartInvalidQuantity() {
		return new Object[] {
			new Object[] { valid_item, -1 },
			new Object[] { valid_item, 101 }
		};
	}
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 2.1.2, 2.1.3
	 * - Boundary Value Analysis
	 */
	@Test
	@Parameters (method = "EditItemsInCartValidQuantity")
	public void EditItemInCartValidQuantityTest(Item item, int quantity) {
		Order order = new Order();
		order.editItem(item, quantity);
	}
	
	private Object[] EditItemsInCartValidQuantity() {
		return new Object[] {
				new Object[] {valid_item, 10},
				new Object[] {valid_item, 0}
		};
	}
	
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 2.1.5 ~ 2.1.8
	 * - Boundary Value Analysis
	 */
	@Test (expected = NullPointerException.class)
	@Parameters (method = "EditItemsInCartInvalidItem")
	public void EditItemsInCartInvalidItemTests(Item item, int quantity) {
		Order order = new Order();
		order.editItem(item, quantity);
	}
	
	private Object[] EditItemsInCartInvalidItem() {
		return new Object[] {
				new Object[] {invalid_item, 10},
				new Object[] {invalid_item, 0},
				new Object[] {invalid_item, -1},
				new Object[] {invalid_item, 101}
		};
	}
	
}
