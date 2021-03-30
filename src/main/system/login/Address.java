package system.login;

public class Address {

	private String unitNumber;
	private String streetName;
	private String district;
	private String area;
	private int postalCode;
	private String state = "Melacca";

	public Address(String unitNumber, String streetName, String district, String area, int postalCode) {
		this.unitNumber = unitNumber;
		this.streetName = streetName;
		this.district = district;
		this.postalCode = postalCode;
		this.area = area;
	}

	public Address() {

	}

	public String getArea() {
		return this.area;
	}

	public String getFullAddress() {
		return this.unitNumber + ", " + this.streetName + ", " + this.district + ", " + this.area + ", "
				+ this.postalCode + ", " + this.state;
	}

	public String[] getAddressAsArray() {
		return new String[] { this.unitNumber, this.streetName, this.district, this.area,
				String.valueOf(this.postalCode), this.state };
	}

	// validate setting unit number
	// 0 : successful
	// 1 : empty/whitespace only
	public int setUnitNumber(String unitNumber) {

		int status = 0;

		if (unitNumber.isBlank()) {
			status = 1;
		} else {
			status = 0;
			this.unitNumber = unitNumber;
		}

		return status;
	}

	// validate setting street name
	// 0 : successful
	// 1 : too short
	// 2 : only whitespace characters
	public int setStreetName(String streetName) {
		int status = 0;

		if (streetName.isBlank()) {
			status = 2;
		} else if (streetName.length() < 5) {
			status = 1;
		} else {
			status = 0;
			this.streetName = streetName;
		}

		return status;
	}

	// validate setting district
	// 0 : successful
	// 1 : too short
	// 2 : only whitespace characters
	public int setDistrict(String district) {
		int status = 0;

		if (district.isBlank()) {
			status = 2;
		} else if (district.length() < 5) { // Consider < 3, since "Raub" is a valid district name
			status = 1;
		} else {
			status = 0;
			this.district = district;
		}

		return status;
	}

	public void setArea(String area) {
		this.area = area;
	}

	// validate setting postal code
	// 0 : successful
	// 1 : out of range
	public int setPostalCode(int postalCode) {
		int status = 0;

		if (postalCode < 75000 || postalCode > 78999) {
			status = 1;
		} else {
			status = 0;
			this.postalCode = postalCode;
		}

		return status;
	}
}
