package system.menu.checkout;

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
	private double extraCharge = 3;

	public Order(User user, ICart cart) {
		this.user = user;
		this.cart = cart;
		this.paymentDetails = new Payment();
		this.totalPrice = 0;
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

	private void computeTotalPrice() {
		/*
		 * Total Price = Cart Total Price + Delivery Fee
		 * + Additional Charges RM5 (if didn't reach the minOrderValue)
		 */
		double totalPrice = 0;
		totalPrice += this.cart.getCartTotalPrice(this.user);
		while (totalPrice < this.minOrderValue) {
			totalPrice += this.extraCharge; // Additional Charges of RM3
		}
		totalPrice += deliveryCost;
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		computeTotalPrice();
		return totalPrice;
	}

	public Payment getPaymentDetails() {
		return this.paymentDetails;
	}

	public int getOrderID() {
		return orderID;
	}
}
