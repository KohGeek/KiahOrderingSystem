package system_interface;

import system_entity.Item;
import system_entity.PurchaseList;

public interface ICart {

	public void addItem (Item item, int quantity);

	public void displayPurchaseList ();
	
	public void editItem(Item item, int quantity);

}
