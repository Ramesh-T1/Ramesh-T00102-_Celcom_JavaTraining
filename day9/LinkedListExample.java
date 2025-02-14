package com.celcom.day9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		List<Object> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add("Java");
		list.add(10);
		System.out.println(list);
		System.out.println(list.get(0));
		list.add(1, 15);
		System.out.println(list);
		list.remove(new Integer(10));
		// list.remove(5);//removes using index
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.contains(20));
		System.out.println(list.isEmpty());
		// Iterating or Traversing a Collection
		System.out.println("Printing using For loop");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 2-For Each
		System.out.println("Printing using For Each");
		for (Object o : list) {
			System.out.println(o);
		}
		// 3-Iterator
		System.out.println("Printing using Iterator");
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
