package com.celcom.day4;

import java.util.Scanner;

public class PronicNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,product=1,i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		n=sc.nextInt();
		for(i=1;i<=n;i++) {
			for(j=1;j<=i+1;j++) {
				product=i*j;
			}
			if(product==n)
				break;
		}
		if(product==n) {
			System.out.println("Number "+n+" is pronic");
		}
		else {
			System.out.println("Number "+n+" is not Pronic");
		}

	}

}
