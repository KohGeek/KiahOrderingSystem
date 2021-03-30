package system.menu;

import java.util.LinkedHashMap;

public interface ICart {

	public void addItem(Item item, int qty);

	public LinkedHashMap<Item, Integer> getCart();

	public double getCartTotalPrice(boolean isMember);
	
	public Item getCartItem(int itemNo);

	public void editItem(Item item, int qty);
	
	public int getCartSize();
	
	public boolean isItemInCart();
}
