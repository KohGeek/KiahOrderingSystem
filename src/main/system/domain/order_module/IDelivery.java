package system.domain.order_module;

import java.util.List;

public interface IDelivery {

	public double getRate(String area);

	public String getAreaName(int areaCode);

	public List<DeliveryCost> getAreaList();

}
