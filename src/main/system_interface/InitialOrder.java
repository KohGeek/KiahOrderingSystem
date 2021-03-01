package system_interface;

public interface InitialOrder {

	public int generateOrderID();

	public void computeTotalPrice();

	public Address verifyDeliveryAddress();

	public void setPaymentDetails();

	abstract void setDeliveryAddress();

	public double getDeliveryFee();
}
