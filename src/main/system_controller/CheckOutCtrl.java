package system_controller;

import system_entity.PurchaseList;
import system_entity.User;
import system_interface.InitialOrder;
import system_interface.aPayment;

public class CheckOutCtrl {

	private InitialOrder order;
	private aPayment payment;
	private User User;
	private PurchaseList purchaseList;

	public void displayCheckOutDetails() {

	}

	public void makePayment() {

	}

	public void exitSystem() {

	}

	public CheckOutCtrl(User user, PurchaseList purchaseList) {
		User $user = user;
		PurchaseList $purchaseList = purchaseList;

		this.User = $user;
		this.purchaseList = $purchaseList;
	}

}
