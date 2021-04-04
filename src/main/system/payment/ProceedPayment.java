package system.payment;

class ExternalPaymentSystem {
	public PayStatus validatePayment(PaymentMethod paymentMethod) {
		/*
		 * connected to an external payment system to proceed the payment
		 * and return a validate status
		 * 
		 * this is SUT, not ready to be executed
		 */
		return PayStatus.Successful;
	}
}

public class ProceedPayment {

	private ExternalPaymentSystem EPS;
	private PayStatus validateStatus;

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

		this.validateStatus = this.EPS.validatePayment(paymentMethod);
		order.updatePaymentMethod(paymentMethod);
		order.updatePayStatus(this.validateStatus);
	}

	public String getPaymentStatus() {
		String msg = "";
		if (this.validateStatus == PayStatus.Successful) {
			msg = "Paid & Ready for Delivery";
		} else if (this.validateStatus == PayStatus.Unsuccessful) {
			msg = "Pending for Payment";
		}

		return msg;
	}
}
