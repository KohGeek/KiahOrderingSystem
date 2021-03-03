package system_ui;

import system_entity.User;
import system_controller.CheckOutCtrl;
import system_entity.PurchaseList;

public class SystemCheckOutUI {

	private CheckOutCtrl checkOut;
	private User user;
	private PurchaseList purchaseList;

	public void checkOut(User user, PurchaseList purchaseList) {

	}

	public void displayCheckOutOptions() {
		System.out.println("This is the Check out menu.");
		System.out.println("1. Make Payment\t2. Back to Menu\t3. Exit\n");

	}
	
	public boolean validateOption(int option) {
		int $option = option;
		if ($option == 1 || $option == 2) {
			return true;
		} else {
			System.out.println("Entered option is invalid.\n");
			return false;
		}
	}

	public void selectCheckOutOptions(int option) {
		int $option = option;

		switch ($option) {
		case 1:
			checkOut.makePayment();
			break;
		case 3:
			checkOut.exitSystem();
			break;
		}
	}

	public SystemCheckOutUI(User user, PurchaseList purchaseList) {
		User $user = user;
		PurchaseList $purchaseList = purchaseList;
		this.user = $user;
		this.purchaseList = $purchaseList;
	}

}
