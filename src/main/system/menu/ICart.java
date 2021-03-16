package system.menu;

import java.util.HashMap;

public interface ICart {

	public void addItem(Item item, int qty);

	public HashMap<Item, Integer> getCart();

	public double getCartTotalPrice(boolean isMember);

	public void editItem(Item item, int quantity);
}
