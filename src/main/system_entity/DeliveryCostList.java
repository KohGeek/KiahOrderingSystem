package system_entity;

import java.util.ArrayList;

import system_interface.aDelivery;

public class DeliveryCostList implements aDelivery {

	private ArrayList<DeliveryCost> deliveryCostList;

	public DeliveryCostList() {
		this.deliveryCostList = deliveryCostList;
	}

	@Override
	public double getRate(String area) {
		double rate = 0;
		for (int i = 0; i < deliveryCostList.size(); i++) {
			if (this.deliveryCostList.get(i).getArea() == area) {

				rate = (this.deliveryCostList.get(i)).getRate();
			}
		}
		return rate;
	}
}
