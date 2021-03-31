package system.menu;

import java.util.LinkedHashMap;
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

	public List<Item> getItemList() {
		return this.itemList.getItemList();
	}

	public int getItemListSize() {
		return this.itemList.getItemListSize();
	}

	public Item getItem(int itemNo) {
		return this.itemList.getItem(itemNo);
	}

	public void addItem(Item item, int qty) {
		this.order.getCart().addItem(item, qty);
	}

	public LinkedHashMap<Item, Integer> getCart() {
		return this.order.getCart().getCart();
	}

	public double getCartTotalPrice(boolean isMember) {
		return this.order.getCart().getCartTotalPrice(isMember);
	}

	public int getCartSize() {
		return this.order.getCart().getCartSize();
	}
	
	public Item getCartItem(int itemNo) {
		return this.order.getCart().getCartItem(itemNo);
	}
	
	public void editItem(Item item, int qty) {
		this.order.getCart().editItem(item, qty);
	}

	public double getDeliveryRate(String area) {
		return this.deliveryInfo.getRate(area);
	}
	
	public void setDeliveryFee(String area) {
		double fee = this.deliveryInfo.getRate(area);
		this.order.setDeliveryFee(fee);
	}
}
