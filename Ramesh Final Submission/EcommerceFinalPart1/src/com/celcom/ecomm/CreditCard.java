package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCard implements Payment {
	String cn,name,cvv,status,exp1,query3,cn1,name1,cvv1;
	   PreparedStatement psmt2;
	   Date exp;
	   Connection con;
	   CreditCard(Connection con){
		   this.con=con;
	   }
	   
		@Override
		public void paymentDetails() {
			Scanner scn=new Scanner(System.in);
			System.out.println("Enter Credit Card Number");
			cn1=scn.next();
			if(Pattern.matches("[0-9]+{12}", cn1)) {
				cn=cn1;
			}else {
				System.out.println("Invalid card Number");
				System.exit(0);
			}
			System.out.println("Enter Name on Card FirstnameSurname");
			name1=scn.next();
			if(Pattern.matches("[A-Za-z][A-Za-z]+", name1)) {
				name=name1;
			}else {
				System.out.println("Invalid name");
				System.exit(0);
			}
			System.out.println("Enter Expiry Date yyyy-MM-dd");
			exp1=scn.next();
			exp=Date.valueOf(exp1);
			//System.out.println((exp.getMonth()+1)+"/"+exp.getYear());
			//System.out.println(exp);
			System.out.println("Enter CVV");
			cvv1=scn.next();
			if(Pattern.matches("[0-9]+{3}", cvv1)) {
				cvv=cvv1;
			}else {
				System.out.println("Invalid cvv Number");
				System.exit(0);
			}
			query3="insert into customer_paymentdetails_ramesh (cardNumber,name,expiryDate,cvv,status) values"
					+ "(?,?,?,?,?)";
			if(cn!=null&&name!=null&&cvv!=null) {
				status="InActive";
				try {
					psmt2=con.prepareStatement(query3);
					psmt2.setString(1, cn);
					psmt2.setString(2, name);
					psmt2.setDate(3, exp);
					psmt2.setString(4,cvv);
					psmt2.setString(5,status);
					psmt2.executeUpdate();
					System.out.println("card details saved sucessfully");
				} catch (SQLException e) {
					System.out.println("Error in saving credit card details..."+e);
				}finally {
					try {
						psmt2.close();
					} catch (SQLException e) {
						System.out.println("Resource leakage creditcard  saving ...."+e);
					}
				}
					
			}
		}

}
