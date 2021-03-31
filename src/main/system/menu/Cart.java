package system.menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import system.login.Guest;
import system.login.Member;
import system.login.User;

public class Cart implements ICart {

	private LinkedHashMap<Item, Integer> cart;

	public Cart() {
		this.cart = new LinkedHashMap<Item, Integer>();
	}

	@Override
	public void addItem(Item item, int qty) {
		Item $item = item;
		int $qty = qty;

		if ($qty == 0) {
			throw new IllegalArgumentException("Item quantity cannot be empty.");
		} else if ($qty > 100) {
			throw new IllegalArgumentException("Item quantity can only accept 1~100.");
		} else if ($qty < 0) {
			throw new IllegalArgumentException("Item quantity cannot be negative.");
		}

		if (this.cart.containsKey($item)) {
			int newQty = this.cart.get($item) + qty;
			this.cart.replace($item, newQty);
		} else if (!this.cart.containsKey($item))
			this.cart.put($item, $qty);
	}

	@Override
	public double getCartTotalPrice(User user) {
		double totalPrice = 0;
		if (user instanceof Member)
			for (Entry<Item, Integer> item : this.cart.entrySet()) {
				if (item.getKey().getIsPromotional())
					totalPrice += item.getKey().getMemberPrice() * item.getValue() * item.getKey().getDiscountRate();
				else if (!item.getKey().getIsPromotional())
					totalPrice += item.getKey().getMemberPrice() * item.getValue();
			}
		else if (user instanceof Guest)
			for (Entry<Item, Integer> item : this.cart.entrySet()) {
				if (item.getKey().getIsPromotional())
					totalPrice += item.getKey().getNonMemberPrice() * item.getValue() * item.getKey().getDiscountRate();
				else if (!item.getKey().getIsPromotional())
					totalPrice += item.getKey().getNonMemberPrice() * item.getValue();
			}
		return totalPrice;
	}

	@Override
	public void editItem(Item item, int qty) {
		Item $item = item;
		int $qty = qty;

		if ($qty == 0) {
			throw new IllegalArgumentException("Item quantity cannot be empty.");
		} else if ($qty > 100) {
			throw new IllegalArgumentException("Item quantity can only accept 1~100.");
		} else if ($qty < 0) {
			throw new IllegalArgumentException("Item quantity cannot be negative.");
		}

		if ($qty == 0)
			this.cart.remove($item);
		else if ($qty != 0)
			this.cart.put($item, $qty);
	}

	@Override
	public Item getCartItem(int itemNo) {
		int $itemNo = itemNo - 1;
		int i = 0;
		Item theItem = null;

		if ($itemNo > this.cart.size()) {
			throw new IllegalArgumentException("Item is not shown in the provided list.");
		} else if ($itemNo <= 0) {
			throw new IllegalArgumentException("Item number is invalid.");
		}

		for (Entry<Item, Integer> item : this.cart.entrySet()) {
			if (i == $itemNo)
				theItem = item.getKey();
			i++;
		}
		return theItem;
	}

	@Override
	public void checkIsCartEmpty() {
		if (this.cart.size() == 0) {
			throw new IllegalAccessError("You have not added item yet.");
		}
	}

	@Override
	public List<ArrayList<Object>> getCartData(User user) {

		ArrayList<Object> cartData;
		List<ArrayList<Object>> cartDataArr = new ArrayList<ArrayList<Object>>();
		if (user instanceof Member) {
			for (Entry<Item, Integer> item : this.cart.entrySet()) {
				cartData = new ArrayList<Object>();
				cartData.add(item.getKey().getName());
				cartData.add(item.getKey().getMemberPrice());
				cartData.add(item.getValue());
				if (item.getKey().getIsPromotional() == true) {
					cartData.add("Yes");
				} else if (item.getKey().getIsPromotional() == false) {
					cartData.add("No");
				}
				cartDataArr.add(cartData);
			}
		} else if (user instanceof Guest) {
			for (Entry<Item, Integer> item : this.cart.entrySet()) {
				cartData = new ArrayList<Object>();
				cartData.add(item.getKey().getName());
				cartData.add(item.getKey().getNonMemberPrice());
				cartData.add(item.getValue());
				if (item.getKey().getIsPromotional() == true) {
					cartData.add("Yes");
				} else if (item.getKey().getIsPromotional() == false) {
					cartData.add("No");
				}
				cartDataArr.add(cartData);
			}
		}

		return cartDataArr;
	}

}
