package system.menu;

import java.util.ArrayList;
import java.util.List;

import system.file.IDatabase;

public class ItemList implements IItem, IDatabase {

	private List<Item> itemList;

	public ItemList(String fileName) {
		this.itemList = new ArrayList<Item>();
		initDataFromFile(fileName);
	}

	@Override
	public List<Item> getItemList() {
		return this.itemList;
	}

	@Override
	public int getItemListSize() {
		return this.itemList.size();
	}

	@Override
	public Item getItem(int itemNo) {
		return this.itemList.get(itemNo);
	}

	@Override
	public void initDataFromFile(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDataToFile(String fileName) {

	}
}
