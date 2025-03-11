package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Products {

	PreparedStatement stmt1;
	String cq3,cq4;
	Connection con;
	Statement stmt2;
	ResultSet rs=null;
	Products(Connection con) {
		this.con = con;
	}

	public void insertProducts() {
		String prdname, category;
		double price;
		int qty, n, i, pid = 0,v=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("You entered into ADDING Products");
		System.out.println("Enter no.of items you want to add");
		n = sc.nextInt();
		for (i = 1; i <= n; i++) {
			System.out.println("Enter Product name");
			prdname = sc.next();
			System.out.println("Enter Product category e.g Electronics,Clothing etc");
			category = sc.next();
			System.out.println("Enter price per qty");
			price = sc.nextDouble();
			System.out.println("Enter Stock qty");
			qty = sc.nextInt();
			pid = (int) (Math.floor(Math.random() * 10000)) + v++;
			cq3 = "insert into producdetails_ecomm_ramesh (pid,name,category,price,stockqty) values (?,?,?,?,?)";
			try {

				stmt1 = con.prepareStatement(cq3);
				stmt1.setInt(1, pid);
				stmt1.setString(2, prdname);
				stmt1.setString(3, category);
				stmt1.setDouble(4, price);
				stmt1.setInt(5, qty);
				stmt1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}/* finally {
				try {
					stmt1.close();
				} catch (SQLException e) {
					System.out.println("Resource leak....ogpi" + e);
				}
			}*/
		}

	}
	public void showProducts() {
		cq4="select * from producdetails_ecomm_ramesh";
		try {
			stmt2=con.createStatement();
			rs=stmt2.executeQuery(cq4);
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("Pid\t\tName\t\tCategory\t\tPrice\t\tQty");
			System.out.println("---------------------------------------------------------------------------------------------------");
			while(rs.next()) {	
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4)+"\t\t"+rs.getInt(5));
				System.out.println("---------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println("Error in showing products...."+e);
		}
		
	}
}
