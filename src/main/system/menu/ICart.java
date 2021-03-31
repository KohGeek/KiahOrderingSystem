package system.menu;

import java.util.ArrayList;
import java.util.List;

import system.login.User;

public interface ICart {

	public void addItem(Item item, int qty);

	public double getCartTotalPrice(User user);

	public Item getCartItem(int itemNo);

	public void editItem(Item item, int qty);

	public void checkIsCartEmpty();

	public List<ArrayList<Object>> getCartData(User user);
}
