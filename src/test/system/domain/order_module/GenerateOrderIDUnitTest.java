package system.domain.order_module;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerateOrderIDUnitTest {

	/*
	 * Order Module Unit Test 
	 * Test Cases 9.1.1 
	 * - Analysis
	 */
	@Test
	public void test() {
		Order order = new Order ("orderModuleOrderIDData.txt");
		int actualResult = order.getID();
		int expectedResult = 1002;
		assertEquals(expectedResult, actualResult);
	}
}
