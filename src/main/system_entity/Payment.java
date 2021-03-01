package system_entity;

import system_entity.Paymethod;
import system_entity.PayStatus;

public class Payment implements aPayment {
	private double totalPrice;
	private PayMethod paymentMethod;
	private PayStatus paymentStatus;

	public makePayment(double totalPrice) {
		
		
	}

	public Payment() {

	}

	public getPaymentStatus() {
		
		return paymentStatus; 
		
	}

	public getPaymentMethod() {
		
		return paymentMethod;
		
	}
}
