package system.payment;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ProceedPaymentUnitTest {

	private Order order;
	private ProceedPayment PP;

	@Test
	@Parameters
	public void makePaymentTestValid(PaymentMethod paymentMethod, PaymentMethod expectedResult) {
		order = new Order();
		ExternalPaymentSystem mock = mock(ExternalPaymentSystem.class);
		PP = new ProceedPayment(mock);
		PP.makePayment(order, paymentMethod);
		verify(mock).validatePayment(expectedResult);
	}

	private Object[] parametersForMakePaymentTestValid() {
		return new Object[] {
				new Object[] { PaymentMethod.CreditCard, PaymentMethod.CreditCard},
				new Object[] { PaymentMethod.ePayment, PaymentMethod.ePayment }
		};
	}
	
	@Test (expected = NullPointerException.class)
	@Parameters
	public void makePaymentTestInvalid(PaymentMethod paymentMethod) {
		order = new Order();
		ExternalPaymentSystem mock = mock(ExternalPaymentSystem.class);
		PP = new ProceedPayment(mock);
		PP.makePayment(order, paymentMethod);
	}

	private Object[] parametersForMakePaymentTestInvalid() {
		return new Object[] {
				new Object[] { null }
		};
	}
	
	@Test
	@Parameters
	public void getPaymentStatusTest(PayStatus payStatus, String expectedResult) {
		order = new Order();
		ExternalPaymentSystem mock = mock(ExternalPaymentSystem.class);
		when(mock.validatePayment(any(PaymentMethod.class))).thenReturn(payStatus);
		PP = new ProceedPayment(mock);
		PP.makePayment(order, PaymentMethod.CreditCard); // any paymentMethod doesn't affect
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
