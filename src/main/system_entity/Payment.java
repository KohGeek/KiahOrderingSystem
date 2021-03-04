package system_entity;

import system_entity.PayMethod;
import system_interface.aPayment;
import system_entity.PayStatus;

public class Payment implements aPayment {
	private double totalPrice;
	private PayMethod paymentMethod;
	private PayStatus paymentStatus;

	public void makePayment(Order order, int payOption) {
		Order $order = order;
		int $payOption = payOption;

		if (payOption == 1) {

			this.paymentMethod = PayMethod.CreditCard;
		} else if (payOption == 2) {

			this.paymentMethod = PayMethod.OnlineBanking;
		}

		this.totalPrice = $order.getTotalPrice();
		this.paymentStatus = PayStatus.Successful;
	}

	public Payment() {

	}

}
