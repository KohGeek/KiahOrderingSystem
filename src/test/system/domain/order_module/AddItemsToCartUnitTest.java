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
	
	Item valid_item = new Item("Test Item", "Test", 10, 15, false);
	Item invalid_item = null;
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.1, 1.1.3
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "AddItemEmptyCartIllegalArgumentParams")
	public void AddItemEmptyCartIllegalArgumentTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] AddItemEmptyCartIllegalArgumentParams() {
		return new Object[] {
			new Object[] { valid_item, 0 },
			new Object[] { valid_item, 101 },
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.2
	 * - Boundary Value Analysis
	 */
	@Test 
	@Parameters (method = "AddItemEmptyCartValidParams")
	public void AddItemEmptyCartValidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
		LinkedHashMap<Item,Integer> expectedResult = new LinkedHashMap<>();
		expectedResult.put(item, quantity);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] AddItemEmptyCartValidParams() {
		return new Object[] {
			new Object[] { valid_item, 1  },
			new Object[] { valid_item, 100 }
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.1.4 ~ 1.1.6
	 * - Boundary Value Analysis
	 */
	@Test (expected = NullPointerException.class)
	@Parameters (method = "AddItemEmptyCartNullPointerParams")
	public void AddItemEmptyCartNullPointerTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, quantity);
	}
	
	private Object[] AddItemEmptyCartNullPointerParams() {
		return new Object[] {
			new Object[] { invalid_item, 0 },
			new Object[] { invalid_item, 1 },
			new Object[] { invalid_item, 100 },
			new Object[] { invalid_item, 101 }
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.2.1
	 * - Decision Table
	 */
	@Test 
	@Parameters (method = "AddDuplicateItemValidParams")
	public void AddDuplicateItemValidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, 1);
		order.addItem(item, quantity);
		LinkedHashMap<Item,Integer> expectedResult = new LinkedHashMap<>();
		expectedResult.put(item, 1 + quantity);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] AddDuplicateItemValidParams() {
		return new Object[] {
			new Object[] { valid_item, 50 }
		};
	}
	
	
	/*
	 * Order Module Unit Test
	 * Test Cases 1.2.2
	 * - Decision Table
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "AddDuplicateItemInvalidParams")
	public void AddDuplicateItemInvalidTests(Item item, int quantity) {
		Order order = new Order();
		order.addItem(item, 99);
		order.addItem(item, quantity);
	}
	
	private Object[] AddDuplicateItemInvalidParams() {
		return new Object[] {
			new Object[] { valid_item, 50 }
		};
	}
	
	
	
}


