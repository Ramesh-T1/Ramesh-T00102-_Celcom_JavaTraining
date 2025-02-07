package com.celcom.day1;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		int a,b,c;
		String s;
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Enter two numbers");
			a=sc.nextInt();
			b=sc.nextInt();
			System.out.print("1-Addition,2-Subtraction,3-Multiplication,4-Division,5-Quit");
			System.out.println("Enter your choice");
			c=sc.nextInt();
		switch(c) {
		case 1:System.out.println("Addition of "+a+"+"+b+"="+(a+b));
		       break;
		case 2:System.out.println("Subtraction of "+a+"-"+b+"="+(a-b));
	       break;
		case 3:System.out.println("Multiplication of "+a+"*"+b+"="+(a*b));
	       break;
		case 4:System.out.println("Division of "+a+"/"+b+"="+(a/b));
	       break;
		 case 5:System.out.println("User Quited");
		        break;
		  default:System.out.println("Please follow instructions...");
		}
		System.out.println("Do you wish to continue Yes/No");
		s=sc.next();
		}
		while(s.equalsIgnoreCase("Yes"));
		sc.close();
	}
}
