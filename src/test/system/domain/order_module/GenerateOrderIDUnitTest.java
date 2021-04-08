package system.domain.order_module;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerateOrderIDUnitTest {

	@Test
	public void test() {
		Order order = new Order ("orderModuleOrderIDData.txt");
		int actualResult = order.getID();
		int expectedResult = 1002;
		assertEquals(expectedResult, actualResult);
	}
}
