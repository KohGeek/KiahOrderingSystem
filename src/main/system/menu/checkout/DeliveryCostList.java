package system.menu.checkout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import system.file.IDatabase;
import system.menu.IDelivery;

public class DeliveryCostList implements IDelivery, IDatabase {

	private List<DeliveryCost> deliveryInfo;

	public DeliveryCostList(String fileName) {
		this.deliveryInfo = new ArrayList<DeliveryCost>();
		initDataFromFile(fileName);
	}

	@Override
	public List<DeliveryCost> getAreaList() {
		return this.deliveryInfo;
	}

	@Override
	public String getAreaName(int areaCode) {
		areaCode--; // needed because input starts from 1, not 0
		if (areaCode >= 0 && areaCode < deliveryInfo.size())
			return this.deliveryInfo.get(areaCode).getArea();
		else
			return "";
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

	@Override
	public void initDataFromFile(String fileName) {
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
	public void updateDataToFile(String fileName) {
		// TODO Auto-generated method stub

	}
}
