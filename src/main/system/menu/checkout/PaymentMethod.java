package system.menu.checkout;

public enum PaymentMethod {
	CreditCard,
	ePayment;
	
	public PaymentMethod selectPaymentMethod(int option) {
		PaymentMethod PM;
		if (option == 1) {
			PM = CreditCard;
		} else if (option == 2) {
			PM = ePayment;
		} else {
			throw new IllegalArgumentException("Invalid selection!");
		}

		return PM;
	}
}
