package com.dboperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentFailure {
	// Variable to Store AccountNumber from orders_ecomm_ramesh
	String accnoN;
	// Getting Accountnumber from orders_ecomm_ramesh
	String sm4 = "select accountNumber from orders_ecomm_ramesh where status=? and pid=? and ORDERID=?";
	// Selecting complete paymentdetails from customer_paymentdetails and
	// AccountNumber from customer_ecomm_ramesh by inneer join
	String sm2 = "SELECT a.cardNumber,a.name,a.expiryDate,a.cvv,a.status,b.accountNumber FROM customer_paymentdetails_ramesh a"
			+ " INNER JOIN customer_ecomm_ramesh b ON a.name=b.firstName " + "WHERE a.status=? AND b.accountNumber=?";
	// Putting Card Details and Final Payment Status in a order_place_ramesh table
	String sm1 = "insert into order_place_ramesh "
			+ "(cardNumber, name, expiryDate, cvv, status,accountNumber, paymentStatus) " + "values(?,?,?,?,?,?,?)";
	// Updating status and price in ordres_ecomm_ramesh table
	String bsa8 = "update orders_ecomm_ramesh set status=?,price=? where pid=? and accountNumber=? and ORDERID=?";
	// Updating or restoring qty into producdetails_ecomm_ramesh table
	String bsa9 = "update producdetails_ecomm_ramesh set STOCKQTY=? where PID=?";

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

	public void cancelPayment(Connection con, int fpid, int foid, int pdfqty) {
		findAccountNumber(con, fpid, foid);
		// Active Card
		try (PreparedStatement str1 = con.prepareStatement(sm2)) {
			str1.setString(1, "Active");
			str1.setString(2, accnoN);
			ResultSet rm1 = str1.executeQuery();
			while (rm1.next()) {
				String cn = rm1.getString(1);
				String name = rm1.getString(2);
				Date exp = rm1.getDate(3);
				String cvv = rm1.getString(4);
				String status = rm1.getString(5);
				String accnn = rm1.getString(6);
				 //Entering record into order_place_ramesh
				try (PreparedStatement psdf = con.prepareStatement(sm1)) {
					psdf.setString(1, cn);
					psdf.setString(2, name);
					psdf.setDate(3, exp);
					psdf.setString(4, cvv);
					psdf.setString(5, status);
					psdf.setString(6, accnn);
					psdf.setString(7, "FailedPayment");
					psdf.executeUpdate();
					//Updating orders_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsa8)) {
						pst4.setString(1, "Order Failed");
						pst4.setDouble(2, 0);
						pst4.setInt(3, fpid);
						pst4.setString(4, accnn);
						pst4.setInt(5, foid);
						pst4.executeUpdate();
						System.out.println("Order Failed due to users choice...Not to pay");
					}
					//Updating producdetails_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsa9)) {
						pst4.setInt(1, pdfqty);
						pst4.setInt(2, fpid);
						pst4.executeUpdate();
					}
				} catch (SQLException e) {
					System.out.println("Error in cancel payment " + e);
				}

			}

		} catch (SQLException e) {
			System.out.println("Error in marking failed payment " + e);
			e.printStackTrace();
		}

		// Inactive card
		try (PreparedStatement str1 = con.prepareStatement(sm2)) {
			str1.setString(1, "InActive");
			str1.setString(2, accnoN);
			ResultSet rm1 = str1.executeQuery();
			while (rm1.next()) {
				String cn = rm1.getString(1);
				String name = rm1.getString(2);
				Date exp = rm1.getDate(3);
				String cvv = rm1.getString(4);
				String status = rm1.getString(5);
				String accnn = rm1.getString(6);
                //Entering record into order_place_ramesh
				try (PreparedStatement psdf = con.prepareStatement(sm1)) {
					psdf.setString(1, cn);
					psdf.setString(2, name);
					psdf.setDate(3, exp);
					psdf.setString(4, cvv);
					psdf.setString(5, status);
					psdf.setString(6, accnn);
					psdf.setString(7, "FailedPayment");
					psdf.executeUpdate();
					//Updating orders_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsa8)) {
						pst4.setString(1, "Order Failed");
						pst4.setDouble(2, 0);
						pst4.setInt(3, fpid);
						pst4.setString(4, accnn);
						pst4.setInt(5, foid);
						pst4.executeUpdate();
						System.out
								.println("Order Failed due to users choice...Not to pay....and his card is not active");
					}
					//Updating producdetails_ecomm_ramesh table
					try (PreparedStatement pst4 = con.prepareStatement(bsa9)) {
						pst4.setInt(1, pdfqty);
						pst4.setInt(2, fpid);
						pst4.executeUpdate();
					}
				} catch (SQLException e) {
					System.out.println("Error in cancel payment " + e);
				}

			}

		} catch (SQLException e) {
			System.out.println("Error in marking failed payment " + e);
			e.printStackTrace();
		}

	}
}
