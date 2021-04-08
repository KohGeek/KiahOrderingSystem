package system.main;

import java.util.Scanner;

import system.boundary.LoginUI;
import system.boundary.MenuUI;
import system.controller.LoginCtrl;
import system.controller.MenuCtrl;
import system.domain.item_module.*;
import system.domain.login_module.*;
import system.domain.order_module.DeliveryCostList;
import system.domain.order_module.IDelivery;
import system.domain.order_module.Order;
import system.domain.payment_module.*;

public class OrderingSystem {

	public static void main(String[] args) {	
		/*
		 * Section 1: Login (login as Guest or Member is required before proceed to next
		 * Section)
		 * testing username: user1111
		 * testing password: pass1111
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
		Order order = new Order(user, deliveryInfo, "orderIDData.txt");
		IItem itemList = new ItemList("itemData.txt");
		ProceedPayment pPayment = new ProceedPayment();
		MenuCtrl menuCtrl = new MenuCtrl(order, itemList, pPayment);
		MenuUI menu = new MenuUI(menuCtrl, scanner);
		menu.start();

		System.out.println("Thank you for using Kiah Ordering System.");
		
		// TODO: save the files
	}
}
