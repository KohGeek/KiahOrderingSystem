package system_ui;

import system_controller.MenuCtrl;
import system_entity.PurchaseList;

public class SystemMenuUI {

	private MenuCtrl menu;
	private PurchaseList purchaseList;

	public void displayMenuOptions() {
		System.out.println("This is the Menu.");
		System.out.println("1. Ordering Item\t2. View Cart\t3. Check out\t4. Exit\n");
	}

	public boolean validateOption(int option) {
		int $option = option;
		if ($option >= 1 || $option <= 4) {
			return true;
		} else {
			System.out.println("Entered option is invalid.\n");
			return false;
		}
	}
	
	public void selectMenuOption(int option) {
		int $$option = option;

		switch ($$option) {
		case 1:
			menu.orderItem();
			break;
		case 2:
			menu.viewCart();
			break;
		case 4:
			menu.exitSystem();
			break;
		}
	}

	public SystemMenuUI() {
		this.menu = new MenuCtrl();
		this.purchaseList = new PurchaseList();
	}

	public PurchaseList getPurchaseList() {
		return this.purchaseList;
	}

}
