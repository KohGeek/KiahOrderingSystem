package system.menu.checkout;

public class Payment implements IPayment {

	private double totalPrice;
	private PayStatus paymentStatus;

	public Payment() {
		this.totalPrice = 0;
		this.paymentStatus = PayStatus.Unsuccessful;
	}

	public String getPaymentStatus() { // remark to try returning the enum instead
		String msg = "";
		if (this.paymentStatus == PayStatus.Successful)
			msg = "Payment is successful!";
		else if (this.paymentStatus == PayStatus.Unsuccessful)
			msg = "Payment is not done yet!";
		return msg;
	}

	public double getPaymentTotalPrice() {
		return this.totalPrice;
	}

	@Override
	public void makePayment(Order order) {
		this.totalPrice = order.getTotalPrice();
		this.paymentStatus = PayStatus.Successful;

//		if (payOption == 1) {
//
//			this.paymentMethod = PayMethod.CreditCard;
//		} else if (payOption == 2) {
//
//			this.paymentMethod = PayMethod.OnlineBanking;
//		}
	}
}
