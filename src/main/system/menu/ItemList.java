package system.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import system.file.IDatabase;
import system.login.Address;
import system.login.Member;

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
}
