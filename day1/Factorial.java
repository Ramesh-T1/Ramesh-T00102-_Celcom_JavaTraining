package com.celcom.day1;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int a, i, f = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number :");
		a = sc.nextInt();
		for (i = a; i > 0; i--) {
			f = f * i;
		}
		System.out.println("Factorial of " + a + "=" + f);
       sc.close();
	}

}
