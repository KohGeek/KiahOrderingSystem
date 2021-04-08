package system.domain.order_module;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.item_module.Item;

@RunWith(JUnitParamsRunner.class)
public class GetItemFromCartUnitTest {

	/*
	 * Order Module Unit Test 
	 * Test Cases 6.1.1 
	 * - Analysis
	 */
	@Test
	@Parameters
	public void getItemFromCartTestValid(int index, int expectedResultIndex) {
		
		Order order = new Order();
		Item item = null;
		Item [] items_in_cart = new Item [3];
		try {
			Scanner s = new Scanner(new File("cartModuleTestSetupData.txt"));
			s.useDelimiter("(,|\r\n|\r|\n)");
			int i = 0;
			while (s.hasNext()) {
				item = new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean());
				items_in_cart[i] = item;
				order.addItem(item, 1);
				i++;
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Item expectedResult = items_in_cart[expectedResultIndex];
		Item actualResult = order.getItemFromCart(index);
		assertEquals(expectedResult, actualResult);
	}
	
	private Object[] parametersForGetItemFromCartTestValid() {
		return new Object[] {
				new Object[] {0,0},
				new Object[] {1,1},
				new Object[] {2,2},
		};
	}
	
	/*
	 * Order Module Unit Test 
	 * Test Cases 6.1.2
	 * - Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters
	public void getItemFromCartTestInvalid(int index) {
		
		Order order = new Order();
		Item item = null;
		Item [] items_in_cart = new Item [3];
		try {
			Scanner s = new Scanner(new File("cartModuleTestSetupData.txt"));
			s.useDelimiter("(,|\r\n|\r|\n)");
			int i = 0;
			while (s.hasNext()) {
				item = new Item(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextBoolean());
				items_in_cart[i] = item;
				order.addItem(item, 1);
				i++;
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		order.getItemFromCart(index);
	}
	
	private Object[] parametersForGetItemFromCartTestInvalid() {
		return new Object[] {
				new Object[] {-1},
				new Object[] {10},
		};
	}
}
