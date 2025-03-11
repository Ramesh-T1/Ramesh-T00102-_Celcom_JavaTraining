package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderPaymentStatus extends Thread{
	Connection con;
	int orderId,odid;
	String status;
	OrderPaymentStatus(Connection con,int orderId){
		this.con=con;
		this.orderId=orderId;
	}

	public void run() {
		//If this statement is written outside run method is not getting executed
		String od="Select STATUS,ORDERID from orders_ecomm_ramesh where ORDERID=?";
		try(PreparedStatement psp=con.prepareStatement(od)){
			try {
				psp.setInt(1, orderId);
				ResultSet rsp=psp.executeQuery();
				while(rsp.next()) {
					status=rsp.getString(1);
					odid=rsp.getInt(2);
					if(status.equals("InProgress")) {
						System.out.println("Order is InProgress "+odid);
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else if(status.equals("PendingPayment")) {
						System.out.println("Order is in Pending Payment "+odid);
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else if(status.equals("Order Sucess")) {
						System.out.println("Order is Sucessfully placed "+odid);
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.exit(1);
					}else if(status.equals("Order Failed")) {
						System.out.println("Order failed "+odid);
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.exit(1);
					}
				}
			}catch (SQLException e) {
				System.out.println("Error in updating messages......"+e);
			}
			
		} catch (SQLException e) {
			System.out.println("Error in updating status messages......."+e);
			e.printStackTrace();
		}

	}

}
