package system.domain.login_module;

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

	public Address(String unitNumber) {

		if (unitNumber.isBlank())
			throw new IllegalArgumentException("Unit number must not be blank!");

		this.unitNumber = unitNumber;

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

	// validate setting street name
	public void setStreetName(String streetName) {

		if (streetName.isBlank()) {
			throw new IllegalArgumentException("Street name must not be blank!");
		} else if (streetName.length() < 5) {
			throw new IllegalArgumentException("Street name must be at least 5 character long.!");
		}

		this.streetName = streetName;

	}

	// validate setting district
	public void setDistrict(String district) {

		if (district.isBlank()) {
			throw new IllegalArgumentException("District must not be blank!");
		} else if (district.length() < 5) { // Consider < 3, since "Raub" is a valid district name
			throw new IllegalArgumentException("District must be at least 5 character long.");
		}

		this.district = district;

	}

	public void setArea(String area) {
		this.area = area;
	}

	// validate setting postal code
	public void setPostalCode(int postalCode) {

		if (postalCode < 75000 || postalCode > 78999)
			throw new IllegalArgumentException("Postal code must be between 75000 and 78999!");

		this.postalCode = postalCode;

	}
}
