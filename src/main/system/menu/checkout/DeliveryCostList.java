package system.menu.checkout;

import java.util.ArrayList;
import java.util.List;

import system.file.IDatabase;
import system.menu.IDelivery;

public class DeliveryCostList implements IDelivery, IDatabase {

	private List<DeliveryCost> deliveryCostList;

	public DeliveryCostList(String fileName) {
		this.deliveryCostList = new ArrayList<DeliveryCost>();
		initDataFromFile(fileName);
	}

	@Override
	public double getRate(String area) {
		double rate = 0;
		for (int i = 0; i < deliveryCostList.size(); i++)
			if (this.deliveryCostList.get(i).getArea() == area)
				rate = (this.deliveryCostList.get(i)).getRate();
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
