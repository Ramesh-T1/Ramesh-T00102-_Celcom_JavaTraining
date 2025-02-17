package com.self.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//Tested
public class SortEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, i, j;
		List<Integer> li = new ArrayList<>();
		System.out.println("Enter Size of ArrayList");
		n = sc.nextInt();
		System.out.println("Enter elements of ArrayList");
		for (i = 0; i < n; i++) {
			li.add(sc.nextInt());
		}
		System.out.println("Entered ArrayList is : ");	
		Iterator it = li.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for(i=0;i<n;i++) {
			for(j=i+1;j<n;j++) {
				if(li.get(i)>li.get(j)) {
					Integer temp=li.get(i);
					li.set(i,li.get(j));
					li.set(j,temp);
				}
			}
		}
		System.out.println("Sorted ArrayList is : ");	
		Iterator itx = li.iterator();
		while (itx.hasNext()) {
			System.out.println(itx.next());
		}

	}

}
