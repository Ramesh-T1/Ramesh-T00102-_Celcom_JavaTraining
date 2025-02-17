package com.self.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Tested
public class SameElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, i;
		boolean flag = false;
		List<Object> li = new ArrayList<>();
		List<Object> nl = new ArrayList<>();
		System.out.println("Enter size of ArrayList 1");
		n = sc.nextInt();
		System.out.println("Enter Elements of ArrayList 1");
		for (i = 0; i < n; i++) {
			li.add(sc.next());
		}
		System.out.println("Entered Array List 1 is : ");
		for (Object o : li) {
			System.out.println(o);
		}
		System.out.println("Enter size of ArrayList 2");
		m = sc.nextInt();
		System.out.println("Enter Elements of ArrayList 2");
		for (i = 0; i < m; i++) {
			nl.add(sc.next());
		}
		System.out.println("Entered Array List 2 is : ");
		for (Object o : nl) {
			System.out.println(o);
		}
		if (n == m) {
			System.out.println("ArrayList size matches you can go ahead with comparing");
			for (i = 0; i < n; i++) {
				if(li.contains(nl.get(i))){
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println("ArrayList 1 and ArrayList 2 matches");
			} else {
				System.out.println("ArrayList 1 and ArrayList 2 does not matches");
			}
		}else {
			System.out.println("Size of both the arrays are not same cannot compare");
		}
	}
}
