package system_controller;

import java.util.ArrayList;

import system_entity.Input;
import system_entity.Item;
import system_entity.ItemList;
import system_entity.PurchaseList;
import system_interface.Cart;
import system_interface.IofItem;

public class MenuCtrl {

	private IofItem itemList;
	private Cart purchaseList;

	public void orderItem() {
		Input input = new Input();
		itemList.displayItemList();

		int itemOption;
		int itemQty;
		do {
			itemOption = Integer.parseInt(input.getInput("Enter the item's number ----> "));
			if (itemOption < 1 || itemOption > ((ArrayList<Item>) this.itemList).size())
				// when itemOption is invalid
				System.out.println("Entered option is invalid.\n");
			else if (itemOption >= 1 || itemOption <= ((ArrayList<Item>) this.itemList).size()) {
				// when itemOption is valid and then add item to purchaseList
				itemQty = Integer.parseInt(input.getInput("Enter the item's quantity ----> "));
				purchaseList.addItem(itemOption, itemQty);
			} else if (itemOption == 00)
				// exit loop and back to menuOptions
				;
		} while (itemOption != 00);
	}

	public void viewCart() {
		purchaseList.displayPurchaseList();
	}

	public void exitSystem() {
		System.out.println("Thank you for using Kiah Ordering System.");
		exitSystem();
	}

	public PurchaseList getPurchaseList() {
		return (PurchaseList) this.purchaseList;
	}

	public MenuCtrl() {
		this.itemList = new ItemList();
		((ItemList) this.itemList).initDataFromFile("itemData.txt");

		this.purchaseList = new PurchaseList();
	}
}
