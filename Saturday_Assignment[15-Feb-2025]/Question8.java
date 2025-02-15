package com.Assignment3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n;
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
		Collections.reverse(l);
		//System.out.println(l);
		System.out.println("LinkedList in reverse order : ");
		Iterator<Object> itx=l.iterator();
		while(itx.hasNext()) {
			System.out.println(itx.next());
		}

	}

}
