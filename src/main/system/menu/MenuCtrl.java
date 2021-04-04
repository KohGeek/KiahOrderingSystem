package system.menu;

import java.util.ArrayList;
import java.util.List;

import system.login.User;
import system.payment.Order;
import system.payment.PaymentMethod;
import system.payment.ProceedPayment;

public class MenuCtrl {

	private Order order;
	private IItem itemList;
	private ProceedPayment pPayment;

	public MenuCtrl(Order order, IItem itemList, ProceedPayment pPayment) {
		this.order = order;
		this.itemList = itemList;
		this.pPayment = pPayment;
	}

	public Item getItemFromList(int itemNo) {
		return this.itemList.getItemFromList(itemNo);
	}
	
	public void addItem(Item item, int qty) {
		this.order.addItem(item, qty);
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
	
	public void editItem(Item item, int qty) {
		this.order.editItem(item, qty);
	}

	public User getUser() {
		return this.order.getUser();
	}

	public Order getOrder() {
		return this.order;
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

	public void checkIsCartEmpty() {
		this.order.checkIsCartEmpty();
	}

	public List<ArrayList<Object>> getItemData() {
		return this.itemList.getItemDataList();
	}
	
	public void makePayment(PaymentMethod PM) {
		this.pPayment.makePayment(this.order, PM);
	}
	
	public String getPaymentStatus() {
		return this.pPayment.getPaymentStatus();
	}
}
