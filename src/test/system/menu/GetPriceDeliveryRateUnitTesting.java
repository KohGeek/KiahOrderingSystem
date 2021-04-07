package system.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.Address;
import system.login.Member;
import system.payment.DeliveryCostList;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)

public class GetPriceDeliveryRateUnitTesting {
		IDelivery dcl = new DeliveryCostList("deliveryCostData.txt");
		
		
		/*
		 * Order Module Unit Testing
		 * Test Cases 6.1.1
		 * - Boundary Value Analysis
		 */
		@Test
		@Parameters (method = "getPriceDeliveryRate")
		public void getPriceDeliveryRateUnitTesting (String area, double deliveryCost) {
			Member member = new Member ("user0000");
			Address addr = mock(Address.class);
			member.setAddress(addr);
			when(addr.getArea()).thenReturn(area);
			Order order = new Order(member, dcl);
			double actualResult = order.getDeliveryFee();
			assertEquals(deliveryCost,actualResult,0.001);
		}
		
		private Object[] getPriceDeliveryRate () {
			return new Object[] {
				new Object[] { "Alor Gajah", 2.50 }
		};
	}
}
