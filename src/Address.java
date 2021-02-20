
public class Address {

	private String area;
	private String district;
	private int postalCode;
	private String state;
	private String streetName;
	private int unitNumber;
	
	public Address(String area, String district, int postalCode, String state, String streetName, int unitNumber) {
		
		this.area = area;
		this.district = district;
		this.postalCode = postalCode;
		this.state = state;
		this.streetName = streetName;
		this.unitNumber = unitNumber;
		
	}
		
	
	public String getArea() {
		
		return area;
		
	}
	
	Address getAddress() {
		
		return new Address (area, district, postalCode, state, streetName, unitNumber);
	}
	
	
		
	
}
