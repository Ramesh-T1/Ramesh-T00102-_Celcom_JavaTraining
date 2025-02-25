package com.celcom.day12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		Set<String> st=new HashSet<>();
		st.add("Ramesh");
		st.add("Ramesh");//Duplicate elements will not be accepted
		st.add("Kiran");
		st.add("Rupesh");
		st.add("Atul Oraskar");
		System.out.println("Entered Set is = "+st);
		st.remove("Kiran");
		System.out.println("After removing Kiran Element = "+st);
		Set<String> st1=new HashSet<>();
		st1=st;
		System.out.println("After Copying st into st1 using '=' : "+st1);
		Set<String> st2=new HashSet<>();
		st2.addAll(st1);
		System.out.println("After Copying st into st1 using 'AddAll' : "+st1);
		st2.remove("Rupesh");
		st2.add("Rooney");
		st2.add("Ronaldo");
		System.out.println("Checking Contains : "+st2.contains("Ramesh"));
		System.out.println("Checking Contains with entire set : "+st2.contains(st1));
		System.out.println("Checking Contains All : "+st2.containsAll(st));
		System.out.println("String st1 : "+st1);
		System.out.println("Prints Hashcode : "+st2.hashCode());
		System.out.println("St2 : "+st2);
		System.out.println("Checing isEmpty : "+st2.isEmpty());
		Iterator<String> it=st.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		st.add(null);
		System.out.println("After adding one null value : "+st);
		st.add(null);
		System.out.println("After adding two null values : "+st);
		//Retain All
		st2.retainAll(st);
		System.out.println(st2.retainAll(st));
		System.out.println("After Retain All : "+st2);
		System.out.println("Size of st2 : "+st2.size());
		System.out.println("st2.toArray() = "+st2.toArray().toString());
		Object arr[]=st2.toArray();
		System.out.println("After converting st2 to toArray : ");
		for (Object o : arr) {
			System.out.println(o);
		}
		st2.clear();
		System.out.println("After using clear method : "+st2);
	}

}
