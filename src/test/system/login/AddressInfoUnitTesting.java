package system.login;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.payment.DeliveryCostList;

@RunWith(JUnitParamsRunner.class)
public class AddressInfoUnitTesting {

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.1.1 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "AddressUnitNumberInvalidParams")
	public void AddressUnitNumberInvalidTests(String input) {
		new Address(input);
	}

	private Object[] AddressUnitNumberInvalidParams() {
		return new Object[] { 
			new Object[] { "" }, 
		};
	}

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.1.2 
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "AddressUnitNumberValidParams")
	public void AddressUnitNumberValidTests(String input) {
		Address address = new Address(input);
		String[] expectedResult = new String[] { input, null, null, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] AddressUnitNumberValidParams() {
		return new Object[] { 
			new Object[] { "B1" }, 
		};
	}

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.2.1 ~ 2.2.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "AddressStreetNameInvalidParams")
	public void AddressStreetNameInvalidTests(String streetName) {
		Address address = new Address("B1");
		address.setStreetName(streetName);

	}

	private Object[] AddressStreetNameInvalidParams() {
		return new Object[] { 
			new Object[] { "abcd" }, 
			new Object[] { "" } 
		};
	}

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.2.3 
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "AddressStreetNameValidParams")
	public void AddressStreetNameValidTests(String streetName) {
		Address address = new Address("B1");
		address.setStreetName(streetName);
		String[] expectedResult = new String[] { "B1", streetName, null, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] AddressStreetNameValidParams() {
		return new Object[] { 
			new Object[] { "abcdef" }, 
		};
	}
	
	/*
	 * Login Module Unit Testing 
	 * Test Case 2.3.1 ~ 2.3.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "AddressDistrictInvalidParams")
	public void AddressDistrictInvalidTests(String district) {
		Address address = new Address("B1");
		address.setDistrict(district);

	}

	private Object[] AddressDistrictInvalidParams() {
		return new Object[] { 
			new Object[] { "abcd" }, 
			new Object[] { "" } 
		};
	}

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.3.3
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "AddressDistrictValidParams")
	public void AddressDistrictValidTests(String district) {
		Address address = new Address("B1");
		address.setDistrict(district);
		String[] expectedResult = new String[] { "B1", null, district, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] AddressDistrictValidParams() {
		return new Object[] { 
			new Object[] { "abcdef" }, 
		};
	}
	
	/*
	 * Login Module Unit Testing 
	 * Test Case 2.4.1 ~ 2.4.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	@Parameters(method = "AddressAreaInvalidParams")
	public void AddressAreaInvalidTests(int areaNo) {
		DeliveryCostList dcl = new DeliveryCostList("deliveryCostData.txt");
		dcl.getAreaName(areaNo);
	}

	private Object[] AddressAreaInvalidParams() {
		return new Object[] { 
			new Object[] { "21" }, 
			new Object[] { "-1" } 
		};
	}

	/*
	 * Login Module Unit Testing 
	 * Test Case 2.4.3
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "AddressAreaValidParams")
	public void AddressAreaValidTests(int areaNo, String areaName) {
		DeliveryCostList dcl = new DeliveryCostList("deliveryCostData.txt");
		String expectedResult = dcl.getAreaName(areaNo);
		assertEquals(expectedResult, areaName);
	}

	private Object[] AddressAreaValidParams() {
		return new Object[] { 
			new Object[] { 10, "Kuala Sungai Baru"}, 
		};
	}
	
	
	/*
	 * Login Module Unit Testing 
	 * Test Case 2.5.1 ~ 2.5.2
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "AddressPostalCodeInvalidParams")
	public void AddressPostalCodeInvalidTests(int postalCode) {
		Address address = new Address("B1");
		address.setPostalCode(postalCode);
	}

	private Object[] AddressPostalCodeInvalidParams() {
		return new Object[] { 
			new Object[] { 74999 },
			new Object[] { 79000 },
		};
	}
	
	/*
	 * Login Module 
	 * Unit Testing Test Case 2.5.3
	 * - Boundary Value Analysis
	 */
	@Test 
	@Parameters (method = "AddressPostalCodeValidParams")
	public void AddressPostalCodeValidTests(int postalCode) {
		Address address = new Address("B1");
		address.setPostalCode(postalCode);
		String[] expectedResult = new String[] { "B1", null, null, null, String.valueOf(postalCode), "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] AddressPostalCodeValidParams() {
		return new Object[] { 
			new Object[] { 75000 }, 
			new Object[] { 78999 } 
		};
	}

}

