package system_main;

import system_ui.SystemCheckOutUI;
import system_ui.SystemLoginUI;
import system_ui.SystemMenuUI;

public class OrderingSystem {

	private static SystemLoginUI loginUI;
	private static SystemMenuUI menuUI;
	private static SystemCheckOutUI checkOutUI;

	public static void main(String[] args) {
		loginUI = new SystemLoginUI();

		boolean loginStatus = false;
		do {
			loginUI.loginOptions();
			loginStatus = loginUI.selectLoginOption();
		} while (loginStatus != true);

		menuUI = new SystemMenuUI();
		checkOutUI = new SystemCheckOutUI();

		int menuOption;
		do {
			menuUI.menuOptions();
			menuOption = menuUI.selectMenuOption();

			if (menuOption == 3) {
				checkOutUI.checkOut(loginUI, null);
			}

		} while (menuOption != 4);

	}
}
