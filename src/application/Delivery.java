package application;
import java.io.Serializable;

public class Delivery implements Serializable{

	// default serialVersion id
	private static final long serialVersionUID = 1L;
	
	private String area;
	private double rate;//remark use hashMap <String, double>
	
	public Delivery(String area, double rate) {
		this.area = area;
		this.rate = rate;
	}
	
	public String getArea() {
		return this.area;
	}
}

