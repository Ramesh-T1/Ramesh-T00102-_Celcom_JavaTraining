package com.celcom.day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Ex1 {

	public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/practice_ramesh";
        String userName="root";
        String password="root@123";
        //String query="create table Book("+"bookName varchar(20),"+"authorName varchar(20))";
        String query="create table Book(bookName varchar(20),authorName varchar(20))";
        String query1="insert into book(bookName,authorName)values('MyJourney','APJ Abdul kalam')";
        String query2="select * from book";
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
        	
        	st.executeUpdate(query1);
        	ResultSet rs=st.executeQuery(query2);
        	System.out.println("Book Name   AuthorName");
        	while(rs.next()) {
        		System.out.println(rs.getString(1)+"   "+rs.getString(2));
        	}
        	System.out.println("Table Inserted");	
        }catch(Exception e) {
        	System.out.println(e);
        }

	}

}
