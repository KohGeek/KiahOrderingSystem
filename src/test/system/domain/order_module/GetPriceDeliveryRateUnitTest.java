package system.domain.order_module;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.login_module.Address;
import system.domain.login_module.Member;

@RunWith(JUnitParamsRunner.class)

public class GetPriceDeliveryRateUnitTest {

	IDelivery dcl = new DeliveryCostList("deliveryCostData.txt");

	/*
	 * Order Module Unit Test 
	 * Test Cases 7.1.1 
	 * - Analysis
	 */
	@Test
	@Parameters(method = "getPriceDeliveryRateParams")
	public void getPriceDeliveryRateUnitTesting(String area, double expectedResult) {
		Member member = new Member();
		Address addr = mock(Address.class);
		member.setAddress(addr);
		when(addr.getArea()).thenReturn(area);

		Order order = new Order(member, dcl);

		double actualResult = order.getDeliveryFee();
		assertEquals(expectedResult, actualResult, 0.001);
	}

	private Object[] getPriceDeliveryRateParams() {
		return new Object[] { 
			new Object[] { "Alor Gajah", 2.50 },
			new Object[] { "Jasin", 4.00 },
			new Object[] { "Tanjong Kling", 4.50 }
		};
	}
}
