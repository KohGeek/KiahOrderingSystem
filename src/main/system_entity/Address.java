package system_entity;

public class Address {

	private int unitNumber;
	private String streetName;
	private String district;
	private String area;
	private int postalCode;
	private String state;

	public Address(int unitNumber, String streetName, String district, int postalCode, String area) {
		this.unitNumber = unitNumber;
		this.streetName = streetName;
		this.district = district;
		this.postalCode = postalCode;
		this.area = area;
		this.state = "Melaka";
	}

	public String getFullAddress() {

		// TODO return something real
		return null;
	}

	public String getArea() {

		return area;

	}

}
