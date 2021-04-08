package system.domain.item_module;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GetItemFromItemListTest {
	
	
	/*
	 * Item Module Unit Test
	 * Test case 1.1.1 ~ 1.1.2
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters
	public void getItemFromListTestInvalid(int itemNo) {
		ItemList itemList = new ItemList("itemData.txt");
		itemList.getItemFromList(itemNo);
	}

	private Object[] parametersForGetItemFromListTestInvalid() {
		return new Object[] { 
				new Object[] { -1 }, 
				new Object[] { 100 } 
				};
	}
	
	/*
	 * Item Module Unit Test
	 * Test case 1.1.3 ~ 1.1.4
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters
	public void getItemFromListTestValid(int itemNo, Item expectedResult) {
		ItemList itemList = new ItemList("itemData.txt");
		Item actualResult = itemList.getItemFromList(itemNo);
		assertEquals(expectedResult.getName(), actualResult.getName());
		assertEquals(expectedResult.getType(), actualResult.getType());
		assertEquals(expectedResult.getMemberPrice(), actualResult.getMemberPrice(), 0);
		assertEquals(expectedResult.getNonMemberPrice(), actualResult.getNonMemberPrice(), 0);
		assertEquals(expectedResult.getIsPromotional(), actualResult.getIsPromotional());
	}

	private Object[] parametersForGetItemFromListTestValid() {
		Object[] testData = new Object[2];
		try {
			Scanner s = new Scanner(new File("itemModuleTestData.txt"));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				testData = new Object[] {
						new Object[] { s.nextInt(),
								new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean()) },
						new Object[] { s.nextInt(),
								new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean()) } };
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}

	/*
	 * Item Module Unit Test
	 * Test case 2.1.1
	 * - Analysis
	 */
	@Test
	public void getItemDataListTest() {
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
