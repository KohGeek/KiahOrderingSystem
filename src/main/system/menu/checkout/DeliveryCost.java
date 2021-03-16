package system.menu.checkout;

import java.util.ArrayList;

public class DeliveryCost {

	private String area;
	private double rate;
	private ArrayList<DeliveryCost> deliveryCostList;

	public DeliveryCost(String area, double rate) {

		this.area = area;
		this.rate = rate;

	}

	public String getArea() {

		for (int i = 0; i < deliveryCostList.size(); i++) {
			area = this.deliveryCostList.get(i).getArea();
		}

		return area;
	}

	public double getRate() {

		for (int i = 0; i < deliveryCostList.size(); i++) {
			rate = this.deliveryCostList.get(i).getRate();
		}

		return rate;
	}
}