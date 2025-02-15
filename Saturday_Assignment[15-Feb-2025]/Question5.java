package com.Assignment3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n,ind;
		System.out.println("Enter number of elements : ");
		n=sc.nextInt();
		List<Object> li=new ArrayList<>(n);
		System.out.println("Enter elements of arraylist : ");
		for(i=0;i<n;i++) {
			li.add(sc.next());
		}
		System.out.println("Entered ArrayList : ");
		Iterator it=li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		/*System.out.println("Enter index to find element : ");
		ind=sc.nextInt();
		System.out.println("Element at position "+ind+":"+li.get(ind));*/
		System.out.println("ArrayList alongwith index ");
		/*Iterator itx=li.iterator();
		Object temp=itx.hasNext();
		while(temp) {
			System.out.println("Element at index"+li.indexOf(it.next())+" = "+itx.next());
		}*/
		for(Object o:li) {
			System.out.println("Element at index "+li.indexOf(o)+" = "+o);
		}

	}

}
