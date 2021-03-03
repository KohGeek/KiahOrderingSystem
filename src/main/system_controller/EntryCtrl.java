package system_controller;

import system_entity.Address;
import system_entity.Guest;
import system_entity.Input;
import system_entity.Member;
import system_entity.MemberList;
import system_entity.User;
import system_interface.IMember;
import system_ui.SystemLoginUI;

// EntryController Class

public class EntryCtrl {

	private User user;
	// private SystemMenuUI menu; // TODO remove
	private IMember memberList;

	// login()
	// Return type: void
	// Starts the login process for members
	public void login() {

		String $username;
		String $password;
		boolean isVerified = false;
		Input i = new Input();

		do {
			$username = i.getInput("Please enter your username (Case sensitive): ");
			$password = i.getInput("Please enter your password (Case sensitive): ");

			if (memberList.verifyMember($username, $password)) {
				isVerified = true;
				this.user = memberList.getMember($username);
			} else {
				System.out.println("\nWrong username or password! Please try again. \n");
			}

		} while (!isVerified);

	}

	// guestLogin()
	// Return type: void
	// Starts the login process for guests
	public void guestLogin() {

		String $name;
		Address $address;

		Input i = new Input();

		$name = i.getInput("Please enter your name: ");
		System.out.println("Please note that addresses are restricted to within the Melacca state.");
		$address = obtainAddressFromUserInput();
		this.user = new Guest($name, $address);

	}

	// signUp()
	// Return type: void
	// Starts the registration/sign up process for people looking to be members
	public void signUp() {

		String $username;
		String $password;
		String $passwordVerify;
		String $name;
		String $phoneNumber;
		Address $address;

		Member m;

		Input i = new Input();

		boolean isUsernameTaken = true;
		boolean isMatchPassword = false;

		do {

			$username = i.getInput("Please enter your desired username (Case sensitive): ");

			if (memberList.searchUsername($username)) {
				System.out.println("\nUsername has already been taken, please try again! \n");
			} else {
				isUsernameTaken = false;
			}

		} while (isUsernameTaken);

		do {

			$password = i.getInput("Please enter your password (Case sensitive): ");
			$passwordVerify = i.getInput("Please enter your password again (Case sensitive): ");

			if ($password != $passwordVerify) {
				System.out.println("\nPassword does not match, please try again! \n");
			} else {
				isMatchPassword = true;
			}

		} while (!isMatchPassword);

		$name = i.getInput("Please enter your name: ");
		$phoneNumber = i.getInput("Please enter your phone number: ");
		System.out.println("Please note that addresses are restricted to within the Melacca state.");
		$address = obtainAddressFromUserInput();

		m = new Member($username, $password, $name, $phoneNumber, $address);
		memberList.addMember(m);
		this.user = m;

	}

	// exitSystem()
	// Return type: void
	// exits the system?
	public void exitSystem() {

	}

	// Constructor
	// initialises the member list
	public EntryCtrl() {

		memberList = new MemberList("Data/newMemberData.txt");

	}

	// getUser()
	// Return type: User object
	// returns the current user instance as an object
	public User getUser() {

		return this.user;

	}

	// PRIVATE
	// obtainAddressFromUserInput()
	// Return type: Address object
	// Starts the process of obtaining address from user
	// TODO find a better way for address input? Maybe under an address interface
	private Address obtainAddressFromUserInput() {

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

}
