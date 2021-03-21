package system.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import system.login.Guest;
import system.login.Member;
import system.login.User;
import system.menu.checkout.Order;

public class MenuUI {

	private MenuCtrl menuCtrl;
	private Scanner scanner;

	public MenuUI(MenuCtrl menuCtrl, Scanner scanner) {
		this.menuCtrl = menuCtrl;
		this.scanner = scanner;
	}

	public void start() {

		menuCtrl.setDeliveryFee(this.menuCtrl.getUser().getAddress().getArea());

		int choice;
		do {
			System.out.println("\nSelect a option to continue:- ");
			System.out.println("1. Start Ordering");
			System.out.println("2. View Cart");
			System.out.println("3. Edit Cart");
			System.out.println("4. Check out for payment");
			System.out.println("5. Exit");

			System.out.print("Enter your choice (1-5) ----> ");
			choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println("");

			while (choice < 1 || choice > 5) {
				System.out.println("Invalid choice.");
				System.out.print("Enter your choice (1-5) ----> ");
				choice = scanner.nextInt();
				// Clear ENTER key after integer input
				scanner.nextLine();
			}

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
		 * if entered itemNo is invalid
		 * ----> print invalid
		 * if entered itemNo is valid
		 * ----> add into cart
		 * if entered itemNo == 00
		 * ----> exit the ordering
		 */
		displayItemList();
		int itemNo;
		int itemQty;
		int itemListSize = this.menuCtrl.getItemListSize();
		Item item;
		do {
			System.out.print("Select item ----> ");
			itemNo = scanner.nextInt();
			if (itemNo == 00)
				break;
			else if (itemNo < 1 || itemNo > itemListSize)
				System.out.println("Selected invalid item.\n");
			else if (itemNo >= 1 || itemNo <= itemListSize) {
				item = this.menuCtrl.getItem(itemNo);
				System.out.print("Enter the item's quantity ----> ");
				itemQty = scanner.nextInt();
				this.menuCtrl.addItem(item, itemQty);
				System.out.println("Item added to the cart!\n");
			}
		} while (itemNo != 00);
	}

	public void viewCart() {
		/*
		 * if the user logged in as member
		 * getMemberPrice
		 * if the user logged in as guest
		 * getNonMemberPrice
		 */

		while (this.menuCtrl.getOrder().getCart().getCartSize() == 0) {
			System.out.println("You have not added item yet.");
			return;
		}
		
		System.out.printf("%-6s%-35s%12s%12s%19s%n", "No.", "Name", "Price", "Quantity", "Promotion(5% off)");

		HashMap<Item, Integer> cart = this.menuCtrl.getCart();
		int i = 1;
		double cartTotalPrice = 0;
		String isPromotion = "";
		User user = this.menuCtrl.getUser();
		for (Entry<Item, Integer> item : cart.entrySet()) {
			if (item.getKey().getIsPromotional() == true)
				isPromotion = "Yes";
			else if (item.getKey().getIsPromotional() == false)
				isPromotion = "No";

			if (user instanceof Member)
				System.out.printf("%-6s%-35s%12.2f%12d%19s%n", i, item.getKey().getName(),
						item.getKey().getMemberPrice(), item.getValue(), isPromotion);
			else if (user instanceof Guest)
				System.out.printf("%-6s%-35s%12.2f%12d%19s%n", i, item.getKey().getName(),
						item.getKey().getNonMemberPrice(), item.getValue(), isPromotion);
			i++;
		}
		if (user instanceof Member)
			cartTotalPrice = this.menuCtrl.getCartTotalPrice(true);
		else if (user instanceof Guest)
			cartTotalPrice = this.menuCtrl.getCartTotalPrice(false);

		System.out.printf("%n%41s%12.2f\n\n", "Cart Total Price = ", cartTotalPrice);
	}

	public void editCart() {
		int choice;
		int newQty;
		Item item;
		while (this.menuCtrl.getOrder().getCart().getCartSize() == 0) {
			System.out.println("You have not added item yet.");
			return;
		}
		
		boolean repeat = true;
		do {
			viewCart();
			System.out.print("Enter the item number to be editted ----> ");
			choice = scanner.nextInt();
			if (choice < 1 || choice > this.menuCtrl.getCartSize())
				System.out.println("Invalid item number!! Try again.\n");
			else {
				item = this.menuCtrl.getItem(choice);
				System.out.print("Enter the new quantity of the item ----> ");
				newQty = scanner.nextInt();
				scanner.nextLine();
				this.menuCtrl.editItem(item, newQty);
				System.out.println("\n--------Cart updated!--------");
				viewCart();
				System.out.println("Continue editing cart?");
				System.out.println("1 - Continue.");
				System.out.println("00 - Back to the menu.");
				System.out.print("----> ");
				choice = scanner.nextInt();
				scanner.nextLine();
				System.out.println("");
				if (choice == 00)
					repeat = false;
			}
		} while (repeat);
	}

	public void checkOut() {
		/*
		 * Proceeding checkout
		 * User information:-
		 * Name:
		 * Delivery Address:
		 * 
		 * #viewCart()
		 * 
		 * Delivery Fee:
		 * Total Price:
		 * 
		 * 1. Make Payment
		 * 2. Back to Menu
		 */
		User user = this.menuCtrl.getUser();
		Order order = this.menuCtrl.getOrder();

		while (order.getCart().getCartSize() == 0) {
			System.out.println("You have not added item yet.");
			return;
		}
		System.out.println("Proceeding checkout.");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("User information:- ");
		System.out.printf("Name: %s\n", user.getName());
		System.out.printf("Delivery Address: %s\n\n", user.getAddress().getFullAddress());
		System.out.println("Cart Items:-");
		viewCart();
		System.out.printf("Delivery Fee: %.2f\n", order.getDeliveryFee());
		System.out.printf("Total Price: %.2f\n\n", order.getTotalPrice());
		System.out.println("-----------------------------------------------------------------------");

		int choice;
		do {
			System.out.println("Select an option (1-2):-");
			System.out.println("1. Make Payment");
			System.out.println("2. Back to Menu");
			System.out.print("----> ");
			choice = scanner.nextInt();
			scanner.nextLine();
			while (choice < 1 || choice > 2) {
				System.out.println("Invalid choice.");
				System.out.println("Select an option (1-2) ----> ");
				choice = scanner.nextInt();
				// Clear ENTER key after integer input
				scanner.nextLine();
			}
			if (choice == 1) {
				order.getPaymentDetails().makePayment(order);
				System.out.println("Payment has successful!");
				System.out.println("Thank you for using Kiah Ordering System.");
				System.exit(0);
			}
		} while (choice != 2);
	}

	private void displayItemList() {
		List<Item> item = this.menuCtrl.getItemList();
		System.out.printf("%-6s%-35s%12s%17s%19s%n", "No.", "Name", "MemberPrice", "nonMemberPrice",
				"Promotion(5% off)");
		String isPromotion = "";
		for (int i = 0; i < item.size(); i++) {
			if (item.get(i).getIsPromotional() == true) {
				isPromotion = "Yes";
			} else if (item.get(i).getIsPromotional() == false) {
				isPromotion = "No";
			}
			System.out.printf("%-6d%-35s%12.2f%17.2f%19s%n", i + 1, item.get(i).getName(), item.get(i).getMemberPrice(),
					item.get(i).getNonMemberPrice(), isPromotion);

		}
		System.out.println("00    Exit\n");
	}
}
