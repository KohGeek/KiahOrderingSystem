package system_controller;

import system_entity.Address;
import system_entity.Guest;
import system_entity.Input;
import system_entity.Member;
import system_entity.MemberList;
import system_interface.IMember;

// EntryController Class

public class EntryCtrl {

	private IMember memberList;

	public Member login() {
		Input input = new Input();
		String username = input.getInput("Username ----> ");
		String password = input.getInput("Password ----> ");
		boolean isVerified = memberList.verifyMember(username, password);
		if (isVerified == false) {
			System.out.println("Invalid username or password.");
		} else if (isVerified == true) {
			return memberList.getMember(username);
		}
		return null;
	}

	// Starts the login process for guests
	public Guest guestLogin() {
		Input i = new Input();
		String name = i.getInput("Please enter your name: ");
		System.out.println("Please note that addresses are restricted to within the Melacca state.");
		Address address = fillAddressDets();
		return new Guest(name, address);
	}

	// Starts the registration/sign up process for people looking to be members
	public Member signUp() {
		Input i = new Input();
		String username;
		boolean found;
		do {
			username = i.getInput("Enter your username: ");

			found = memberList.searchUsername(username);
			if (found == true)
				System.out.println("Username has been taken.\n");
		} while (found == true);

		String password;
		String passwordVAL;
		boolean match = false;
		do {
			password = i.getInput("Please enter your password (Case sensitive): ");
			passwordVAL = i.getInput("Please enter your password again (Case sensitive): ");
			if (password != passwordVAL) {
				System.out.println("\nPassword does not match, please try again! \n");
				match = false;
			} else if (password == passwordVAL) {
				match = true;
			}
		} while (match == false);
	
		String name = i.getInput("Enter your name: ");
		String phoneNumber = i.getInput("Enter your phone number: ");
		System.out.println("Please note that addresses are restricted to within the Melacca state.");
		Address address = fillAddressDets();
		Member newMember = new Member(username, password, name, phoneNumber, address);
		memberList.addMember(newMember);
		return newMember;
	}

	// exits the system?
	public void exitSystem() {
		System.out.println("Thank you for using Kiah Ordering System.");
		exitSystem();
	}

	// Starts the process of obtaining address from user
	// TODO find a better way for address input? Maybe under an address interface
	private Address fillAddressDets() {

		int $unitNumber;
		String $streetName;
		String $district;
		String $area;
		int $postalCode;

		Input i = new Input();

		$unitNumber = Integer.parseInt(i.getInput("Please key in your unit number: "));
		$streetName = i.getInput("Please key in your street name: ");
		$district = i.getInput("Please key in your district: ");

		// TODO ask for area but with a list of numbers

		$area = i.getInput("Please key in your area: ");

		$postalCode = Integer.parseInt(i.getInput("Please key in your postal code: "));

		return new Address($unitNumber, $streetName, $district, $area, $postalCode);

	}

	// initialises the member list
	public EntryCtrl() {
		memberList = new MemberList("Data/newMemberData.txt");
	}
}
