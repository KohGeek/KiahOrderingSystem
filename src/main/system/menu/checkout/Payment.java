package system.menu.checkout;

public class Payment {

	private double totalPrice;
	private PayStatus paymentStatus;
	private PaymentMethod paymentMethod;

	public Payment() {
		this.totalPrice = 0;
		this.paymentStatus = PayStatus.Unsuccessful;
	}

	public double getPaymentTotalPrice() {
		return this.totalPrice;
	}
	
	public void updatePayMentInfo(PayStatus paymentStatus, PaymentMethod paymentMethod) {
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}
}
