package system_entity;

import java.util.ArrayList;

import system_interface.Database;
import system_interface.IofItem;

public class ItemList implements IofItem, Database {

	private ArrayList<Item> itemList;

	@Override
	public void displayItemList() {
		System.out.println("No.   Name /t/t/tMemberPrice   nonMemberPrice   Promotion(5%)");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.printf("%d   %s /t/t/t%.2f/t%.2f   /t   ", i + 1, itemList.get(i).getName(),
					itemList.get(i).getMemberPrice(), itemList.get(i).getNonMemberPrice());
			if (itemList.get(i).getIsPromotional() == true) {
				System.out.println("Yes");
			} else if (itemList.get(i).getIsPromotional() == false) {
				System.out.println("No");
			}
		}
		System.out.println("00   Exit");
	}

	public Item getItem(int option) {
		return this.itemList.get(option);
	}

	@Override
	public ArrayList<Member> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initDataFromFile(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDataToFile(String fileName) {

	}

	public ItemList() {
		
	}
	
}
