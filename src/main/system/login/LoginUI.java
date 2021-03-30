package system.login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import system.menu.checkout.DeliveryCost;

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
					System.out.println("Enter your choice (1-4) ---->");
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
		int status = -1;
		Member member = loginCtrl.createMember();
		String username = "";
		String password = "";
		String password2 = "";

		while (status != 0) {
			System.out.print("Enter username ----> ");
			username = scanner.nextLine();
			status = loginCtrl.setUsername(member, username);
			if (status == 1) {
				System.out.println("Username must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Username is blank!");
			}
		}

		status = -1;

		while (status != 0) {
			System.out.print("Enter password ----> ");
			password = scanner.nextLine();
			status = loginCtrl.setPassword(member, password, password);
			if (status == 1) {
				System.out.println("Password must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Password is blank!");
			}
		}

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
		int status = -1;
		Guest guest = loginCtrl.createGuest();
		Address address;
		String name = "";

		while (status != 0) {
			System.out.print("Enter your name ----> ");
			name = scanner.nextLine();
			status = loginCtrl.setName(guest, name);
			if (status == 1) {
				System.out.println("Name must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Name is blank!");
			}
		}

		address = fillAddressDets();
		loginCtrl.setAddress(guest, address);
		this.user = guest;
		System.out.printf("%n%nWelcome %s%n", this.user.getName());
	}

	public void signUp() {
		int status = -1;
		Member member = loginCtrl.createMember();
		String username = "";
		String password = "";
		String password2 = "";
		String phoneNumber = "";
		String name = "";
		Address address;

		while (status != 0) {
			System.out.print("Enter username ----> ");
			username = scanner.nextLine();
			status = loginCtrl.setUsername(member, username);
			if (status == 1) {
				System.out.println("Username must be at least 5 character long.");
			} else if (loginCtrl.searchUsername(username)) {
				status = 3;
				System.out.println("Username has been taken!");
			} else if (status == 2) {
				System.out.println("Username is blank!");
			}
		}

		status = -1;

		while (status != 0) { // expected behaviour - submit both password before checking, but if you don't
								// want you can split it
			System.out.print("Enter password ----> ");
			password = scanner.nextLine();
			System.out.print("Enter password again ----> ");
			password2 = scanner.nextLine();
			status = loginCtrl.setPassword(member, password, password2);
			if (status == 1) {
				System.out.println("Password must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Password is blank!");
			} else if (status == 3) {
				System.out.println("Password does not match!");
			}
		}

		status = -1;

		while (status != 0) {
			System.out.print("Enter your name ----> ");
			name = scanner.nextLine();
			status = loginCtrl.setName(member, name);
			if (status == 1) {
				System.out.println("Name must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Name is blank!");
			}
		}

		status = -1;

		while (status != 0) {
			System.out.print("Enter your phone number ----> ");
			phoneNumber = scanner.nextLine();
			status = loginCtrl.setPhoneNumber(member, phoneNumber);
			if (status == 1) {
				System.out.println("Phone number must be between 10-11 character long.");
			} else if (status == 2) {
				System.out.println("Phone number must be numbers only, without spaces!");
			}
		}

		address = fillAddressDets();
		loginCtrl.setAddress(member, address);
		loginCtrl.addMember(member);
		this.user = member;
		System.out.printf("%n%nWelcome %s%n", this.user.getName());
	}

	private Address fillAddressDets() {
		int status = -1;
		ArrayList<DeliveryCost> deliveryCosts = (ArrayList<DeliveryCost>) loginCtrl.getAreaList();
		Address address = loginCtrl.createAddress();
		String unitNumber = "";
		String streetName = "";
		String district = "";
		int areaCode;
		int postalCode;

		System.out.println("Please note that the address is restricted to within the Melacca state.");
		System.out.println("Kindly enter the following details:-");

		while (status != 0) {
			System.out.print("Unit Number ----> ");
			unitNumber = scanner.nextLine();
			status = loginCtrl.setUnitNumber(address, unitNumber);
			if (status == 1) {
				System.out.println("Unit number is blank!");
			}
		}

		status = -1;

		while (status != 0) {
			System.out.print("Street Name ----> ");
			streetName = scanner.nextLine();
			status = loginCtrl.setStreetName(address, streetName);
			if (status == 1) {
				System.out.println("Street name must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("Street name is blank!");
			}
		}

		status = -1;

		while (status != 0) {
			System.out.print("District ----> ");
			district = scanner.nextLine();
			status = loginCtrl.setDistrict(address, district);
			if (status == 1) {
				System.out.println("District must be at least 5 character long.");
			} else if (status == 2) {
				System.out.println("District is blank!");
			}
		}

		status = -1;

		System.out.println();
		int counter = 1;
		System.out.printf("%-5s%-20s\n", "No.", "Area");
		for (DeliveryCost dc : deliveryCosts) {
			System.out.printf("%-5d%-20s\n", counter, loginCtrl.getArea(dc));
			counter++;
		}
		System.out.println();

		while (status != 0) {
			try {
				System.out.print("Area code ----> ");
				areaCode = scanner.nextInt();
				scanner.nextLine();
				status = loginCtrl.setArea(address, areaCode);
			} catch (InputMismatchException e) {
				System.out.println("Numbers only!");
				scanner.nextLine();
			}
			if (status == 1) {
				System.out.println("Please select the numbers shown above only!");
			}
		}

		status = -1;

		while (status != 0) {
			try {
				System.out.print("Postal Code ----> ");
				postalCode = scanner.nextInt();
				scanner.nextLine();
				status = loginCtrl.setPostalCode(address, postalCode);
			} catch (InputMismatchException e) {
				System.out.println("Numbers only!");
				scanner.nextLine();
			}
			if (status == 1) {
				System.out.println("Only values between 75000-78999 is accepted.");
			}
		}

		return address;
	}

	public User getUser() {
		return this.user;
	}
}
