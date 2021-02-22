package application;

import java.util.Map.Entry;
import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable {

	// default serialVersion id
	private static final long serialVersionUID = 1L;

	private String deliveryAddress;
	private Delivery deliveryDetails;
	private int id;
	private final double minOrderValue = 25;
	private HashMap<Item, Integer> purchaseList; // assume mySQL driver? stub?
	private double totalPrice;
	private User user;
	private boolean isMember;

	public Order(int id, User user, String deliveryAddress, HashMap<Item, Integer> purchaseList, Delivery deliveryDetails,
			boolean isMember) {
		this.user = user;
		this.deliveryAddress = deliveryAddress; // use method
		this.purchaseList = purchaseList;
		this.deliveryDetails = deliveryDetails;
		this.isMember = isMember;
		this.totalPrice = calculateTotalPrice(this.isMember);
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String newAddress) {
		this.deliveryAddress = newAddress;
	}

	public HashMap<Item, Integer> getPurchase() {
		return this.purchaseList;
	}

	public double calculateTotalPrice(boolean isMember) { // need more info
		double totalPrice = 0;
		for (Entry<Item, Integer> entry : this.purchaseList.entrySet()) {
			if (isMember == true) {
				if (entry.getKey().getIsPromotional() == true)
					totalPrice += entry.getKey().getMemberPrice() * entry.getValue() * entry.getKey().getDiscountRate();
				else
					totalPrice += entry.getKey().getMemberPrice() * entry.getValue();
			} else if (entry.getKey().getIsPromotional() == true)
				totalPrice += entry.getKey().getNonMemberPrice() * entry.getValue() * entry.getKey().getDiscountRate();
			else
				totalPrice += entry.getKey().getNonMemberPrice() * entry.getValue();
		}

		return totalPrice;
	}

	public User getUser() { // return User, not String, remark to change in EA
		return this.user;
	}
}
