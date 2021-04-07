package system.domain.payment_module;

import system.domain.order_module.Order;

class ExternalPaymentSystem {

	private double amount;
	private PaymentMethod paymentMethod;

	public PayStatus validatePayment(double amount, PaymentMethod paymentMethod) {
		/*
		 * connected to an external payment system to proceed the payment
		 * and return a validate status
		 * 
		 * this is SUT, not ready to be executed
		 */

		this.amount = amount;
		this.paymentMethod = paymentMethod;
		return PayStatus.Successful;
	}
}

public class ProceedPayment {

	private ExternalPaymentSystem EPS;
	private PayStatus payStatus;
	private PaymentMethod paymentMethod;
	private double totalPrice;

	public ProceedPayment(ExternalPaymentSystem EPS) {
		this.EPS = EPS;
	}

	public ProceedPayment() {
		this.EPS = new ExternalPaymentSystem();
	}

	public void makePayment(Order order, PaymentMethod paymentMethod) {

		if (paymentMethod == null) {
			throw new NullPointerException("PaymentMethod cannot be null!");
		}

		this.paymentMethod = paymentMethod;
		this.totalPrice = order.getTotalPrice();

		this.payStatus = this.EPS.validatePayment(this.totalPrice, paymentMethod);
		order.updatePaymentMethod(paymentMethod);
		order.updatePayStatus(this.payStatus);
	}

	public String getPaymentStatus() {
		String msg = "";
		if (this.payStatus == PayStatus.Successful) {
			msg = "Paid & Ready for Delivery";
		} else if (this.payStatus == PayStatus.Unsuccessful) {
			msg = "Pending for Payment";
		}

		return msg;
	}
}
