package system.domain.payment_module;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.order_module.Order;

@RunWith(JUnitParamsRunner.class)
public class GetPaymentStatusUnitTest {

	/*
	 * Payment Module Unit Test
	 * Test case 2.1.1 ~ 2.1.2
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters
	public void getPaymentStatusTest(PayStatus payStatus, String expectedResult) {
		Order order = new Order();
		ExternalPaymentSystem mock = mock(ExternalPaymentSystem.class);
		when(mock.validatePayment(anyDouble(), any(PaymentMethod.class))).thenReturn(payStatus);
		ProceedPayment PP = new ProceedPayment(mock);
		PP.makePayment(order, PaymentMethod.Undefine);
		String actualResult = PP.getPaymentStatus();
		assertEquals(expectedResult, actualResult);
	}

	private Object[] parametersForGetPaymentStatusTest() {
		return new Object[] { 
				new Object[] { PayStatus.Successful, "Paid & Ready for Delivery" },
				new Object[] { PayStatus.Unsuccessful, "Pending for Payment" } 
		};
	}

}
