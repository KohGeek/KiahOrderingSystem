package system.domain.item_module;

import java.util.ArrayList;
import java.util.List;

public interface IItem {

	public List<ArrayList<Object>> getItemDataList();

	public Item getItemFromList(int itemNo);
}
