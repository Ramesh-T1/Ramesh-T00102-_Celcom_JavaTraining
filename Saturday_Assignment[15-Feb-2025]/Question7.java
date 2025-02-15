package com.Assignment3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n,ind;
		System.out.println("Enter size of LinkedList : ");
		n=sc.nextInt();
		List<Object> l=new LinkedList<>();
		System.out.println("Enter elements of LinkedList : ");
		for(i=0;i<n;i++) {
			l.add(sc.next());
		}
		System.out.println("Entered LinkedList : ");
		Iterator<Object> it=l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Enter starting index : ");
		ind=sc.nextInt();
		System.out.println("Elements from entered index : "+ind);
		for(i=ind;i<l.size();i++) {
			System.out.println(l.get(i));
		}
	}
}
