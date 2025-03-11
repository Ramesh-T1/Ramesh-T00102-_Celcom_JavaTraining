package com.celcom.ecomm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {
	String firstName,lastName,fn, ln,mobno, mb,email, em,address, pm,query1,acno;
	int o,i;
	Connection con;

	public Customer(Connection con) {
		this.con = con;
	}

	Scanner scm = new Scanner(System.in);

	public void addCustomer() {
		System.out.println("Enter your First Name");
		fn = scm.next();
		// System.out.println(Pattern.matches("[A-Z][a-z]+","Ramesh"));
		if (Pattern.matches("[A-Z][a-z]+", fn)) {
			firstName = fn;
		} else {
			System.out.println("Invalid first name");
			System.exit(o);
		}
		// System.out.println(firstName);
		System.out.println("Enter your Last Name");
		ln = scm.next();
		if (Pattern.matches("[A-Z][a-z]+", ln)) {
			lastName = ln;
		} else {
			System.out.println("Invalid last name");
			System.exit(o);
		}
		System.out.println("Enter your Mobile Number");
		mb=scm.next();
		if (Pattern.matches("[0-9]+{10}", mb)) {
			mobno = mb;
		} else {
			System.out.println("Invalid mobile number");
			System.exit(o);
		}
		// System.out.println(mb);
		System.out.println("Enter your email");
		em = scm.next();
		if (Pattern.matches("[a-z0-9_\\W]+@gmail.com", em)) {
			email = em;
		} else {
			System.out.println("Invalid email");
			System.exit(o);
		}
		// System.out.println(email);
		System.out.println("Enter your address");
		address = scm.next();
		System.out.println("Enter Payment Mode");
		System.out.println("\n1-DebitCard\n2-CreditCard\n3-UPI");
		o = scm.nextInt();
		Payment dc = new DebitCard(con);
		Payment cd = new CreditCard(con);
		UPI u=new UPI(con);
		switch (o) {
		case 1:
			dc.paymentDetails();
			pm = "DebitCard";
			break;
		case 2:
			cd.paymentDetails();
			pm = "CreditCard";
			break;
		case 3:u.paymentDetails();
		      pm="UPI";  
		      break;
	    default:System.out.println("No Payment mode selected...exiting");
	             System.exit(0);
		}
		List<String> allLines;
		query1 = "insert into customer_ecomm_ramesh (accountNumber,firstName,lastName,mobno,email,address,pm) values (?,?,?,?,?,?,?)";
		PreparedStatement psmt = null;
		if (firstName != null && lastName != null && mobno != null && email != null && address != null && pm != null) {
			//acno = "ABC" + (int) (Math.floor(Math.random() * 10000)) + i++;
			acno = "ABC" + (int) (Math.floor(Math.random() * 10000));
			try {
				allLines = Files.readAllLines(Paths.get("D:\\Java training_jdk17\\EcommerceFinalPart1\\accountnumber.txt"));
				for(String line:allLines) {
					if(acno.equals(line)) {
						acno = "ABC" + (int) (Math.floor(Math.random() * 10000));
						//FileWriter fw=new FileWriter("D:\\Java training_jdk17\\EcommerceFinalPart1\\accountnumber.txt");
						//fw.write(acno);
					}
						
				}
				FileWriter fw=new FileWriter("D:\\Java training_jdk17\\EcommerceFinalPart1\\accountnumber.txt",true);
				fw.write("\n"+acno);
				fw.close();				
			} catch (IOException e) {
				System.out.println("Error in reading DB credentials " + e);
				e.printStackTrace();
			}
			
			try {
				psmt = con.prepareStatement(query1);
				psmt.setString(1, acno);
				psmt.setString(2, firstName);
				psmt.setString(3, lastName);
				psmt.setString(4, mobno);
				psmt.setString(5, email);
				psmt.setString(6, address);
				psmt.setString(7, pm);
				psmt.executeUpdate();
				System.out.println("Customer added sucessfully");
				System.out.println(firstName+" Your account number "+acno);
			} catch (SQLException e) {
				System.out.println("Error in insertion in table customer_ecomm_ramesh" + e);
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					System.out.println("Resource leakage cg...." + e);
				}
			}

		}
	}

	

}
