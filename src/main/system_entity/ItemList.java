package system_entity;

import java.util.ArrayList;

import system_interface.ItemUI;

public class ItemList implements ItemUI {

	private static ArrayList<Item> itemList;

	@Override
	public void displayItemList() {

		System.out.println("No.   Name /t/t/tMemberPrice   nonMemberPrice   Promotion(5%)");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.printf("%d   %s /t/t/t%.2f/t%.2f   /t   ", i + 1, itemList.get(i).getName(),
					itemList.get(i).getMemberPrice(), itemList.get(i).getNonMemberPrice());
			if (itemList.get(i).getIsPromotional() == true) {
				System.out.println("Yes");
			}
			if (itemList.get(i).getIsPromotional() == false) {
				System.out.println("No");
			}
		}

		System.out.println("00   Exit");

	}

	public void initDataFromFile(String fileName) {

	}

	public void updateDataToFile(String fileName) {

	}
	
	public Item getItem(int option) {
		return this.option;
	}

	public ItemList() {

	}
}
