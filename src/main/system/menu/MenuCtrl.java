package system.menu;

import java.util.ArrayList;
import java.util.List;

import system.login.User;
import system.menu.checkout.Order;

public class MenuCtrl {

	private Order order;
	private IItem itemList;
	private IDelivery deliveryInfo;

	public MenuCtrl(Order order, IItem itemList, IDelivery deliveryInfo) {
		this.order = order;
		this.itemList = itemList;
		this.deliveryInfo = deliveryInfo;
	}

	public User getUser() {
		return this.order.getUser();
	}

	public Order getOrder() {
		return this.order;
	}

	public Item getItemFromList(int itemNo) {
		return this.itemList.getItemFromList(itemNo);
	}

	public void addItem(Item item, int qty) {
		this.order.getCart().addItem(item, qty);
	}

	public double getCartTotalPrice(User user) {
		return this.order.getCart().getCartTotalPrice(user);
	}

	public Item getCartItem(int itemNo) {
		return this.order.getCart().getCartItem(itemNo);
	}

	public void editItem(Item item, int qty) {
		this.order.getCart().editItem(item, qty);
	}

	public void setDeliveryFee(String area) {
		double fee = this.deliveryInfo.getRate(area);
		this.order.setDeliveryFee(fee);
	}

	public void checkIsCartEmpty() throws IllegalAccessException {
		this.order.getCart().checkIsCartEmpty();
	}

	public String getName(User user) {
		return user.getName();
	}

	public String getAddress(User user) {
		return user.getAddress().getFullAddress();
	}

	public double getDeliveryFee(Order order) {
		return order.getDeliveryFee();
	}

	public double getTotalPrice(Order order) {
		return order.getTotalPrice();
	}

	public List<ArrayList<Object>> getCartData(User user) {
		return this.order.getCart().getCartData(user);
	}

	public List<ArrayList<Object>> getItemData() {
		return this.itemList.getItemDataList();
	}
}
