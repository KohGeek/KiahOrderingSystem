package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;
import system.domain.order_module.Order;

@RunWith(JUnitParamsRunner.class)
public class AddItemsToCartUnitTest {
	
	Item validItem = new Item("Test Item", "Test", 10, 15, false);
	Item invalidItem = null;
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.1, 1.1.3
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "addItemEmptyCartIllegalArgumentParams")
	public void addItemEmptyCartIllegalArgumentTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] addItemEmptyCartIllegalArgumentParams() {
		return new Object[] {
			new Object[] { validItem, 0 },
			new Object[] { validItem, 101 },
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.2
	 * - Boundary Value Analysis
	 */
	@Test 
	@Parameters (method = "addItemEmptyCartValidParams")
	public void addItemEmptyCartValidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
		LinkedHashMap<Item,Integer> expectedResult = new LinkedHashMap<>();
		expectedResult.put(item, quantity);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] addItemEmptyCartValidParams() {
		return new Object[] {
			new Object[] { validItem, 1  },
			new Object[] { validItem, 100 }
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.4 ~ 1.1.6
	 * - Boundary Value Analysis
	 */
	@Test (expected = NullPointerException.class)
	@Parameters (method = "addItemEmptyCartNullPointerParams")
	public void addItemEmptyCartNullPointerTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] addItemEmptyCartNullPointerParams() {
		return new Object[] {
			new Object[] { invalidItem, 0 },
			new Object[] { invalidItem, 1 },
			new Object[] { invalidItem, 100 },
			new Object[] { invalidItem, 101 }
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.2.1
	 * - Decision Table
	 */
	@Test 
	@Parameters (method = "addDuplicateItemValidParams")
	public void addDuplicateItemValidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, 1);
		order.addItem(item, quantity);
		LinkedHashMap<Item,Integer> expectedResult = new LinkedHashMap<>();
		expectedResult.put(item, 1 + quantity);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] addDuplicateItemValidParams() {
		return new Object[] {
			new Object[] { validItem, 50 }
		};
	}
	
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.2.2
	 * - Decision Table
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "addDuplicateItemInvalidParams")
	public void addDuplicateItemInvalidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, 99);
		order.addItem(item, quantity);
	}
	
	private Object[] addDuplicateItemInvalidParams() {
		return new Object[] {
			new Object[] { validItem, 50 }
		};
	}
	
	
	
}


