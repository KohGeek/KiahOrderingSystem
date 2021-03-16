package system.menu.checkout;

import java.util.ArrayList;
import java.util.List;

import system.file.IDatabase;
import system.menu.IDelivery;

public class DeliveryCostList implements IDelivery, IDatabase {

	private List<DeliveryCost> deliveryInfo;

	public DeliveryCostList(String fileName) {
		this.deliveryInfo = new ArrayList<DeliveryCost>();
		initDataFromFile(fileName);
	}

	@Override
	public double getRate(String area) {
		double rate = 0;
		for (int i = 0; i < this.deliveryInfo.size(); i++)
			if (this.deliveryInfo.get(i).getArea() == area) {
				rate = (this.deliveryInfo.get(i)).getRate();
				break;
			}
		return rate;
	}

	@Override
	public void initDataFromFile(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDataToFile(String fileName) {
		// TODO Auto-generated method stub

	}
}
