package com.ecommerce.connection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class DBConnection {
	static Connection con;
	static String url, userName, pwd;
	static List<String> allLines;

	public DBConnection(Connection con) {
		this.con = con;
	}

	public Connection dbConnection() {

		try {
			//allLines = Files.readAllLines(Paths.get("D:/Java training_jdk17/EcommerceFinal/DBConnectionDetails.txt"));
			allLines = Files.readAllLines(Paths.get("D:\\Java training_jdk17\\EcommerceFinalPart2\\DBCredentials"));
			// allLines
			// =Files.readAllLines(Paths.get("/EcommerceFinalPart2/DBCredentials"));
			url = allLines.get(0);
			userName = allLines.get(1);
			pwd = allLines.get(2);
			System.out.println(url);
			System.out.println(userName);
			System.out.println(pwd);
		} catch (IOException e) {
			System.out.println("Error in reading DB credentials " + e);
			e.printStackTrace();
		}

		// Reading Credentials
		/*
		 * try { Scanner scanner = new Scanner(new
		 * File("D:\\Java training_jdk17\\EcommerceFinalPart2\\DBCredentials")); while
		 * (scanner.hasNextLine()) { String a=scanner.nextLine(); allLines.add(a);
		 * System.out.println(scanner.nextLine()); } for(String s:allLines) { url
		 * =allLines.get(0); userName = allLines.get(1); pwd = allLines.get(2); }
		 * scanner.close(); } catch (FileNotFoundException e) { e.printStackTrace(); }
		 */

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userName, pwd);
			System.out.println("Connection Successful for Processes!!");
		} catch (SQLException e) {
			System.out.println("Error in connection to Oracle DB in Processes: " + e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error in OJDBC jar.....");
			e.printStackTrace();
		}
		return con;
	}

}
