package system.domain.login_module;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.login_module.Address;
import system.domain.order_module.DeliveryCostList;

@RunWith(JUnitParamsRunner.class)
public class AddressInfoUnitTest {

	/*
	 * Login Module Unit Test
	 * Test Case 2.1.1 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "addressUnitNumberInvalidParams")
	public void addressUnitNumberInvalidTests(String input) {
		new Address(input);
	}

	private Object[] addressUnitNumberInvalidParams() {
		return new Object[] { 
			new Object[] { "" }, 
		};
	}

	/*
	 * Login Module Unit Test
	 * Test Case 2.1.2 
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "addressUnitNumberValidParams")
	public void addressUnitNumberValidTests(String input) {
		Address address = new Address(input);
		String[] expectedResult = new String[] { input, null, null, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] addressUnitNumberValidParams() {
		return new Object[] { 
			new Object[] { "B1" }, 
		};
	}

	/*
	 * Login Module Unit Test
	 * Test Case 2.2.1 ~ 2.2.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "addressStreetNameInvalidParams")
	public void addressStreetNameInvalidTests(String streetName) {
		Address address = new Address("B1");
		address.setStreetName(streetName);

	}

	private Object[] addressStreetNameInvalidParams() {
		return new Object[] { 
			new Object[] { "abcd" }, 
			new Object[] { "" } 
		};
	}

	/*
	 * Login Module Unit Test
	 * Test Case 2.2.3 
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "addressStreetNameValidParams")
	public void addressStreetNameValidTests(String streetName) {
		Address address = new Address("B1");
		address.setStreetName(streetName);
		String[] expectedResult = new String[] { "B1", streetName, null, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] addressStreetNameValidParams() {
		return new Object[] { 
			new Object[] { "abcdef" }, 
		};
	}
	
	/*
	 * Login Module Unit Test
	 * Test Case 2.3.1 ~ 2.3.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "addressDistrictInvalidParams")
	public void addressDistrictInvalidTests(String district) {
		Address address = new Address("B1");
		address.setDistrict(district);
	}

	private Object[] addressDistrictInvalidParams() {
		return new Object[] { 
			new Object[] { "abcd" }, 
			new Object[] { "" } 
		};
	}

	/*
	 * Login Module Unit Test
	 * Test Case 2.3.3
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "addressDistrictValidParams")
	public void addressDistrictValidTests(String district) {
		Address address = new Address("B1");
		address.setDistrict(district);
		String[] expectedResult = new String[] { "B1", null, district, null, "0", "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] addressDistrictValidParams() {
		return new Object[] { 
			new Object[] { "abcdef" }, 
		};
	}
	
	/*
	 * Login Module Unit Test 
	 * Test Case 2.4.1 ~ 2.4.2 
	 * - Equivalence Partitioning
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	@Parameters(method = "addressAreaInvalidParams")
	public void addressAreaInvalidTests(int areaNo) {
		DeliveryCostList dcl = new DeliveryCostList("deliveryCostData.txt");
		dcl.getAreaName(areaNo);
	}

	private Object[] addressAreaInvalidParams() {
		return new Object[] { 
			new Object[] { "21" }, 
			new Object[] { "-1" } 
		};
	}

	/*
	 * Login Module Unit Test 
	 * Test Case 2.4.3
	 * - Equivalence Partitioning
	 */
	@Test
	@Parameters(method = "addressAreaValidParams")
	public void addressAreaValidTests(int areaNo, String areaName) {
		DeliveryCostList dcl = new DeliveryCostList("deliveryCostData.txt");
		String expectedResult = dcl.getAreaName(areaNo);
		assertEquals(expectedResult, areaName);
	}

	private Object[] addressAreaValidParams() {
		return new Object[] { 
			new Object[] { 10, "Kuala Sungai Baru"}, 
		};
	}
	
	
	/*
	 * Login Module Unit Test
	 * Test Case 2.5.1 ~ 2.5.2
	 * - Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	@Parameters (method = "addressPostalCodeInvalidParams")
	public void addressPostalCodeInvalidTests(int postalCode) {
		Address address = new Address("B1");
		address.setPostalCode(postalCode);
	}

	private Object[] addressPostalCodeInvalidParams() {
		return new Object[] { 
			new Object[] { 74999 },
			new Object[] { 79000 },
		};
	}
	
	/*
	 * Login Module Unit Test
	 * Unit Testing Test Case 2.5.3
	 * - Boundary Value Analysis
	 */
	@Test 
	@Parameters (method = "addressPostalCodeValidParams")
	public void addressPostalCodeValidTests(int postalCode) {
		Address address = new Address("B1");
		address.setPostalCode(postalCode);
		String[] expectedResult = new String[] { "B1", null, null, null, String.valueOf(postalCode), "Melacca" };
		String[] actualResult = address.getAddressAsArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	private Object[] addressPostalCodeValidParams() {
		return new Object[] { 
			new Object[] { 75000 }, 
			new Object[] { 78999 } 
		};
	}

}

