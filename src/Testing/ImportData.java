package Testing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import application.*;

public class ImportData {

	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	private static ArrayList<HashMap<String, Double>> deliveryRateList = new ArrayList<HashMap<String, Double>>();

	public static void main(String[] args) {
		try {
			createUser();
			createItem();
			File userobj = new File("userData.txt");
			ObjectOutputStream userobjout = new ObjectOutputStream(new FileOutputStream(userobj));
			userobjout.writeObject(userList);

			File itemobj = new File("itemData.txt");
			ObjectOutputStream itemobjout = new ObjectOutputStream(new FileOutputStream(itemobj));
			itemobjout.writeObject(userList);

			userobjout.close();
			itemobjout.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void createUser() {
		try {
			Scanner x = new Scanner(new File("userDatax.txt"));
			x.useDelimiter("[,\n]");
			String username, password, phoneNumber, name;
			int unitNumber, postalCode;
			String streetName, district, area;

			while (x.hasNext()) {
				username = x.next();
				password = x.next();
				phoneNumber = x.next();
				name = x.next();
				unitNumber = Integer.parseInt(x.next());
				streetName = x.next();
				district = x.next();
				area = x.next();
				postalCode = Integer.parseInt(x.next());
				x.next();

				userList.add(new User(username, password, phoneNumber, name,
						new Address(unitNumber, streetName, district, area, postalCode)));
			}
		} catch (Exception e) {
			System.out.println("userDatax.txt has error!");
		}
	}

	public static void createItem() {
		try {
			Scanner x = new Scanner(new File("itemDatax.txt"));
			x.useDelimiter("[,\n]");
			String name, type;
			double memberPrice, nonMemberPrice;
			boolean isPromotional;

			while (x.hasNext()) {
				name = x.next();
				type = x.next();
				memberPrice = Double.parseDouble(x.next());
				nonMemberPrice = Double.parseDouble(x.next());
				isPromotional = Boolean.parseBoolean(x.next());

				itemList.add(new Item(name, type, memberPrice, nonMemberPrice, isPromotional));

			}
		} catch (Exception e) {
			System.out.println("itemDatax.txt has error!");
		}
	}

	public static void createOrder() {
		try {
			Scanner x = new Scanner(new File("orderDatax.txt"));
			x.useDelimiter("[,\n]"); // special delimiter
			int id;
			User user;
			String deliveryAddress;
			HashMap<Item, Integer> purchaseList;
			double deliveryfee, totalPrice;
			int i = 0;

			while (x.hasNext()) {
				id = Integer.parseInt(x.next());
				user = userList.get(i);
				deliveryAddress = userList.get(i).getAddress().getFullAddress();

			}
		} catch (Exception e) {
			System.out.println("itemDatax.txt has error!");
		}
	}

}
