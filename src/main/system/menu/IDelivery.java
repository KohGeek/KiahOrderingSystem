package system.menu;

import java.util.List;

import system.menu.checkout.DeliveryCost;

public interface IDelivery {

	public double getRate(String area);

	public String getAreaName(int areaCode);

	public List<DeliveryCost> getAreaList();

}
