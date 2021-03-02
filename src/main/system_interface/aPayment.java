package system_interface;

import system_entity.Order;
import system_entity.PayMethod;
import system_entity.PayStatus;

public interface aPayment {

	public void makePayment(Order order, int payOptio);

}
