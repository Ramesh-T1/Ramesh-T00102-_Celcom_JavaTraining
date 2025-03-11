package com.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InProgress {
	//To query all orders with status new
	String query1="select * from orders_ecomm_ramesh where status='New'";
	//To update orders_ecomm_ramesh table with status Inprogress
	String query2 = "update orders_ecomm_ramesh set status=? where status=?";
	public void markInProgress(Connection con) {
		try (Statement bst1 = con.createStatement(); ResultSet brs1 = bst1.executeQuery(query1)) {
			while (brs1.next()) {
				
				try (PreparedStatement pst1 = con.prepareStatement(query2)) {
					pst1.setString(1, "InProgress");
					pst1.setString(2, "New");
					pst1.executeUpdate();
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception in billing thread....finding new orders and updating to in progress: " + e);
		}
		
	}
}
