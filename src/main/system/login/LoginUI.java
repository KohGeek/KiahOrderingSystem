package system.login;

import java.util.Scanner;

public class LoginUI {

	private LoginCtrl loginCtrl;
	private Scanner scanner;
	private User user;

	public LoginUI(LoginCtrl loginCtrl) {
		this.loginCtrl = loginCtrl;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		int choice;
		do {
			System.out.println("This is the Login Menu");
			System.out.println("1. Already a member");
			System.out.println("2. Continue as a Guest");
			System.out.println("3. Sign up");
			System.out.println("4. Exit");

			System.out.println("Enter your choice (1-4) ----> ");
			choice = scanner.nextInt();
			scanner.nextLine();

			while (choice < 1 || choice > 4) {
				System.out.println("Invalid choice.");
				// Clear ENTER key after integer input
				scanner.nextLine();
			}

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
		System.out.println("Enter username ----> ");
		String username = scanner.nextLine();
		System.out.println("Enter password ----> ");
		String password = scanner.nextLine();
		boolean VAL = loginCtrl.validateMember(username, password);
		if (!VAL) {
			this.user = null;
			System.out.println("The username or password is invalid!!");
		}
		else if (VAL) {
			this.user = loginCtrl.getMember(username);
			System.out.printf("Welcome back %s\n", this.user.getName());
		}
	}

	public void guestLogin() {
		System.out.println("Enter your name ----> ");
		String name = scanner.nextLine();
		Address address = fillAddressDets();
		this.user = new Guest(name, address);
	}

	public void signUp() {
		System.out.println("Enter a username ----> ");
		String username = scanner.nextLine();
		boolean VAL = loginCtrl.searchUsername(username);
		if (!VAL) {
			this.user = null;
			System.out.println("This username has been taken.");
		}
		else if (VAL) {
			String password;
			boolean passwordMatch = true;
			do {
				System.out.println("Enter a password ----> ");
				password = scanner.nextLine();
				System.out.println("Re-enter the password ----> ");
				String password2 = scanner.nextLine();
				while (password != password2) {
					System.out.println("Those password didn't match. Try again.");
				}
			} while (!passwordMatch);

			System.out.println("Kindly enter the following details:-");
			System.out.println("Name ----> ");
			String name = scanner.nextLine();
			System.out.println("Phone Number ----> ");
			String phoneNumber = scanner.nextLine();
			Address address = fillAddressDets();
			Member member = new Member(username, password, name, phoneNumber, address);
			loginCtrl.addMember(member);
			this.user = member;
		}
	}

	private Address fillAddressDets() {
		System.out.println("Please note that the address is restricted to within the Melacca state.");
		System.out.println("Kindly enter the following details:-");
		System.out.println("Unit number ----> ");
		int unitNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Street name ----> ");
		String streetName = scanner.nextLine();
		System.out.println("District ----> ");
		String district = scanner.nextLine();
		System.out.println("Area (0~x) ----> "); // TODO ask for area but with a list of numbers
		String area = scanner.nextLine();
		System.out.println("Postal code ----> ");
		int postalCode = scanner.nextInt();
		scanner.nextLine();
		return new Address(unitNumber, streetName, district, area, postalCode);
	}

	public User getUser() {
		return this.user;
	}
}
