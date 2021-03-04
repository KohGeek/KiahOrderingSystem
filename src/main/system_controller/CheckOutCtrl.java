package system_controller;

import system_entity.PurchaseList;
import system_entity.User;
import system_interface.InitialOrder;
import system_interface.aPayment;

public class CheckOutCtrl {

	private InitialOrder order;
	private aPayment payment;
	private User user;
	private PurchaseList purchaseList;

	public void displayCheckOutDetails() {
	}

	public void makePayment() {
		
	}

	public void exitSystem() {
		System.out.println("Thank you for using Kiah Ordering System.");
		exitSystem();
	}

	public CheckOutCtrl(User user, PurchaseList purchaseList) {
		User $user = user;
		PurchaseList $purchaseList = purchaseList;

		this.user = $user;
		this.purchaseList = $purchaseList;
	}

}
