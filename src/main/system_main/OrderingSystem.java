package system_main;

public class OrderingSystem {

	private static SystemLoginUI loginUI;
	private static SystemMenuUI menuUI;
	private static SystemCheckOutUI checkOutUI;

	public static void main(String[] args) {
		loginUI = new SystemLoginUI;
		
		boolean loginStatus = false;
		do {
			loginUI.loginOptions();
			loginStatus = loginUI.selectLoginOption();
		}while(loginStatus != true);
		
		menuUI = new SystemMenuUI;
		checkOutUI = new SystemCheckOutUI;
		
		int menuOption = false;
		do {
			menuUI.menuOptions();
			menuOption = menuUI.selectMenuOption();
			if (menuOption == 3)
				checkOutUI.checkOut(loginUI.getUser,menuUI.getPurchaseList());
		}while(menuOption != 4);

	}

}
