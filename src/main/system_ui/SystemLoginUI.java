package system_ui;

import system_controller.EntryCtrl;
import system_entity.User;

public class SystemLoginUI {

	private EntryCtrl entry;
	public User user;

	public void displayLoginOptions() {
		System.out.println("This is the Login Menu");
		System.out.println("1. Already a member\t2. Login as a Guest\t3. Sign up\n");
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

	public void selectLoginOption(int option) {
		int $$option = option;

		switch ($$option) {
		case 1:
			this.user = entry.login();
			break;
		case 2:
			this.user = entry.guestLogin();
			break;
		case 3:
			this.user = entry.signUp();
			break;
		case 4:
			entry.exitSystem();
			break;
		}
	}

	public SystemLoginUI() {
		this.entry = new EntryCtrl();
	}
	
	public User getUser() {
		return this.user;
	}
}
