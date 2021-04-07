package system.domain.item_module;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GetItemFromItemListTest {
	
	@Test
	@Parameters
	public void getItemFromListTestInvalid(int itemNo, Item expectedResult) {
		ItemList itemList = new ItemList("itemData.txt");
		Item actualResult = itemList.getItemFromList(-1);
		assertEquals(expectedResult, actualResult);
	}
	
	private Object[] parametersForGetItemFromListTestInvalid() {
		Object[] testData = null;
		try {
			Scanner s = new Scanner(new File("itemModuleTestData.txt"));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				testData =  new Object[] {
						new Object[] {s.nextInt(), new Item(s.nextLine(), s.nextLine(), s.nextDouble(), s.nextDouble(), s.nextBoolean())},
						new Object[] {s.nextInt(), new Item(s.nextLine(), s.nextLine(), s.nextDouble(), s.nextDouble(), s.nextBoolean())}
				};
			}
			s.close();
		}catch (Exception e) {
				e.printStackTrace();
		}
		return testData;
	}
}
