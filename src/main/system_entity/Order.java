package system_entity;

import system_entity.Address;
import system_interface.InitialOrder;

public class Order implements InitialOrder {

	private int orderID;
	private User user;
	private Address deliveryAddress;
	private PurchaseList purchaseList;
	private aDelivery deliveryFee;
	private Payment paymentDetails;
	private double totalPrice;
	private static double minOrderValue = 25;

	@Override
	public int generateOrderID() {

	}

	@Override
	public Address verifyDeliveryAddress() {

	}

	@Override
	public void computeTotalPrice() {

	}

	public Order(User user, PurchaseList purchaseList) {

	}

	public void setDeliveryFee() {

	}

	@Override
	public void setPaymentDetails() {

	}

	@Override
	public void setDeliveryAddress() {

	}

	@Override
	public double getDeliveryFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getOrderID() {

	}

	public User getUser() {

	}

	public Address getDeliveryAddress() {

	}

	public aDelivery getDeliveryFee() { // remark, might the aDelivery is DeliveryCost or deliveryFee

	}

	public aPayment getPaymentDetails() { // remark, might the aPayment is Payment

	}

	public double getTotalPrice() {

	}
}
