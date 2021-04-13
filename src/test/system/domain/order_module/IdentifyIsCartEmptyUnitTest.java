package system.domain.order_module;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import system.domain.item_module.Item;

@RunWith(JUnitParamsRunner.class)
public class IdentifyIsCartEmptyUnitTest {
	
	/*
	 * Order Module Unit Test
	 * Test Cases 8.1.1
	 * - Equivalence Partitioning 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void cartIsEmptyUnitTest () {
		Order order = new Order();
		order.checkIsCartEmpty();
	}
	
	/*
	 * Order Module Unit Test
	 * Test Cases 8.1.2
	 * - Equivalence Partitioning
	 */
	@Test (expected = Test.None.class /* no exception expected */)
	public void cartIsNotEmptyUnitTest () {
		Order order = new Order();
		Item item = new Item(null, null, 0, 0, false); //dummy item
		order.addItem(item, 1);		
		order.checkIsCartEmpty();
	}

}
