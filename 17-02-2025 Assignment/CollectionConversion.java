package com.self.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//Tested
public class CollectionConversion {
	public static List<Object> convertLLtoAL() {
		Scanner sc = new Scanner(System.in);
		int n, i, op;
		List<Object> li = new LinkedList<>();
		List<Object> al = new ArrayList<>();
		System.out.println("Enter Linked List Size");
		n = sc.nextInt();
		System.out.println("Enter elements of Linked List");
		//System.out.println(li.size());//li.size is zero unless and until we add elements
		for (i = 0; i < n; i++) {
			li.add(sc.next());
		}
		System.out.println("Entered Linked List is : ");
		Iterator it = li.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		al.addAll(li);
		return al;
	}

	public static List<Object> convertALtoLL() {
		Scanner sc = new Scanner(System.in);
		int n, i, op;
		List<Object> al = new LinkedList<>();
		List<Object> li = new ArrayList<>();
		System.out.println("Enter ArrayList Size");
		n = sc.nextInt();
		System.out.println("Enter elements of ArrayList");
		//System.out.println(li.size());//li.size is zero unless and until we add elements
		for (i = 0; i <n; i++) {
			li.add(sc.next());
		}
		System.out.println("Entered ArrayList is : ");
		Iterator it = li.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		al.addAll(li);
		return al;
	}

	public static void main(String[] args) {
		Scanner scm = new Scanner(System.in);
		int i=0, op;
		System.out.println("Select your choice");
		do {
			System.out.println("1-LinkedList to ArrayList 2-ArrayList to LinkedList");
			op = scm.nextInt();
			switch (op) {
			case 1:
				List<Object> ans = convertLLtoAL();
				System.out.println("Linked List Converted into Array List : " + ans);
				break;
			case 2:
				List<Object> an = convertALtoLL();
				System.out.println("Linked List Converted into Array List : " + an);
				break;
			default:
				System.out.println("Entere proper selection!!!");

			}

		} while (i < 1);
		i++;
	}

}
