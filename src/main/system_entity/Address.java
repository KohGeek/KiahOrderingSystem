package system_entity;

public class Address {

	private int unitNumber;
	private String streetName;
	private String district;
	private String area;
	private int postalCode;
	private String state = "Melacca";

	public Address(int unitNumber, String streetName, String district, String area, int postalCode) {
		this.unitNumber = unitNumber;
		this.streetName = streetName;
		this.district = district;
		this.postalCode = postalCode;
		this.area = area;
	}

	public String getArea() {
		return this.area;
	}

	// Returns human-readable format of address data as a single String
	public String getFullAddress() {
		return this.unitNumber + ", " + this.streetName + ", " + this.district + ", " + this.area + ", "
				+ this.postalCode + ", " + this.state;
	}

	// getAddressAsArray() - TEMPORARY
	// Return type: String array
	// Returns all the 6 individual data point as a String array - for file IO
	// TODO put this into EA
	public String[] getAddressAsArray() {
		return new String[] { String.valueOf(this.unitNumber), this.streetName, this.district, this.area,
				String.valueOf(this.postalCode), this.state };
	}
}
