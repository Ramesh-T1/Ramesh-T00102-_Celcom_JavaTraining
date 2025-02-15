package com.Assignment3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n;
		System.out.println("Enter number of elements : ");
		n=sc.nextInt();
		List<Object> li=new LinkedList<>();
		System.out.println("Enter elements of LinkedList : ");
		for(i=0;i<n;i++) {
			li.add(sc.next());
		}
		System.out.println("Entered LinkedList : ");
		Iterator it=li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		/*System.out.println("Enter index to find element : ");
		ind=sc.nextInt();
		System.out.println("Element at position "+ind+":"+li.get(ind));*/
		System.out.println("LinkedList alongwith index ");
		/*Iterator itx=li.iterator();
		Object temp=itx.hasNext();
		while(temp) {
			System.out.println("Element at index"+li.indexOf(it.next())+" = "+itx.next());
		}*/
		for(Object o:li) {
			System.out.println("Element at index "+li.indexOf(o)+" = "+o);
		}
		System.out.println("LinkedList alongwith index using iterator ");
		Iterator itx=li.iterator();
		while(itx.hasNext()) {
			Object temp1=itx.next();
			System.out.println("Element at index "+li.indexOf(temp1)+" = "+temp1);
		}


	}

}
