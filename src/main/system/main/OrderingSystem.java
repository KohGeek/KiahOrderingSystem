package system.main;

import java.util.Scanner;

import system.login.*;
import system.menu.*;
import system.menu.checkout.*;

public class OrderingSystem {

	public static void main(String[] args) {	
		/*
		 * Section 1: Login (login as Guest or Member is required before proceed to next
		 * Section)
		 * Section 2: Menu
		 */

		System.out.println("Welcome to Kiah Ordering System.");

		Scanner scanner = new Scanner(System.in);
		IDelivery deliveryInfo = new DeliveryCostList("deliveryCostData.txt");
		IMember memberList = new MemberList("memberData.txt");
		LoginCtrl loginCtrl = new LoginCtrl(memberList, deliveryInfo);
		LoginUI login = new LoginUI(loginCtrl, scanner);
		login.start();

		User user = login.getUser();
		ICart cart = new Cart();
		Order order = new Order(user, cart);
		IItem itemList = new ItemList("itemData.txt");
		MenuCtrl menuCtrl = new MenuCtrl(order, itemList, deliveryInfo);
		MenuUI menu = new MenuUI(menuCtrl, scanner);
		menu.start();

		System.out.println("Thank you for using Kiah Ordering System.");
	}
}
