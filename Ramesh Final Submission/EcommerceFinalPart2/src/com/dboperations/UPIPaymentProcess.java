package com.dboperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UPIPaymentProcess {
	// Storing AccountNumber from orders_ecomm_ramesh into this variable
	String accnoN;
	// Getting Accountnumber for orders_ecomm_ramesh table
	String sm4 = "select accountNumber from orders_ecomm_ramesh where status=? and pid=? and ORDERID=?";
	// Selecting complete paymentdetails from upiPaymentdetails_ramesh and
	// AccountNumber from customer_ecomm_ramesh by inneer join
	String sm2 = "select a.UPIID,a.STATUS,b.accountNumber from upiPaymentdetails_ramesh a "
			+ "INNER JOIN customer_ecomm_ramesh b ON a.UPIID=b.email WHERE a.status=? AND b.accountNumber=?";
	// Putting Card Details and Final Payment Status in a order_place_ramesh table
	String sm1 = "insert into order_place_upi_ramesh "
			+ "(UPIID,STATUS,ACCOUNTNUMBER, PAYMENTSTATUS) values(?,?,?,?)";

	// Updating status in ordres_ecomm_ramesh table
	String bsa8 = "update orders_ecomm_ramesh set status=? where pid=? and accountNumber=? and ORDERID=?";
	// In case of Inactive card setting price=0,Status as Orderfailed
	String bsb8 = "update orders_ecomm_ramesh set status=?,price=? where pid=? and accountNumber=? and ORDERID=?";
	// In case of Inactive card not subtracting from StokQty in
	// producdetails_ecomm_ramesh table
	String bsb9 = "update producdetails_ecomm_ramesh set STOCKQTY=? where PID=?";

	// Finding AccountNumber
	public void findAccountNumber(Connection con, int fpid, int foid) {
		try (PreparedStatement psdf1 = con.prepareStatement(sm4);) {
			psdf1.setString(1, "PendingPayment");
			psdf1.setInt(2, fpid);
			psdf1.setInt(3, foid);
			// You can take orderid and put it in order_place ramesh table
			ResultSet rpsdf = psdf1.executeQuery();
			while (rpsdf.next()) {
				accnoN = rpsdf.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void processUPIPayment(Connection con, int fpid, int foid, int pdfqty) {
		findAccountNumber(con, fpid, foid);
		// Active payment and sucess method
		try (PreparedStatement str1 = con.prepareStatement(sm2)) {
			str1.setString(1, "Active");
			str1.setString(2, accnoN);
			ResultSet rm1 = str1.executeQuery();
			while (rm1.next()) {
				String upiid = rm1.getString(1);
				String status = rm1.getString(2);
				String accnn = rm1.getString(3);
				try (PreparedStatement psdf = con.prepareStatement(sm1)) {
					psdf.setString(1, upiid);
					psdf.setString(2, status);
					psdf.setString(3, accnn);
					psdf.setString(4, "completed");
					psdf.executeUpdate();
			        //Updating orders_ecomm_ramesh table with order status
					try (PreparedStatement pst4 = con.prepareStatement(bsa8)) {
						pst4.setString(1, "Order Sucess");
						pst4.setInt(2, fpid);
						pst4.setString(3, accnn);
						pst4.setInt(4, foid);
						pst4.executeUpdate();
						System.out.println("Your order is successfully placed.Thank you");
					}
				} catch (SQLException e) {
					System.out.println("Error in insertion success payment " + e);
				}

			}

		} catch (SQLException e) {
			System.out.println("Error in marking complete in UPI payments with yes choice and active" + e);
			e.printStackTrace();
		}
		// Inactive card
		// Updating producdetails_ecomm_ramesh is pending in case of failed payment
		try (PreparedStatement str1 = con.prepareStatement(sm2)) {
			str1.setString(1, "InActive");
			str1.setString(2, accnoN);
			ResultSet rm1 = str1.executeQuery();
			while (rm1.next()) {
				String upiid = rm1.getString(1);
				String status = rm1.getString(2);
				String accnn = rm1.getString(3);
				try (PreparedStatement psdf = con.prepareStatement(sm1)) {
					psdf.setString(1, upiid);
					psdf.setString(2, status);
					psdf.setString(3, accnn);
					psdf.setString(4, "FailedPayment");
					psdf.executeUpdate();
					//Updating orders_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsb8)) {
						pst4.setString(1, "Order Failed");
						pst4.setDouble(2, 0);
						pst4.setInt(3, fpid);
						pst4.setString(4, accnn);
						pst4.setInt(5, foid);
						pst4.executeUpdate();
						System.out.println("Order cannot be placed as your UPI payment method is inactive....");
					}
					//Updating producdetails_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsb9)) {
						pst4.setInt(1, pdfqty);
						pst4.setInt(2, fpid);
						pst4.executeUpdate();
					}
				} catch (SQLException e) {
					System.out.println("Error in cancel payment due to inactive UPI" + e);
				}

			}

		} catch (SQLException e) {
			System.out.println("Error in marking failed payment " + e);
			e.printStackTrace();
		}

	}
}
