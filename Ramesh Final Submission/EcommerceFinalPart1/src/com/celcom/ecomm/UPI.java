package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UPI implements Payment {
    String upiID,query4,status="InActive";
    PreparedStatement psmt3;
    Scanner sc=new Scanner(System.in);
    Connection con;
    public UPI(Connection con) {
		this.con=con;
	}

	@Override
	public void paymentDetails() {
		System.out.println("Enter upi id same as email");
    	upiID=sc.next();
    	query4="insert into upiPaymentdetails_ramesh (upiId,status) values (?,?)";
    	if(upiID!=null) {
    		try {
				psmt3=con.prepareStatement(query4);
				psmt3.setString(1, upiID);
				psmt3.setString(2, status);
				psmt3.executeUpdate();
				System.out.println("UPI details added sucessfully");
			} catch (SQLException e) {
				System.out.println("Error in saving UPI details"+e);
			}
    		
    	}
		
	}

}
