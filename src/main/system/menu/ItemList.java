package system.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import system.file.IDatabase;

public class ItemList implements IItem, IDatabase {

	private List<Item> itemList;

	public ItemList(String fileName) {
		this.itemList = new ArrayList<Item>();
		initDataFromFile(fileName);
	}

	@Override
	public void initDataFromFile(String fileName) {
		String $filename = fileName;
		try {
			Scanner s = new Scanner(new File($filename));
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
	public void updateDataToFile(String fileName) {

	}

	public Item getItemFromList(int itemNo) {
		int $itemNo = itemNo;
		if ($itemNo > this.itemList.size()) {
			throw new IllegalArgumentException("Item is not shown in the provided list.");
		} else if ($itemNo <= 0) {
			throw new IllegalArgumentException("Item number is invalid.");
		} else if ($itemNo == 99) {
			return null; // exit menu
		}

		return this.itemList.get(itemNo - 1);
	}

	public boolean isitemInputVAL(int itemNo) {
		if (this.itemList.size() <= 0 || this.itemList.size() > 20) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<ArrayList<Object>> getItemDataList() {
		List<ArrayList<Object>> itemDataArr = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> itemData;
		for (Item item : this.itemList) {
			itemData = new ArrayList<Object>();
			itemData.add(item.getName());
			itemData.add(item.getMemberPrice());
			itemData.add(item.getNonMemberPrice());
			if (item.getIsPromotional() == true) {
				itemData.add("Yes");
			} else if (item.getIsPromotional() == false) {
				itemData.add("No");
			}
			itemDataArr.add(itemData);
		}
		return itemDataArr;
	}
}
