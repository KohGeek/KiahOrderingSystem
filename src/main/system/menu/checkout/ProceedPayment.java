package system.menu.checkout;

class ExternalPaymentSystem {
	public PayStatus validatePayment(PaymentMethod paymentMethod) {
		/*
		 * connected to an external payment system to proceed the payment
		 * and return a validate status (accept-True, decline-False)
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

	public String makePayment(Order order, PaymentMethod paymentMethod) {
		String msg = "";
		this.validateStatus = this.EPS.validatePayment(paymentMethod);
		order.getPaymentDetails().updatePayMentInfo(this.validateStatus, paymentMethod);
		if (this.validateStatus == PayStatus.Successful) {
			msg = "Paid & Ready for Delivery";
		} else if (this.validateStatus == PayStatus.Unsuccessful) {
			msg = "Pending for Payment";
		}
		return msg;
	}
}
