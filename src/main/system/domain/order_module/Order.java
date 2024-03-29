package system.domain.order_module;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import system.domain.item_module.Item;
import system.domain.login_module.Guest;
import system.domain.login_module.Member;
import system.domain.login_module.User;
import system.domain.payment_module.PayStatus;
import system.domain.payment_module.PaymentMethod;

class Cart {
	private LinkedHashMap<Item, Integer> cartList;
	
	public Cart(LinkedHashMap<Item, Integer> cartList) {
		this.cartList = cartList;
	}

	public Cart() {
		this.cartList = new LinkedHashMap<Item, Integer>();
	}

	public void addItem(Item item, int qty) {
		if (this.cartList.containsKey(item)) {
			qty += this.cartList.get(item);
			if (qty >100 ) {
				throw new IllegalArgumentException();
			}
			this.cartList.replace(item, qty);
		} else {
			this.cartList.put(item, qty);
		}
	}

	public void editItem(Item item, int newQty) {
		if (newQty == 0) {
			this.cartList.remove(item);
		} else {
			this.cartList.put(item, newQty);
		}
	}

	public LinkedHashMap<Item, Integer> getCart() {
		return this.cartList;
	}

	public Item getCartItem(int itemNo) {
		int i = 0;
		Item theItem = null;

		if (itemNo > this.cartList.size()) {
			throw new IllegalArgumentException("Item is not shown in the provided list.");
		} else if (itemNo < 0) {
			throw new IllegalArgumentException("Item number is invalid.");
		}

		for (Entry<Item, Integer> item : this.cartList.entrySet()) {
			if (i == itemNo)
				theItem = item.getKey();
			i++;
		}
		return theItem;
	}

	public double getCartTotalPrice(User user) {
		double totalPrice = 0;
		if (user instanceof Member)
			for (Entry<Item, Integer> item : this.cartList.entrySet()) {
				if (item.getKey().getIsPromotional())
					totalPrice += item.getKey().getMemberPrice() * item.getValue() * item.getKey().getDiscountRate();
				else { //!item.getKey().getIsPromotional()
					totalPrice += item.getKey().getMemberPrice() * item.getValue();
				}
			}
		else if (user instanceof Guest)
			for (Entry<Item, Integer> item : this.cartList.entrySet()) {
				if (item.getKey().getIsPromotional())
					totalPrice += item.getKey().getNonMemberPrice() * item.getValue() * item.getKey().getDiscountRate();
				else { //!item.getKey().getIsPromotional()
					totalPrice += item.getKey().getNonMemberPrice() * item.getValue();
				}
			}
		return totalPrice;
	}

	public List<ArrayList<Object>> getCartData(User user) {

		ArrayList<Object> cartData;
		List<ArrayList<Object>> cartDataArr = new ArrayList<ArrayList<Object>>();
		int count = 1;
		if (user instanceof Member) {
			for (Entry<Item, Integer> item : this.cartList.entrySet()) {
				cartData = new ArrayList<Object>();
				cartData.add(count);
				cartData.add(item.getKey().getName());
				cartData.add(item.getKey().getMemberPrice());
				cartData.add(item.getValue());
				if (item.getKey().getIsPromotional() == true) {
					cartData.add("Yes");
				} else { //item.getKey().getIsPromotional() == false
					cartData.add("No");
				}
				cartDataArr.add(cartData);
				count++;
			}
		} else { //user instanceof Guest
			for (Entry<Item, Integer> item : this.cartList.entrySet()) {
				cartData = new ArrayList<Object>();
				cartData.add(count);
				cartData.add(item.getKey().getName());
				cartData.add(item.getKey().getNonMemberPrice());
				cartData.add(item.getValue());
				if (item.getKey().getIsPromotional() == true) {
					cartData.add("Yes");
				} else { //item.getKey().getIsPromotional() == false
					cartData.add("No");
				}
				cartDataArr.add(cartData);
				count++;
			}
		}

		return cartDataArr;
	}
}

public class Order {

	private int orderID;
	private User user;
	private Cart cart;
	private double deliveryCost;
	private Payment paymentDetails;
	private double totalPrice;
	private double minOrderValue = 25;
	private double extraCharge = 3;

	public Order(User user, IDelivery deliveryInfo, String fileName) {
		this.user = user;
		this.cart = new Cart();
		this.paymentDetails = new Payment();
		this.totalPrice = 0;
		this.orderID = generateOrderID(fileName);
		setDeliveryCost(deliveryInfo);
	}
	
	public Order(LinkedHashMap<Item, Integer> cartList) {
		this.cart = new Cart(cartList);
		this.paymentDetails = new Payment();
	}

	public Order(User user) {
		this.user = user;
		this.cart = new Cart();
		this.paymentDetails = new Payment();
	}

	public Order(String fileName) {
		this.orderID = generateOrderID(fileName);
	}
	
	public Order() {
		this.cart = new Cart();
		this.paymentDetails = new Payment();
	}
	
	public void addItem(Item item, int qty) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null.");
		} else if (qty <= 0) {
			throw new IllegalArgumentException("Item quantity cannot be 0 or negative.");
		} else if (qty > 100) {
			throw new IllegalArgumentException("Item quantity can only accept 1~100.");
		}
	
		try {
			this.cart.addItem(item, qty);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("New added item quantity cannot exceed 100!");
		}
	}

	public void editItem(Item item, int newQty) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null.");
		} else if (newQty > 100) {
			throw new IllegalArgumentException("Item quantity can only accept 1~100.");
		} else if (newQty < 0) {
			throw new IllegalArgumentException("Item quantity cannot be negative.");
		}
	
		this.cart.editItem(item, newQty);
	}

	public void checkIsCartEmpty() {
		if (this.cart.getCart().size() == 0) {
			throw new IllegalArgumentException("You have not added item yet.");
		}
	}

	private int generateOrderID(String fileName) {
		int tempID = 0;
		try {
			Scanner s = new Scanner(new File(fileName));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				tempID = s.nextInt();
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tempID ++;
		this.orderID = tempID;
		return tempID;
	}

	private void setDeliveryCost(IDelivery deliveryInfo) {
		this.deliveryCost = deliveryInfo.getRate(this.user.getAddress().getArea());
	}

	public void updatePayStatus(PayStatus payStatus) {
		this.paymentDetails.setPayStatus(payStatus);
	}

	public void updatePaymentMethod(PaymentMethod paymentMethod) {
		this.paymentDetails.setPaymentMethod(paymentMethod);
	}

	public int getID() {
		return orderID;
	}

	public User getUser() {
		return this.user;
	}

	public Cart getCart() {
		return this.cart;
	}

	public List<ArrayList<Object>> getCartData() {
		return this.cart.getCartData(this.user);
	}

	public Item getItemFromCart(int itemNum) {
		return this.cart.getCartItem(itemNum);
	}

	public double getDeliveryFee() {
		return this.deliveryCost;
	}

	public double getCartTotalPrice() {
		return this.cart.getCartTotalPrice(this.user);
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		totalPrice += this.cart.getCartTotalPrice(this.user);
		if (totalPrice < this.minOrderValue) {
			totalPrice += this.extraCharge; // Additional Charges of RM3
		}
		totalPrice += deliveryCost;
		this.totalPrice = totalPrice;
		return this.totalPrice;
	}

	public Payment getPaymentDetails() {
		return this.paymentDetails;
	}

	public class Payment {

		private double totalPrice;
		private PayStatus paymentStatus;
		private PaymentMethod paymentMethod;

		public Payment() {
			this.totalPrice = 0;
			this.paymentStatus = PayStatus.Unsuccessful;
		}

		public void setPayStatus(PayStatus payStatus) {
			this.paymentStatus = payStatus;
		}
		
		public void setPaymentMethod(PaymentMethod paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		
		public PayStatus getPaymentStatus() {
			return this.paymentStatus;
		}
		
		public PaymentMethod getPaymentMethod() {
			return this.paymentMethod;
		}

		public double getPaymentTotalPrice() {
			return this.totalPrice;
		}
	}

}
