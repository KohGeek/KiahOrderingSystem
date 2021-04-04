package system.payment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ProceedPaymentIntegrationTest {

	private Order order;
	private ProceedPayment PP;

	@Test
	public void updateOrderPaymentInfoTest() {
		order = new Order();
		PP = new ProceedPayment();
		PP.makePayment(order, PaymentMethod.CreditCard); 
		PayStatus actualPayStatus = order.getPaymentDetails().getPaymentStatus();
		PaymentMethod actualPaymentMethod = order.getPaymentDetails().getPaymentMethod();
		PayStatus expectedPayStatus = PayStatus.Successful;
		PaymentMethod expectedPaymentMethod = PaymentMethod.CreditCard;

		assertEquals(expectedPaymentMethod, actualPaymentMethod);
		assertEquals(expectedPayStatus, actualPayStatus);
	}
	
//	@Test
//	@Parameters
//	public void getPaymentStatusTest(PaymentMethod paymentMethod, PayStatus payStatus, String expectedResult) { //not sure if this is integrationT
//		order = new Order();
//		ExternalPaymentSystem mock = mock(ExternalPaymentSystem.class);
//		when(mock.validatePayment(any(PaymentMethod.class))).thenReturn(payStatus);
//		PP = new ProceedPayment(mock);
//		PP.makePayment(order, paymentMethod);
//		String actualResult = PP.getPaymentStatus();
//		assertEquals(expectedResult, actualResult);
//	}
//
//	private Object[] parametersForGetPaymentStatusTest() {
//		return new Object[] { 
//				new Object[] { PaymentMethod.CreditCard, PayStatus.Successful, "Paid & Ready for Delivery" },
//				new Object[] { PaymentMethod.CreditCard, PayStatus.Successful, "Paid & Ready for Delivery" },
//				new Object[] { PaymentMethod.ePayment, PayStatus.Successful, "Paid & Ready for Delivery" },
//				new Object[] { PaymentMethod.ePayment, PayStatus.Successful, "Paid & Ready for Delivery" },
//				new Object[] { PaymentMethod.CreditCard, PayStatus.Unsuccessful, "Pending for Payment" },
//				new Object[] { PaymentMethod.CreditCard, PayStatus.Unsuccessful, "Pending for Payment" },
//				new Object[] { PaymentMethod.ePayment, PayStatus.Unsuccessful, "Pending for Payment" },
//				new Object[] { PaymentMethod.ePayment, PayStatus.Unsuccessful, "Pending for Payment" } 
//		};
//	}
}
