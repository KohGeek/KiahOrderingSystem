package system.domain.item_module;

import java.util.ArrayList;
import java.util.List;

public interface IItem {

	public Item getItemFromList(int itemNo);

	public List<ArrayList<Object>> getItemDataList();
}
