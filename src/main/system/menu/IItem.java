package system.menu;

import java.util.ArrayList;
import java.util.List;

public interface IItem {

	public Item getItemFromList(int itemNo);

	public List<ArrayList<Object>> getItemDataList();
}
