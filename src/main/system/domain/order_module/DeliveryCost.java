package system.domain.order_module;

public class DeliveryCost {

	private String area;
	private double rate;

	public DeliveryCost(String area, double rate) {
		this.area = area;
		this.rate = rate;
	}

	public String getArea() {
		return this.area;
	}

	public double getRate() {
		return this.rate;
	}
}