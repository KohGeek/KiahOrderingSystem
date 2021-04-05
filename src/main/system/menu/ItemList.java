package system.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemList implements IItem {

	private List<Item> itemList;

	public ItemList(String fileName) {
		this.itemList = new ArrayList<Item>();
		try {
			Scanner s = new Scanner(new File(fileName));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				this.itemList.add(new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean()));
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item getItemFromList(int itemNo) {
		if (itemNo >= this.itemList.size()) {
			throw new IllegalArgumentException("Item is not shown in the provided list.");
		} else if (itemNo < 0) {
			throw new IllegalArgumentException("Item number is invalid.");
		}

		return this.itemList.get(itemNo);
	}

	@Override
	public List<ArrayList<Object>> getItemDataList() {
		List<ArrayList<Object>> itemDataArr = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> itemData;
		int count = 1;
		for (Item item : this.itemList) {
			itemData = new ArrayList<Object>();
			itemData.add(count);
			itemData.add(item.getName());
			itemData.add(item.getMemberPrice());
			itemData.add(item.getNonMemberPrice());
			if (item.getIsPromotional() == true) {
				itemData.add("Yes");
			} else if (item.getIsPromotional() == false) {
				itemData.add("No");
			}
			itemDataArr.add(itemData);
			count++;
		}
		return itemDataArr;
	}
}
