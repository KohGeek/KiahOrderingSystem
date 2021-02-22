package application;

import java.util.Map.Entry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Order implements Serializable {

	// default serialVersion id
	private static final long serialVersionUID = 1L;

	private int id;
	private User user;
	private String deliveryAddress;
	private HashMap<Item, Integer> purchaseList; // assume mySQL driver? stub?
	private double deliveryFee;
	private double totalPrice;
	private boolean isMember;
	private final double minOrderValue = 25;

	public Order(int id, User user, String deliveryAddress, HashMap<Item, Integer> purchaseList, boolean isMember) {
		this.id = id;
		this.user = user;
		this.deliveryAddress = deliveryAddress; // use method
		this.purchaseList = purchaseList;
		this.isMember = isMember;
		this.totalPrice = calculateTotalPrice(this.isMember);
	}

	public Order(User user, String deliveryAddress, HashMap<Item, Integer> purchaseList, boolean isMember) {
		this.id = generateID();
		this.user = user;
		this.deliveryAddress = deliveryAddress; // use method
		this.purchaseList = purchaseList;
		this.isMember = isMember;
		this.totalPrice = calculateTotalPrice(this.isMember);
	}

	// Rickie
	private int generateID(ArrayList<Order> orderList) {
		
	}

	public User getUser() { // return User, not String, remark to change in EA
		return this.user;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public HashMap<Item, Integer> getPurchaseList() {
		return this.purchaseList;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String newAddress) {
		this.deliveryAddress = newAddress;
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
}
