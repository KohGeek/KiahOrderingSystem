package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;
import system.domain.order_module.Order;

@RunWith(JUnitParamsRunner.class)
public class EditItemsInCartUnitTest {
	
	Item dummyItem = new Item("Dummy Item", "Test", 20, 25, true);
	Item validItem = new Item("Test Item", "Test", 10, 15, false);
	Item invalidItem = null;
	LinkedHashMap<Item,Integer> expectedResult = new LinkedHashMap<>();
	Order order;
	
//	@Before
//	public void initialiseParams() {
//		expectedResult = new LinkedHashMap<>(); 
//		expectedResult.put(dummyItem, 42);
//		order = new Order();
//		order.addItem(dummyItem, 42);
//		order.addItem(validItem, 69);
//	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 2.1.1, 2.1.4
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "editItemsInCartInvalidQuantity")
	public void editItemsInCartInvalidQuantityTests(Item item, int quantity) {
		expectedResult.put(dummyItem, 42);
		expectedResult.put(item, 69);
		
		order = new Order(expectedResult);
		
		order.editItem(item, quantity);
	}
	
	private Object[] editItemsInCartInvalidQuantity() {
		return new Object[] {
			new Object[] { validItem, -1 },
			new Object[] { validItem, 101 }
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 2.1.2
	 * - Boundary Value Analysis
	 */
	@Test
	@Parameters (method = "editItemsInCartEmptyQuantity")
	public void editItemInCartEmptyQuantityTest(Item item, int quantity) {
		expectedResult.put(dummyItem, 42);
		expectedResult.put(item, 69);
		
		order = new Order(expectedResult);
		
		order.editItem(item, quantity);
		expectedResult.remove(item);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] editItemsInCartEmptyQuantity() {
		return new Object[] {
				new Object[] {validItem, 0}
		};
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 2.1.3
	 * - Boundary Value Analysis
	 */
	@Test
	@Parameters (method = "editItemsInCartValidQuantity")
	public void editItemInCartValidQuantityTest(Item item, int quantity) {
		expectedResult.put(dummyItem, 42);
		expectedResult.put(item, 69);
		
		order = new Order(expectedResult);
		
		order.editItem(item, quantity);
		expectedResult.put(item, quantity);
		assertEquals(expectedResult, order.getCart().getCart());
	}
	
	private Object[] editItemsInCartValidQuantity() {
		return new Object[] {
				new Object[] {validItem, 10}
		};
	}
	
	
	/*
	 * Order Module Unit Test
	 * Test Cases 2.1.5 ~ 2.1.8
	 * - Boundary Value Analysis
	 */
	@Test (expected = NullPointerException.class)
	@Parameters (method = "editItemsInCartInvalidItem")
	public void editItemsInCartInvalidItemTests(Item item, int quantity) {
		expectedResult.put(dummyItem, 42);
		expectedResult.put(item, 69);
		
		order = new Order(expectedResult);
		
		order.editItem(item, quantity);
	}
	
	private Object[] editItemsInCartInvalidItem() {
		return new Object[] {
				new Object[] {invalidItem, 10},
				new Object[] {invalidItem, 0},
				new Object[] {invalidItem, -1},
				new Object[] {invalidItem, 101}
		};
	}
	
}
