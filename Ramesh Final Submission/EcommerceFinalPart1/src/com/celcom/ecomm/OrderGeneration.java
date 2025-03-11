package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderGeneration {
	static Connection con;
	String admin;
	int ops;
	static Scanner sc = new Scanner(System.in);
	static {
	/*	String url = "jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com";
		String userName = "training";
		String pwd = "Celcom123";
		try {
			con = DriverManager.getConnection(url, userName, pwd);
			System.out.println("Connection Sucessfull!!");
		} catch (SQLException e) {
			System.out.println("Error in connection to oracle DB" + e);
			e.printStackTrace();
		}*/
		DBConnection db=new DBConnection(con);
		con=db.dbConnection();
	}

	public void createTables() {
		// Tables Created
		//order_place_ramesh,upiPaymentdetails_ramesh,order_place_upi_ramesh
		// customer_ecomm_ramesh,producdetails_ecomm_ramesh,customer_paymentdetails_ramesh,upiPaymentdetails_ramesh,orders_ecomm_ramesh
		System.out.println("Enter Admin users name");
		admin = sc.next();
		if (admin.equalsIgnoreCase("Ramesh")) {
			Products p = new Products(con);
			System.out.println("Do you want to add products 1-Yes 2-No");
			ops = sc.nextInt();
			switch (ops) {
			case 1:
				p.insertProducts();
				break;
			case 2:
				System.out.println("you don't want to add product so exiting");
				System.exit(0);
				break;
			default:
				System.out.println("No option selected");
				System.exit(0);
			}
		} else {
			System.out.println("Invalid Admin username...please try again");
		}
	}

	public static void main(String[] args) {
		int opt;
		Customer c = new Customer(con);
		OrderGeneration o = new OrderGeneration();
		Products ps = new Products(con);
		PlaceOrder po = new PlaceOrder(con);
		System.out.println("Welcome!!!");
		while (true) {
			System.out.println("Select your option");
			System.out.println("\n1-Add Customer\n2-Show Products\n3-Place Order\n4-Exit");
			opt = sc.nextInt();
			switch (opt) {
			case 0:
				o.createTables();
				break;
			case 1:
				c.addCustomer();
				break;
			case 2:
				ps.showProducts();
				break;
			case 3:
				po.placeOrder();
				break;
			case 4:
				System.out.println("You choice to exit");
				System.exit(1);
			default:
				System.out.println("No option selected");

			}
		}

	}

}
