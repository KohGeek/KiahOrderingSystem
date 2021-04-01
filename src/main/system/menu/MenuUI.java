package system.menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import system.login.User;
import system.menu.checkout.Order;
import system.menu.checkout.PaymentMethod;

public class MenuUI {

	private MenuCtrl menuCtrl;
	private Scanner scanner;

	public MenuUI(MenuCtrl menuCtrl, Scanner scanner) {
		this.menuCtrl = menuCtrl;
		this.scanner = scanner;
	}

	public void start() {

		int choice = 0;
		do {
			System.out.println("\nSelect a option to continue:- ");
			System.out.println("1. Start Ordering");
			System.out.println("2. View Cart");
			System.out.println("3. Edit Cart");
			System.out.println("4. Check out for payment");
			System.out.println("5. Exit");

			boolean inputStatus;
			do {
				try {
					System.out.print("Enter your choice (1-5) ----> ");
					choice = scanner.nextInt();
					inputStatus = true;
					scanner.nextLine();
					System.out.println("");
					if (choice < 1 || choice > 5) {
						System.out.println("Choice not within range, please try again.");
						inputStatus = false;
					}
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("\nInvalid number, please try again.");
					inputStatus = false;
				}
			} while (!inputStatus);

			switch (choice) {
			case 1:
				ordering();
				break;
			case 2:
				viewCart();
				break;
			case 3:
				editCart();
				break;
			case 4:
				checkOut();
				break;
			case 5:
				break;
			}
		} while (choice != 5);

	}

	public void ordering() {
		/*
		 * if entered itemNo is invalid ----> print invalid if entered itemNo is valid
		 * ----> add into cart if entered itemNo == 00 ----> exit the ordering
		 */
		displayItemList();
		int itemNo = 0;
		int itemQty = 0;
		Item item = null;
		boolean proceed = false;
		boolean loop = true;

		do {
			while (!proceed) {
				try {
					System.out.print("Select item ----> ");
					itemNo = scanner.nextInt();
					scanner.nextLine();
					if (itemNo == 99) {
						return; // exit menu
					}
					item = this.menuCtrl.getItemFromList(itemNo - 1);
					proceed = true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					proceed = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}

			proceed = false;

			while (!proceed) {
				try {
					System.out.print("Enter the item's quantity ----> ");
					itemQty = scanner.nextInt();
					scanner.nextLine();
					this.menuCtrl.addItem(item, itemQty);
					proceed = true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					proceed = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}
			System.out.println("Item added to the cart!\n");
			proceed = false;
		} while (loop);
	}

	public void viewCart() {
		/*
		 * if the user logged in as member getMemberPrice if the user logged in as guest
		 * getNonMemberPrice
		 */

		try {
			this.menuCtrl.checkIsCartEmpty();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return; // exit menu
		}

		double cartTotalPrice = 0;
		List<ArrayList<Object>> cartDataArr = this.menuCtrl.getCartData();

		System.out.printf("%n%-6s%-35s%12s%12s%19s%n", "No.", "Name", "Price", "Quantity", "Promotion(5% off)");
		for (ArrayList<Object> cartData : cartDataArr) {
			System.out.printf("%-6d%-35s%12.2f%12d%19s%n", cartData.toArray());
		}

		cartTotalPrice = this.menuCtrl.getCartTotalPrice();

		System.out.printf("%n%41s%12.2f\n\n", "Cart Total Price = ", cartTotalPrice);
	}

	public void editCart() {
		int itemNo = 0;
		int newQty = 0;
		Item item = null;
		boolean proceed = false;
		boolean loop = false;

		do {
			try {
				this.menuCtrl.checkIsCartEmpty();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return; // exit menu
			}
			while (!proceed) {
				try {
					viewCart();
					System.out.print("Enter the item number to be edited ----> ");
					itemNo = scanner.nextInt();
					scanner.nextLine();
					item = this.menuCtrl.getCartItem(itemNo - 1);
					proceed = true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					proceed = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}

			proceed = false;

			while (!proceed) {
				try {
					System.out.print("Enter the new quantity of the item ----> ");
					newQty = scanner.nextInt();
					scanner.nextLine();
					this.menuCtrl.editItem(item, newQty);
					proceed = true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					proceed = false;
				} catch (InputMismatchException e) {
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}

			System.out.println("\n--------Cart updated!--------");
			proceed = false;

			int choice;
			while (!proceed) {
				try {
					viewCart();
					System.out.println("Continue editing cart?");
					System.out.println("1 - Continue.");
					System.out.println("00 - Back to the menu.");
					System.out.print("----> ");
					choice = scanner.nextInt();
					scanner.nextLine();
					System.out.println("");
					if (choice == 00) {
						proceed = true;
						loop = false;
					} else if (choice == 1) {
						proceed = true;
						loop = true;
					} else {
						System.out.println("Choice not within range, please try again.");
						proceed = false;
					}
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}
			proceed = false;
		} while (loop);
	}

	public void checkOut() {
		/*
		 * Proceeding checkout User information:- Name: Delivery Address:
		 * 
		 * #viewCart()
		 * 
		 * Delivery Fee: Total Price:
		 * 
		 * 1. Make Payment 2. Back to Menu
		 */

		try {
			this.menuCtrl.checkIsCartEmpty();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return; // exit menu
		}

		User user = this.menuCtrl.getUser();
		Order order = this.menuCtrl.getOrder();

		System.out.println("Proceeding checkout.");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("User information:- ");
		System.out.printf("Name: %s\n", this.menuCtrl.getName(user));
		System.out.printf("Delivery Address: %s\n\n", this.menuCtrl.getAddress(user));
		System.out.println("Cart Items:-");
		viewCart();
		System.out.printf("Delivery Fee: %.2f\n", this.menuCtrl.getDeliveryFee(order));
		System.out.printf("Total Price: %.2f\n\n", this.menuCtrl.getTotalPrice(order));
		System.out.println("-----------------------------------------------------------------------");

		int choice = 0;
		boolean proceed = false;

		while (!proceed) {
			try {
				System.out.println("Select an option (1-2):-");
				System.out.println("1. Make Payment");
				System.out.println("2. Back to Menu");
				System.out.print("----> ");
				choice = scanner.nextInt();
				scanner.nextLine();
				proceed = true;
				if (choice != 1 && choice != 2) {
					System.out.println("Invalid choice.");
					proceed = false;
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Input must be numerical only.");
				proceed = false;
			}
		}

		proceed = false;
		String msg = "";
		PaymentMethod PM = PaymentMethod.CreditCard;
		if (choice == 1) {
			while (!proceed) {
				try {
					System.out.println("1. Pay with CreditCard.");
					System.out.println("2. Pay with ePayment.");
					System.out.print("Select payment method ----> ");
					choice = scanner.nextInt();
					scanner.nextLine();
					PM = PM.selectPaymentMethod(choice);
					msg = this.menuCtrl.makePayment(PM);
					proceed = true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					proceed = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Input must be numerical only.");
					proceed = false;
				}
			}

			System.out.println(msg);
			System.out.println("Thank you for using Kiah Ordering System.");
			System.exit(0);

		} else if (choice == 2) {
			return;
		}

	}

	private void displayItemList() {

		System.out.printf("%-6s%-35s%12s%17s%19s%n", "No.", "Name", "MemberPrice", "nonMemberPrice",
				"Promotion(5% off)");

		List<ArrayList<Object>> itemDataList = this.menuCtrl.getItemData();
		for (ArrayList<Object> itemData : itemDataList) {
			System.out.printf("%-6d%-35s%12s%17s%19s%n", itemData.toArray());
		}
		System.out.println("99    Exit\n");
	}
}
