package system.menu.checkout;

import system.login.Guest;
import system.login.Member;
import system.login.User;
import system.menu.ICart;

public class Order {

	private int orderID;
	private User user;
	private ICart cart;
	private double deliveryCost;
	private Payment paymentDetails;
	private double totalPrice;
	private double minOrderValue = 25;

	public Order(User user, ICart cart) {
		this.user = user;
		this.cart = cart;
		this.paymentDetails = new Payment();
		this.totalPrice = computeTotalPrice();
	}

	public int generateOrderID() {
		// not complete
		return 0;
	}

	public User getUser() {
		return this.user;
	}

	public ICart getCart() {
		return this.cart;
	}

	public void setDeliveryFee(double fee) {
		this.deliveryCost = fee;
	}

	public double getDeliveryFee() {
		return this.deliveryCost;
	}

	private double computeTotalPrice() {
		/*
		 * Total Price = Cart Total Price + Delivery Fee
		 * + Additional Charges RM5 (if didn't reach the minOrderValue)
		 */
		double totalPrice = 0;
		if (this.user instanceof Member)
			totalPrice += this.cart.getCartTotalPrice(true);
		else if (this.user instanceof Guest)
			totalPrice += this.cart.getCartTotalPrice(false);
		while (totalPrice < this.minOrderValue)
			totalPrice += 5; // Additional Charges
		totalPrice += deliveryCost;
		return totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Payment getPaymentDetails() {
		return this.paymentDetails;
	}

	public int getOrderID() {
		return orderID;
	}
}
