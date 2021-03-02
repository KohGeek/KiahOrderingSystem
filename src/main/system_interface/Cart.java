package system_interface;

public interface Cart {

	public void addItem (Item item, int quantity);

	public void displayPurchaseList ();
	
	public void editItem(Item item, int quantity);
}
