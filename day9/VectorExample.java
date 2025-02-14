package com.celcom.day9;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		/*List<Integer> vec=new Vector<>();
		vec.add(10);
		vec.add(20);
		vec.add(20);
		vec.add(30);
		vec.add(40);
		System.out.println(vec);*/
		Vector<Integer> vec=new Vector<>(3,2);
		System.out.println(vec.size());//0
		System.out.println(vec.capacity());//3
		vec.add(10);
		vec.add(20);
		System.out.println("After adding 3 :"+vec.capacity());//3
		vec.add(30);
		System.out.println("After adding 3 :"+vec.capacity());//3
		vec.add(40);
		System.out.println("After adding 4 :"+vec.capacity());//5
		vec.add(50);
		System.out.println("After adding 5 :"+vec.capacity());//5
		vec.add(50);
		System.out.println("After adding 6 : "+vec.capacity());//5
		//1-For loop
		System.out.println("Printing using For Loop");
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
		//2-For Each
		System.out.println("Printing using For Each Loop");
		for(Integer i:vec) {
			System.out.println(i);
		}
		//3-Enumeration
		System.out.println("Printing using Enumeration");
		Enumeration<Integer> e=vec.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}

}
