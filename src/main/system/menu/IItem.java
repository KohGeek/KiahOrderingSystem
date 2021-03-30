package system.menu;

import java.util.List;

public interface IItem {

	public List<Item> getItemList();
	
	public int getItemListSize();

	public Item getItem(int option);
	
	public boolean isitemInputVAL(int itemNo);

}
