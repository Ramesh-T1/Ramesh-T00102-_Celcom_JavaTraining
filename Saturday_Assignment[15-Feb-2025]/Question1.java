package com.Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer obj;
		int i,n;
		boolean flag = false;
		List<Integer> l = new ArrayList<>();
		System.out.println("Enter how many elements you want to enter : ");
		n=sc.nextInt();
		System.out.println("Enter ArrayList : ");
		for (i = 0; i < n; i++) {
			l.add(sc.nextInt());
		}
		System.out.println("Entered ArrayList is : ");
		for (Integer x : l) {
			System.out.println(x);
		}
		System.out.println("Enter element you want to search : ");
		obj = sc.nextInt();
		for (Integer x : l) {
			if (obj.equals(x)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Entered element " + obj + " found at : " + l.indexOf(obj));
		} else {
			System.out.println("Entered element " + obj + " not found : ");
		}

	}

}
