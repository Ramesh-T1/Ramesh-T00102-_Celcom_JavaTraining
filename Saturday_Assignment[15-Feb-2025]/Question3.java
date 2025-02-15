package com.Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,n;
		System.out.println("Enter number of elements : ");
		n=sc.nextInt();
		List<Object> li=new ArrayList<>(n);
		List<Object> m=new ArrayList<>(n);
		System.out.println("Enter elements of arraylist : ");
		for(i=0;i<n;i++) {
			li.add(sc.next());
		}
		System.out.println("Entered ArrayList : ");
		Iterator it=li.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//Collections.copy(li,m);
		//System.out.println(m);
		m.addAll(li);
		System.out.println("Copied Arraylist m : ");
		Iterator<Object> itx=m.iterator();
		while(itx.hasNext()) {
			System.out.println(itx.next());
		}

	}

}
