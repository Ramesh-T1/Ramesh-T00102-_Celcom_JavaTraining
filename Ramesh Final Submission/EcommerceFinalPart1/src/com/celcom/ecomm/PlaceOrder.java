package com.celcom.ecomm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlaceOrder {
	Connection con;
	int p,a,qty,avlqty,rmqty,orderId,i=1;
	String cq5,cq6,cq7,cq8,acn,b;
	//Statement ;
	boolean flag=false;
	PreparedStatement stmt3,stmt4,stmt5,stmt6,stmt7;
	ResultSet rs1,rs2,rs3,rx;
	PlaceOrder(Connection con){
		this.con=con;
	}
	public void placeOrder() {
		Scanner scg=new Scanner(System.in);
		System.out.println("Customer please Enter your Account Number");
		acn=scg.next();
		//cq7="select accountNumber from customer_ecomm_ramesh";
		cq7="select accountNumber from customer_ecomm_ramesh where accountNumber=?";
		try {
			//stmt7=con.createStatement();
			//rs3=stmt7.executeQuery(cq7);
			stmt7=con.prepareStatement(cq7);
			stmt7.setString(1,acn);
			rs3=stmt7.executeQuery();
			while(rs3.next()) {
				b=rs3.getString(1);
				if(acn.equalsIgnoreCase(b)) {
					System.out.println("Your Identity has been varified sucessfully please proceed");
					flag=true;
				}
				/*else {
					System.out.println("Invalid customer");
				}*/
			}
		} catch (SQLException e) {
			System.out.println("Invalid customer");
			System.out.println("Error in Place Order Customer Verification"+e);
		}
		
		if(flag) {
			System.out.println("Enter Product ID");
			p=scg.nextInt();
			//cq5="select pid from producdetails_ecomm_ramesh";
			cq5="select pid from producdetails_ecomm_ramesh where pid=?";
			try {
				//stmt3=con.createStatement();
				//rs1=stmt3.executeQuery(cq5);
				stmt3=con.prepareStatement(cq5);
				stmt3.setInt(1,p);
				rs1=stmt3.executeQuery();
				while(rs1.next()) {	
					a=rs1.getInt(1);
				//	if(a==p) {
						System.out.println("Product exists you can see qty and order");
						System.out.println("Enter Quantity you want to purchase");
						qty=scg.nextInt();
						cq6="select stockqty from producdetails_ecomm_ramesh where pid=?";
						stmt4=con.prepareStatement(cq6);
						stmt4.setInt(1,p);
						rs2=stmt4.executeQuery();
						while(rs2.next()) {
							avlqty=rs2.getInt(1);
							//System.out.println(avlqty);
							if(avlqty>=qty) {
								System.out.println("Requested qty is available");
								cq7="update producdetails_ecomm_ramesh set stockqty=? where pid=?";
								rmqty=avlqty-qty;
								stmt5=con.prepareStatement(cq7);
								//stmt5.setInt(1,rmqty);
								stmt5.setInt(1,avlqty);
								stmt5.setInt(2,p);
								stmt5.executeUpdate();
								//cq8="insert into orders_ecomm_ramesh (orderId,accountNumber,pid,quantity,price,status) values (?,?,?,?,?,?)";
								cq8="insert into orders_ecomm_ramesh (accountNumber,pid,quantity,price,status) values (?,?,?,?,?)";
								//orderId=(int) (Math.floor(Math.random() * 1000));
								stmt6=con.prepareStatement(cq8);
								//stmt6.setInt(1, orderId);
								stmt6.setString(1,acn);
								stmt6.setInt(2,p);
								stmt6.setInt(3,qty);
								stmt6.setInt(4,0);
								stmt6.setString(5,"New");
								stmt6.executeUpdate();
								String cvx="select ORDERID from orders_ecomm_ramesh where pid=?";
								PreparedStatement px=con.prepareStatement(cvx);
								px.setInt(1,a);
								rx=px.executeQuery();
								while(rx.next()) {
									orderId=rx.getInt(1);
								}
								System.out.println("Your order is processing....please wait....."+orderId);
								//New
								OrderPaymentStatus opd=new OrderPaymentStatus(con,orderId);
								//opd.start();
								ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
							/*	es.scheduleWithFixedDelay(()->{
								opd.run();	
								}, 1500, 1500, TimeUnit.MILLISECONDS);*/
								es.scheduleAtFixedRate(opd, 0, 2, TimeUnit.SECONDS);
								//es.execute(opd);
								es.schedule(() -> {
								    es.shutdown();
								    System.out.println("Executor shut down in Pending PAyment successs");
								}, 120, TimeUnit.SECONDS);
								//es.shutdown();
							}else {
								System.out.println("Requested qty is not available");
								//New
								OrderPaymentStatus opd=new OrderPaymentStatus(con,orderId);
								ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
								es.scheduleAtFixedRate(opd, 0, 2, TimeUnit.SECONDS);
								es.schedule(() -> {
								    es.shutdown();
								    System.out.println("Executor shut down in pending payment no qty....");
								}, 120, TimeUnit.SECONDS);
								//es.shutdown();
								/*OrderPaymentStatus opd = new OrderPaymentStatus(con,orderId);
								ExecutorService esd=Executors.newCachedThreadPool();
								esd.execute(ops);*/
							}
						}
				}
			} catch (SQLException e) {
				System.out.println("Product does not exists....please select valid products");
				System.out.println("Please see the product list once again");
				System.out.println("Error in showing products...."+e);
			}	
		}
	}
}
