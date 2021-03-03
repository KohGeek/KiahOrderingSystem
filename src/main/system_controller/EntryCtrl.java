package system_controller;

import system_entity.Input;
import system_entity.User;
import system_interface.IMember;
import system_interface.aUser;
import system_ui.SystemLoginUI;

public class EntryCtrl {

	private User user;
	private SystemMenuUI menu; // TODO remove
	private IMember memberList;

	public void login() {
		Input input = new Input();
		String username = input.getInput("Username ----> ");
		String password = input.getInput("Password ----> ");
		boolean found = memberList.validateMember(username, username);
		if (found != true) {
			System.out.println("Invalid username or password.");
		} else if (found == true) {
			this.user = memberList.getMember(username);
		}

	}

	public void guestLogin() {

	}

	public void signUp() {

	}

	public void exitSystem() {

	}

	public User getUser() {

		return null;
	}

	public EntryCtrl() {

	}
}
