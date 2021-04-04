package system.login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import system.payment.DeliveryCost;

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

			boolean inputCorrect = false;
			while (!inputCorrect) {
				try {
					System.out.print("Enter your choice (1-4) ----> ");
					choice = scanner.nextInt();
					scanner.nextLine();
					inputCorrect = true;
				} catch (InputMismatchException e) {
					System.out.println("Input is not a number, please try again.");
					scanner.nextLine();
				}
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
				break;
			default:
				System.out.println("\nInput must be within 1-4.\n");
			}
		} while (this.user == null);
	}

	public void login() {
		String username = "";
		String password = "";

		System.out.print("Enter username ----> ");
		username = scanner.nextLine();

		System.out.print("Enter password ----> ");
		password = scanner.nextLine();
		
		try {
			user = this.loginCtrl.getMember(username, password);
			System.out.printf("%n%nWelcome back %s%n", this.user.getName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void guestLogin() {
		boolean status = false;
		Guest guest = null;
		Address address;
		String name = "";

		while (!status) {
			try {
				System.out.print("Enter your name ----> ");
				name = scanner.nextLine();
				guest = loginCtrl.createGuest(name);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		address = fillAddressDets();
		loginCtrl.setAddress(guest, address);
		this.user = guest;
		System.out.printf("%n%nWelcome %s%n", this.user.getName());
	}

	public void signUp() {
		boolean status = false;
		Member member = null;
		String username = "";
		String password = "";
		String password2 = "";
		String phoneNumber = "";
		String name = "";
		Address address;

		while (!status) {
			try {
				System.out.print("Enter username ----> ");
				username = scanner.nextLine();
				member = loginCtrl.createMember(username);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("Enter password ----> ");
				password = scanner.nextLine();
				System.out.print("Enter password again ----> ");
				password2 = scanner.nextLine();
				loginCtrl.setPassword(member, password, password2);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("Enter your name ----> ");
				name = scanner.nextLine();
				loginCtrl.setName(member, name);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("Enter your phone number ----> ");
				phoneNumber = scanner.nextLine();
				loginCtrl.setPhoneNumber(member, phoneNumber);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		address = fillAddressDets();
		loginCtrl.setAddress(member, address);
		loginCtrl.addMember(member);

		this.user = member;
		System.out.printf("%n%nWelcome %s%n", this.user.getName());
	}

	private Address fillAddressDets() {
		boolean status = false;
		ArrayList<DeliveryCost> deliveryCosts = (ArrayList<DeliveryCost>) loginCtrl.getAreaList();
		Address address = null;
		String unitNumber = "";
		String streetName = "";
		String district = "";
		int areaNo;
		int postalCode;

		System.out.println("Please note that the address is restricted to within the Melacca state.");
		System.out.println("Kindly enter the following details:-");

		while (!status) {
			try {
				System.out.print("Unit Number ----> ");
				unitNumber = scanner.nextLine();
				address = loginCtrl.createAddress(unitNumber);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("Street Name ----> ");
				streetName = scanner.nextLine();
				loginCtrl.setStreetName(address, streetName);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("District ----> ");
				district = scanner.nextLine();
				loginCtrl.setDistrict(address, district);
				status = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		System.out.println();
		int noCounter = 1;
		System.out.printf("%-5s%-20s\n", "No.", "Area");
		for (DeliveryCost dc : deliveryCosts) {
			System.out.printf("%-5d%-20s\n", noCounter, loginCtrl.getArea(dc));
			noCounter++;
		}
		System.out.println();

		while (!status) {
			try {
				System.out.print("Area code ----> ");
				areaNo = scanner.nextInt();
				scanner.nextLine();
				loginCtrl.setArea(address, areaNo);
				status = true;
			} catch (InputMismatchException e) {
				System.out.println("Input must be numerical only!");
				scanner.nextLine();
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}

		status = false;

		while (!status) {
			try {
				System.out.print("Postal Code ----> ");
				postalCode = scanner.nextInt();
				scanner.nextLine();
				loginCtrl.setPostalCode(address, postalCode);
				status = true;
			} catch (InputMismatchException e) {
				System.out.println("Input must be numerical only!");
				scanner.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		return address;
	}

	public User getUser() {
		return this.user;
	}
}
