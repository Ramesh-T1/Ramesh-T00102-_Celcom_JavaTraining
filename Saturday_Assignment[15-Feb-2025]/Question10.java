package com.Assignment3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n;
		System.out.println("Enter number of elements : ");
		n=sc.nextInt();
		List<Object> li=new LinkedList<>();
		List<Object> m=new LinkedList<>();
		System.out.println("Enter elements of LinkedList : ");
		for(i=0;i<n;i++) {
			li.add(sc.next());
		}
		System.out.println("Entered LinkedList : ");
		Iterator it=li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		m.addAll(li);
		System.out.println("Elements copied into new LinkedList are : ");
		Iterator itx=m.iterator();
		while(itx.hasNext()) {
			System.out.println(itx.next());
		}
	}

}
