package system.login;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginUI {

	private LoginCtrl loginCtrl;
	private Scanner scanner;
	private User user;

	public LoginUI(LoginCtrl loginCtrl, Scanner scanner) {
		this.loginCtrl = loginCtrl;
		this.scanner = scanner;
	}

	public void start() {
		int choice = 1;
		do {
			System.out.println("This is the Login Menu");
			System.out.println("1. Already a member");
			System.out.println("2. Continue as a Guest");
			System.out.println("3. Sign up");
			System.out.println("4. Exit");

			choice = validateInt("Enter your choice (1-4) ----> ", scanner, 1, 4);

			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				guestLogin();
				break;
			case 3:
				signUp();
				break;
			case 4:
				System.out.println("Thank you for using Kiah Ordering System.");
				System.exit(0);
			}
		} while (this.user == null);
	}

	public void login() {
		String username = validate("Enter username ----> ", scanner, 0, 0);
		String password = validate("Enter password ----> ", scanner, 0, 0);
		boolean VAL = loginCtrl.validateMember(username, password);
		if (!VAL) {
			this.user = null;
			System.out.println("The username or password is invalid!!\n\n");
		} else if (VAL) {
			this.user = loginCtrl.getMember(username);
			System.out.printf("%n%nWelcome back %s%n", this.user.getName());
		}
	}

	public void guestLogin() {
		String name = validate("Enter your name ----> ", scanner, 0, 0);
		Address address = fillAddressDets();
		this.user = new Guest(name, address);
		System.out.printf("%n%nWelcome %s%n", this.user.getName());
	}

	public void signUp() {
		String username = validate("Enter a username ----> ", scanner, 0, 0);
		boolean usernameTaken = loginCtrl.searchUsername(username);
		if (usernameTaken) {
			this.user = null;
			System.out.println("This username has been taken.");
			System.out.println("Please try again.\n");
		} else if (!usernameTaken) {
			String password;
			boolean passwordMatch;
			do {
				passwordMatch = true;
				password = validate("Enter a password ----> ", scanner, 0, 0);
				String password2 = validate("Re-enter the password ----> ", scanner, 0, 0);
				if (!password.contentEquals(password2)) {
					System.out.println("Those password didn't match. Try again.");
					passwordMatch = false;
				}
			} while (!passwordMatch);

			System.out.println("Kindly enter the following details:-");
			String name = validate("Name ----> ", scanner, 0, 0);
			String phoneNumber = validate("Phone Number (ex: 0129876543) ----> ", scanner, 10, 11);
			Address address = fillAddressDets();
			Member member = new Member(username, password, phoneNumber, name, address);
			loginCtrl.addMember(member);
			this.user = member;
		}
	}

	private Address fillAddressDets() {
		System.out.println("Please note that the address is restricted to within the Melacca state.");
		System.out.println("Kindly enter the following details:-");
		String unitNumber = validate("Unit number ----> ", scanner, 0, 0);
		String streetName = validate("Street name ----> ", scanner, 5, 0);
		String district = validate("District ----> ", scanner, 0, 0);
		System.out.print("Area (0~x) ----> "); // TODO ask for area but with a list of numbers
		String area = scanner.nextLine(); // TODO this isn't going to be NextLine
		int postalCode = validateInt("Postal code ----> ", scanner, 75000, 78999);
		return new Address(unitNumber, streetName, district, area, postalCode);
	}

	public User getUser() {
		return this.user;
	}

	private String validate(String prompt, Scanner scanner, int minlength, int maxlength) {
		boolean exceptionThrown;
		String inputData;

		do {
			exceptionThrown = false;
			System.out.print(prompt);
			inputData = scanner.nextLine();

			if (inputData.isBlank()) {
				exceptionThrown = true;
				System.out.println("Input is empty! Please try again.");
			} else if (minlength != 0 && inputData.length() < minlength) {
				exceptionThrown = true;
				System.out.printf("Input must at least be %d char long. Please try again. \n", minlength);
			} else if (maxlength != 0 && inputData.length() > maxlength) {
				exceptionThrown = true;
				System.out.printf("Input must at most be %d char long. Please try again. \n", maxlength);
			}

		} while (exceptionThrown);

		return inputData;
	}

	private int validateInt(String prompt, Scanner scanner, int min, int max) {
		boolean exceptionThrown;
		String inputData;
		int integer = 0;

		do {
			exceptionThrown = false;
			System.out.print(prompt);
			inputData = scanner.nextLine();

			if (inputData.isBlank()) {
				exceptionThrown = true;
				System.out.println("Input is empty! Please try again.");
			} else {
				try {
					integer = Integer.parseInt(inputData);
					if (integer < min || integer > max) {
						exceptionThrown = true;
						System.out.printf("Input must be between %d and %d. Please try again. \n", min, max);
					}
				} catch (NumberFormatException e) {
					// e.printStackTrace();
					exceptionThrown = true;
					System.out.println("Input is not a number! Please try again.");
				}
			}

		} while (exceptionThrown);

		return integer;
	}
}
