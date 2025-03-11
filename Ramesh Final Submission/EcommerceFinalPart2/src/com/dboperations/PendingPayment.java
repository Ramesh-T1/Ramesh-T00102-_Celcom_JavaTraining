package com.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PendingPayment {
	String bs3 = "select pid,quantity,orderId from orders_ecomm_ramesh where status='InProgress'";
	String bs4 = "select pid,stockqty,price from producdetails_ecomm_ramesh where pid=?";
	String bs5 = "update producdetails_ecomm_ramesh set stockqty=? where pid=?";
	String bs6 = "select * from orders_ecomm_ramesh where status=? and pid=? and ORDERID=?";
	String bs7 = "update orders_ecomm_ramesh set status=?, price=? where pid=? and ORDERID=?";
	// bs6 = "select * from orders_ecomm_ramesh where status=? and pid=?";
	String bs8 = "select * from orders_ecomm_ramesh where status=? and pid=?";
	String bs9 = "update orders_ecomm_ramesh set status=? where status=?";
	// fpid,fqty,foid is ProductID,OrderedQty,OrderID from orders_ecomm_ramesh table
	// pdfpid,pdfqty,brmqty is ProductId,StockQty (or Available Qty),Remaining Qty
	// from producdetails_ecomm_ramesh table
	static int fpid, fqty, foid, pdfpid, pdfqty, brmqty;
	// Total is Total price and pdcp is Products Cost Price per unit (i.e price from
	// producdetails_ecomm_ramesh) table
	double total, pdcp;
	Scanner sc = new Scanner(System.in);

	public void markPendingPayment(Connection con) {

		// Getting productid (pid),quantity(fqty),OrderId(foid) from ordres_ecomm_ramesh
		// table where status is InProgress
		try (Statement bst2 = con.createStatement(); ResultSet brs1 = bst2.executeQuery(bs3)) {
			while (brs1.next()) {
				fpid = brs1.getInt(1);
				System.out.println("PID fetched " + fpid);
				fqty = brs1.getInt(2);
				System.out.println("Qty fetched " + fqty);
				foid = brs1.getInt(3);

				// Getting ProductId(pdfpid),StockQty(pddfqty),Price(pdcp) from
				// producdetails_ecomm_ramesh where pid=?
				try (PreparedStatement pst2 = con.prepareStatement(bs4)) {
					pst2.setInt(1, fpid);
					try (ResultSet brs3 = pst2.executeQuery()) {
						while (brs3.next()) {
							pdfpid = brs3.getInt(1);
							pdfqty = brs3.getInt(2);
							pdcp = brs3.getDouble(3);

							if (pdfpid == fpid) {
								if (pdfqty >= fqty) {
									System.out.println("Requested qty is available");

									// Updating Stock qty in producdetails_ecomm_ramesh table on Productid
									try (PreparedStatement pst3 = con.prepareStatement(bs5)) {
										brmqty = pdfqty - fqty;
										pst3.setInt(1, brmqty);
										pst3.setInt(2, fpid);
										pst3.executeUpdate();
									}

									// Selecting records from orders_ecomm_ramesh based on
									// Status=InProgress,ProductID,OrderID
									try (PreparedStatement bst3 = con.prepareStatement(bs6)) {
										total = pdcp * fqty;
										bst3.setString(1, "InProgress");
										bst3.setInt(2, fpid);
										bst3.setInt(3, foid);
										try (ResultSet brs4 = bst3.executeQuery()) {
											while (brs4.next()) {
												// Updating orders_ecomm_ramesh Setting Status=PendingPayment and
												// Calculating Total price based on ProductId and OrderID
												try (PreparedStatement pst4 = con.prepareStatement(bs7)) {
													pst4.setString(1, "PendingPayment");
													pst4.setDouble(2, total);
													pst4.setInt(3, fpid);
													pst4.setInt(4, foid);
													pst4.executeUpdate();
													PaymentSuccess pa=new PaymentSuccess();
													PaymentFailure pf=new PaymentFailure();
													UPIPaymentProcess up=new UPIPaymentProcess();
													UPIPaymentFailure upf=new UPIPaymentFailure();
													System.out.println("Do you want to pay via Debit Card or Credit Card or UPI");
													System.out.println(
															"Are you sure you want to confirm payment For Card :- 1-Yes 2-No"
															+ " For UPI  3-Yes 4-No");
													int ox = sc.nextInt();
													switch (ox) {
													case 1:
														pa.processPayment(con,fpid,foid,pdfqty);
														break;
													case 2:
														pf.cancelPayment(con,fpid,foid,pdfqty);
														break;
													case 3: up.processUPIPayment(con,fpid,foid,pdfqty);
														break;
													case 4:upf.cancelPayment(con, fpid,foid,pdfqty); 
														break;
													default:
														System.out.println("Please confirm payment......!!!!");
													}
												}
											}
										}
									}
								} else {
									try (PreparedStatement bst4 = con.prepareStatement(bs8)) {
										bst4.setString(1, "InProgress");
										bst4.setInt(2, fpid);
										try (ResultSet brs4 = bst4.executeQuery()) {
											while (brs4.next()) {
												try (PreparedStatement pst4 = con.prepareStatement(bs9)) {
													pst4.setString(1, "Failed");
													pst4.setString(2, "InProgress");
													pst4.executeUpdate();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
