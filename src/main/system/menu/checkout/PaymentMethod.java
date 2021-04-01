package system.menu.checkout;

public enum PaymentMethod {
	CreditCard,
	ePayment;
	
	public PaymentMethod selectPaymentMethod(int option) {
		PaymentMethod PM;
		if (option == 1) {
			PM = PaymentMethod.CreditCard;
		} else if (option == 2) {
			PM = PaymentMethod.ePayment;
		} else {
			throw new IllegalArgumentException("Invalid selection!");
		}

		return PM;
	}
}
