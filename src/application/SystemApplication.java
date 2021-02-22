package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SystemApplication {


	private static Scanner scanner = new Scanner(System.in);
	private static User user;
	private static ArrayList<User> userList;
	private static ArrayList<Item> itemList;
	private static HashMap<Item, Integer> purchaseList;
	private static HashMap<String, Double> deliveryRateList;

	@SuppressWarnings("unused")
	private static boolean isMember; // pending

	public static void main(String[] args) {
		
		final String userFile = "userData.txt";
		final String itemFile = "itemData.txt";
		final String deliveryFile = "deliveryData.txt";
		userList = new ArrayList<User>();
		itemList = new ArrayList<Item>();
		purchaseList = new HashMap<Item, Integer>();
		deliveryRateList = new HashMap<String, Double>();

		importDeliveryRateList(deliveryRateList, deliveryFile);
		importItemList(itemList, itemFile);
		importUserList(userList, userFile);

		System.out.println("Welcome to MsKiah Online Ordering System!");

		int choice;
		do {
			System.out.print(
					"1. Already a member.\n2. Continue as a Guest.\n3. Register an account. your selection ---->");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter username: ");
				String username = scanner.nextLine();
				System.out.println("Enter password: ");
				String password = scanner.nextLine();
				user = new User(username, password);
				boolean validateStatus = user.verifyMember(userList);
				if (validateStatus == true) {
					user.setUser(userList); // transfer user data
					isMember = true;
				} else {
					System.out.println("Invalid username or password.");
					choice = 0;
				}
				break;
			case 2:
				System.out.println("Delivery limited in Malacca area.");
				System.out.println("Guest is required to provide name and delivery address.");
				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				System.out.println("Enter delivery address: ");
				ArrayList<String> addressDetails = new ArrayList<String>();
				askForAddressDetails(deliveryRateList);
				Address address = new Address(addressDetails);
				user = new User(name, address);
				isMember = false;
				break;
			case 3:
				user = user.signUp(userFile);
				if (user != null)
					isMember = true;
				break;
			}
		} while (choice < 1 || choice > 3);

		int item;
		int qty;
		do {
			viewItemList(itemList);
			System.out.print("Pick your item ----> ");
			item = scanner.nextInt();

			if (item != 00) {
				System.out.print("Item quantity ----> ");
				qty = scanner.nextInt();
				addItem(item, qty, itemList, purchaseList);
				System.out.print(itemList.get(item).getName() + " x" + qty + " has added into the cart.");
				clearScreen();
			}
		} while (item != 00);

		do {
			System.out.print("1. Open Item Menu.\n2. View Cart.\n3. Check-out ---->");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				do {
					viewItemList(itemList);
					System.out.print("Pick your item ----> ");
					item = scanner.nextInt();

					if (item != 00) {
						System.out.print("Item quantity ----> ");
						qty = scanner.nextInt();
						addItem(item, qty, itemList, purchaseList);
						System.out.print(itemList.get(item).getName() + " x" + qty + " has added into the cart.");
						clearScreen();
					}
				} while (item != 00);
				break;
			case 2:
				String decision;
				do {
					viewCart();
					System.out.print("Do you want to edit cart? (Y/N)");
					decision = scanner.nextLine();
					if (decision == "Y")
						editCart();
					clearScreen();
				} while (decision != "N");
				break;
			case 3:
				viewCart();
				checkOut();

			}
		} while (choice < 1 || choice > 3);

	}

	@SuppressWarnings("unchecked")
	public static void importUserList(ArrayList<User> userList, String userFile)
			throws FileNotFoundException, IOException {
		// import userlist from file
		try {
			File file = new File(itemFile);
			ObjectInputStream objin = new ObjectInputStream(new FileInputStream(file));
			itemList = (ArrayList<Item>) objin.readObject();
			objin.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static void importItemList(ArrayList<Item> itemList, String itemFile)
			throws FileNotFoundException, IOException {
		// import itemList from file
		try {
			File file = new File(itemFile);
			ObjectInputStream objin = new ObjectInputStream(new FileInputStream(file));
			itemList = (ArrayList<Item>) objin.readObject();
			objin.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static void importDeliveryRateList(HashMap<String, Double> deliveryRateList, String deliveryFile)
			throws FileNotFoundException, IOException {
		// import itemList from file
		try {
			File file = new File(deliveryFile);
			ObjectInputStream objin = new ObjectInputStream(new FileInputStream(file));
			deliveryRateList = (HashMap<String, Double>) objin.readObject();
			objin.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewItemList(ArrayList<Item> itemList) {
		// Printout the itemList
	}

	public static void addItem(int item, int qty, ArrayList<Item> itemList, HashMap<Item, Integer> purchaseList) {
		if (purchaseList.containsKey(itemList.get(item))) {
			Integer currentQty = purchaseList.get(itemList.get(item));
			purchaseList.put(itemList.get(item), currentQty + qty);
		} else {
			purchaseList.put(itemList.get(item), qty);
		}
	}

	public static void viewCart(HashMap<Item, Integer> purchaseList) {
		// print cart item
	}

	public static void editCart(int item, int qty, HashMap<Item, Integer> purchaseList) {
		// edit cart. ex: add or reduce item quantity, if quantity == 0, remove the
		// item.
	}

	public static void checkOut(User user, Order order, HashMap<Item, Integer> purchaseList) {
		// something goes with payment here.
	}

	public static ArrayList<String> askForAddressDetails(HashMap<String, Double> deliveryRateList) {
		// ask for addressDetails
		// unitNumber, streetName, district, area, postalCode, state
		// when come to "area" question, a list of valid area fetch from HashMap and
		// displays for user to select.
		// state is fixed to Malacca, no need to ask
		ArrayList<String> details = new ArrayList<String>();

		return details;
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
