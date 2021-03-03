package system_main;

import system_entity.Input;
import system_ui.SystemCheckOutUI;
import system_ui.SystemLoginUI;
import system_ui.SystemMenuUI;

public class OrderingSystem {

	private static SystemLoginUI loginUI;
	private static SystemMenuUI menuUI;
	private static SystemCheckOutUI checkOutUI;

	public static void main(String[] args) {

		System.out.println("Welcome to Kiah Ordering System.");

		Input input = new Input();
		loginUI = new SystemLoginUI();

		int option;
		boolean optionVAL;
		do {
			loginUI.displayLoginOptions();
			option = Integer.parseInt(input.getInput("Select your option ----> "));
			optionVAL = loginUI.validateOption(option);
			while (optionVAL == true)
				loginUI.selectLoginOption(option);
		} while (optionVAL == false);

		menuUI = new SystemMenuUI();
		do {
			menuUI.displayMenuOptions();
			option = Integer.parseInt(input.getInput("Select your option ----> "));
			optionVAL = menuUI.validateOption(option);
			while (optionVAL == true)
				if (option == 1 || option == 2)
					menuUI.selectMenuOption(option);
				else if (option == 3) {
					checkOutUI = new SystemCheckOutUI(loginUI.getUser(), menuUI.getPurchaseList());
					do {
						checkOutUI.displayCheckOutOptions();
						option = Integer.parseInt(input.getInput("Select your option ----> "));
						optionVAL = checkOutUI.validateOption(option);
						while (optionVAL == true)
							checkOutUI.selectCheckOutOptions(option);
					} while (optionVAL == false);
				}
		} while (optionVAL == false);

		System.out.println("Thank you for using Kiah Ordering System.");
	}
}
