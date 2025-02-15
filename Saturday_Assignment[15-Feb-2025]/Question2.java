package com.Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n;
		List<Integer> l=new ArrayList<>();
		System.out.println("Enter no.of elements you want to enter");
		n=sc.nextInt();
		System.out.println("Enter elements of an arraylist : ");
		for(i=0;i<n;i++) {
			l.add(sc.nextInt());
		}
		System.out.println("Entered ArrayList is : ");
		Iterator<Integer> it=l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Collections.sort(l);
		System.out.println("Sorted ArrayList is : ");
		//System.out.println(l);
		Iterator<Integer> itx=l.iterator();
		while(itx.hasNext()) {
			System.out.println(itx.next());
		}	
	}

}
