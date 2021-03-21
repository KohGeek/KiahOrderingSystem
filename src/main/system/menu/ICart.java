package system.menu;

import java.util.LinkedHashMap;

public interface ICart {

	public void addItem(Item item, int qty);

	public LinkedHashMap<Item, Integer> getCart();

	public double getCartTotalPrice(boolean isMember);

	public void editItem(Item item, int qty);
	
	public int getCartSize();
}
