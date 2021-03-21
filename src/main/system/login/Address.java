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
}
