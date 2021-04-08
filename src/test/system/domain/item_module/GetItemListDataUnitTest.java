package system.domain.item_module;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class GetItemListDataUnitTest {

	/*
	 * Item Module Unit Test
	 * Test case 2.1.1
	 * - Analysis
	 */
	@Test
	public void getItemListDataTest() {
		Item item = null;
		try {
			Scanner s = new Scanner(new File("itemModuleTestData.txt"));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				s.next(); //skip
				item = new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean());
				break;
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ItemList itemList = new ItemList(item);
		List<ArrayList<Object>> actualResult = itemList.getItemDataList();

		List<ArrayList<Object>> expectedResult = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> arrObj = new ArrayList<Object>();
		arrObj.add(1);
		arrObj.add(item.getName());
		arrObj.add(item.getMemberPrice());
		arrObj.add(item.getNonMemberPrice());
		if (item.getIsPromotional() == true) {
			arrObj.add("Yes");
		} else if (item.getIsPromotional() == false) {
			arrObj.add("No");
		}
		expectedResult.add(arrObj);

		assertEquals(expectedResult, actualResult);
	}
}
