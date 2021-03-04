package system_entity;

import java.util.HashMap;
import java.util.Map.Entry;

import system_interface.Cart;

public class PurchaseList implements Cart{

	private HashMap<Item, Integer> purchaseList;
	private double totalPrice;

	public void addItem(Item item, int quantity) {
		Item $item = item;
		int $quantity = quantity;

		purchaseList.put($item, $quantity);
	}

	public void editItem(Item item, int quantity) {
		Item $item = item;
		int $quantity = quantity;

		purchaseList.replace($item, $quantity);
	}
	
	public void displayPurchaseList() {
		int i=0;
		System.out.println("No.   Name /t/t/tPrice   Quantity");
		for (Entry<Item, Integer> item : this.purchaseList.entrySet()) {
			System.out.printf("%d   %s /t/t/t%.2f/t%.2f   /t   ", i + 1, item.getKey(), item.getValue());
		}
	}
	
	public void computeTotalPrice() {
	}
	
	public PurchaseList() {
		
	}

	@Override
	public PurchaseList getPurchaseList() {
		// TODO Auto-generated method stub
		return this.purchaseList;
	}
}
