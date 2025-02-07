package com.celcom.day1;

import java.util.Scanner;

public class FactorialTable {

	public static void main(String[] args) {
		int a, i, f = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number :");
		a = sc.nextInt();
		System.out.println("Factorial upto " + a);
		for (i = 1; i <= a; i++) {
			f = f * i;
			System.out.println("Factorial of " + i + "=" + f);
		}
		sc.close();
	}

}
