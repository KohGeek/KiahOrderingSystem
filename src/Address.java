
public class Address {

	private int unitNumber;
	private String streetName;
	private String district;
	private String area;
	private int postalCode;
	private String state;
	
	
	public Address(int unitNumber, String streetName, String district, String area, int postalCode, String state) {
		
		this.unitNumber = unitNumber;
		this.streetName = streetName;
		this.district = district;
		this.area = area;
		this.postalCode = postalCode;
		this.state = state;
		
	}
		
	
	public String getArea() {
		
		return this.area;
		
	}
	
	public String getFullAddress() {
		
		return this.unitNumber + "," + this.streetName + "," + this.district + "," + this.area + "," + this.postalCode + "," + this.state;
	}
	
	
		
	
}
