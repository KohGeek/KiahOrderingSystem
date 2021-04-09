package system.controller;

import java.util.ArrayList;
import java.util.List;

import system.domain.item_module.IItem;
import system.domain.item_module.Item;
import system.domain.login_module.User;
import system.domain.order_module.Order;
import system.domain.payment_module.PaymentMethod;
import system.domain.payment_module.ProceedPayment;

public class MenuCtrl {

	private Order order;
	private IItem itemList;
	private ProceedPayment pPayment;

	public MenuCtrl(Order order, IItem itemList, ProceedPayment pPayment) {
		this.order = order;
		this.itemList = itemList;
		this.pPayment = pPayment;
	}

	public void editItem(Item item, int qty) {
		this.order.editItem(item, qty);
	}

	public void addItem(Item item, int qty) {
		this.order.addItem(item, qty);
	}

	public void checkIsCartEmpty() {
		this.order.checkIsCartEmpty();
	}

	public void makePayment(PaymentMethod PM) {
		this.pPayment.makePayment(this.order, PM);
	}

	public List<ArrayList<Object>> getCartData() {
		return this.order.getCartData();
	}

	public double getCartTotalPrice() {
		return this.order.getCartTotalPrice();
	}

	public Item getCartItem(int itemNo) {
		return this.order.getItemFromCart(itemNo);
	}

	public User getUser() {
		return this.order.getUser();
	}

	public Order getOrder() {
		return this.order;
	}

	public int getOrderID() {
		return this.order.getID();
	}

	public String getName(User user) {
		return user.getName();
	}

	public String getAddress(User user) {
		return user.getAddress().getFullAddress();
	}

	public Item getItemFromList(int itemNo) {
		return this.itemList.getItemFromList(itemNo);
	}
	
	public double getDeliveryFee(Order order) {
		return order.getDeliveryFee();
	}

	public double getTotalPrice(Order order) {
		return order.getTotalPrice();
	}

	public List<ArrayList<Object>> getItemData() {
		return this.itemList.getItemDataList();
	}
	
	public String getPaymentStatus() {
		return this.pPayment.getPaymentStatus();
	}
}
