package com.celcom.day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Ex2 {

	public static void main(String[] args) {
		 String url="jdbc:mysql://localhost:3306/practice_ramesh";
	        String userName="root";
	        String password="root@123";
	        String query="create table test(bookName varchar(20),authorName varchar(20))";
	        String query1="insert into test(bookName,authorName)values('MyJourney','APJ Abdul kalam')";
	        String query4="insert into test(bookName,authorName)values('Playing it My Way','Sourav Ganguly')";
	        String query2="select * from test";
	        String query3="delete from test where bookName='MyJourney'";
	        String query6="update test set bookName='Orchids' where bookName='Playing it My Way'";
	        String query5="truncate table test";
	        try {
	        	//To establish connection
	        	Connection con=DriverManager.getConnection(url,userName,password);
	        	System.out.println("Connection is Sucessful");
	        	//Statement is used to get the query
	        	Statement st=con.createStatement();
	        	try {
	        		st.executeUpdate(query);
	        	}catch(Exception e) {
	        		System.out.println("Table already created");
	        		System.out.println(e);
	        	}
	        	//insert
	        	st.executeUpdate(query1);
	        	st.executeUpdate(query4);
	        	System.out.println("Table Inserted");
	        	ResultSet rs=st.executeQuery(query2);
	        	System.out.println("Book Name   AuthorName");
	        	while(rs.next()) {
	        		System.out.println(rs.getString(1)+"   "+rs.getString(2));
	        	}
	        	//Delete Row
	        	st.executeUpdate(query3);
	        	ResultSet rs1=st.executeQuery(query2);
	        	System.out.println("After removing a row");
	        	System.out.println("Book Name   AuthorName");
	        	while(rs1.next()) {
	        		System.out.println(rs1.getString(1)+"   "+rs1.getString(2));
	        	}
	        	//Update
	        	st.executeUpdate(query6);
	        	System.out.println("After update");
	        	ResultSet rs3=st.executeQuery(query2);
	        	System.out.println("Book Name        Author Name");
	        	while(rs3.next()) {
	        		System.out.println(rs3.getString(1)+"  "+rs3.getString(2));
	        	}
	        	//Truncate
	        	st.executeUpdate(query5);
	        	System.out.println("After truncate....");
	        	ResultSet rs2=st.executeQuery(query2);
	        	System.out.println("Book Name   AuthorName");
	        	while(rs2.next()) {
	        		System.out.println(rs2.getString(1)+"   "+rs2.getString(2));
	        	} 	
	        }catch(Exception e) {
	        	System.out.println(e);
	        }

	}

}
