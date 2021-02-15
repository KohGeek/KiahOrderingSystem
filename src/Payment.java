
public class Payment {

	enum Method{
		CreditCard, OnlineBanking;
	}
	
	private Order order; //waiting for Beh
	private Method paymentMethod;
	private double totalPrice;
	private boolean paymentStatus;
	
	public Payment(Order order, Method paymentMethod, double totalPrice, boolean paymentStatus) {
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus; //TBC for driver and stub
	}
}
