package system.menu;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Cart implements ICart {

	private LinkedHashMap<Item, Integer> cart;

	public Cart() {
		this.cart = new LinkedHashMap<Item, Integer>();
	}

	@Override
	public void addItem(Item item, int qty) {
		Item $item = item;
		int $qty = qty;
		if (this.cart.containsKey($item)) {
			int newQty = this.cart.get($item) + qty;
			this.cart.replace($item, newQty);
		} else if (!this.cart.containsKey($item))
			this.cart.put($item, $qty);
	}

	@Override
	public LinkedHashMap<Item, Integer> getCart() {
		return this.cart;
	}

	@Override
	public double getCartTotalPrice(boolean isMember) {
		double totalPrice = 0;
		if (isMember)
			for (Entry<Item, Integer> item : this.cart.entrySet()) {
				if (item.getKey().getIsPromotional())
					totalPrice += item.getKey().getMemberPrice() * item.getValue() * item.getKey().getDiscountRate();
				else if (!item.getKey().getIsPromotional())
					totalPrice += item.getKey().getMemberPrice() * item.getValue();
			}
		else if (!isMember)
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
		if ($qty == 0)
			this.cart.remove($item);
		else if ($qty != 0)
			this.cart.put($item, $qty);

	}

	@Override
	public int getCartSize() {
		return this.cart.size();
	}

	@Override
	public Item getCartItem(int itemNo) {
		int $itemNo = itemNo - 1;
		int i = 0;
		Item theItem = null;
		for (Entry<Item, Integer> item : this.cart.entrySet()) {
			if (i == $itemNo)
				theItem = item.getKey();
			i++;
		}
		return theItem;
	}
	
	@Override
	public boolean isItemInCart() {
		if ( this.cart.size() !=0 ) {
			return true;
		}
		else {
			return false;
		}
	}
}
