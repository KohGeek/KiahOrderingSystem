package system.payment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ProceedPaymentIntegrationTest {

	private Order order;
	private ProceedPayment PP;

	
	/*
	 * Payment Module Integration Test
	 * Test case 3.1.1
	 */
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
	
}
