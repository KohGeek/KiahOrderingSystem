package system.domain.payment_module;

import system.domain.order_module.Order;

public interface IPayment {
	public void makePayment(Order order);
}
