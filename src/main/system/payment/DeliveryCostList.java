package system.payment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import system.menu.IDelivery;

public class DeliveryCostList implements IDelivery {

	private List<DeliveryCost> deliveryInfo;

	public DeliveryCostList(String fileName) {
		this.deliveryInfo = new ArrayList<DeliveryCost>();
		String $filename = fileName;
		try {
			Scanner s = new Scanner(new File($filename));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				this.deliveryInfo.add(new DeliveryCost(s.next(), s.nextDouble()));
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DeliveryCost> getAreaList() {
		return this.deliveryInfo;
	}

	@Override
	public String getAreaName(int areaNo) {

		if (areaNo < 0 || areaNo >= deliveryInfo.size())
			throw new IndexOutOfBoundsException("Please select the numbers shown above only!");

		return this.deliveryInfo.get(areaNo).getArea();

	}

	@Override
	public double getRate(String area) {
		double rate = 0;
		for (int i = 0; i < this.deliveryInfo.size(); i++)
			if (area.equals(this.deliveryInfo.get(i).getArea())) {
				rate = (this.deliveryInfo.get(i)).getRate();
				break;
			}
		return rate;
	}
}
