package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Address implements Serializable {

	// default serialVersion id
	private static final long serialVersionUID = 1L;

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
		this.state = "Malacca";
	}

	public Address(ArrayList<String> details) {
		this.unitNumber = Integer.parseInt(details.get(0));
		this.streetName = details.get(1);
		this.district = details.get(2);
		this.area = details.get(3);
		this.postalCode = Integer.parseInt(details.get(4));
		this.state = "Malacca";
	}

	public String getFullAddress() {
		return this.unitNumber + "," + this.streetName + "," + this.district + "," + this.area + "," + this.postalCode
				+ "," + this.state;
	}

	public String getArea() {
		return this.area;
	}
}
