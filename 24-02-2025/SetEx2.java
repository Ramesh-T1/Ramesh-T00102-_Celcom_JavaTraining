package com.celcom.day12;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetEx2 {

	public static void main(String[] args) {
		Set<String> st=new LinkedHashSet<>();
		st.add("Kiran");
		st.add("Martinelli");
		st.add("Kajol");
		st.add("Maxwell");
		st.add("Luthor");
		System.out.println("Elements of st : "+st);
		//Adding null values
		st.add(null);
        System.out.println("After adding first null value : "+st);
        st.add(null);
        System.out.println("After adding second null value : "+st);
        Set<String> st1=new LinkedHashSet<>();
        st1.add("Vikram");
        st1.add("Lara");
        System.out.println("Element is present or not contains : "+st.contains("Kajol"));
        System.out.println("Entire set is present or not in other containsAll : "+st.containsAll(st1));
        st1.addAll(st);
        System.out.println("After using AddAll method : "+st1);
        System.out.println("Entire set is present or not in other containsAll after AddAll : "+st.containsAll(st1));
        System.out.println("Remove operation : "+st1.remove("Kajol"));
        System.out.println("After Remove operation : "+st1);
        System.out.println("Hashcode:"+st1.hashCode());
        System.out.println("Is Empty :"+st1.isEmpty());
        //Iterator
        Iterator it=st1.iterator();
        System.out.println("After using Iterator");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        //To Array
        Object o[]=st1.toArray();
        for(Object x:o) {
        	System.out.println("After converting st1 to ToArray : "+x);
        }
        //Retain All
       // st.retainAll(st1);
        //System.out.println("After using st.retainAll(st1)"+st);
        st1.retainAll(st);
        System.out.println("After using st1.retainAll(st) st1 = "+st1);
        System.out.println("After using st1.retainAll(st) st = "+st);
        //Clear
        st1.clear();
        System.out.println("After clear operation : "+st1);
        //Retain All
        Set<String> a=new LinkedHashSet<>();
        a.add("Farhan");
        a.add("Mahesh");
        a.add("Gita");
        System.out.println("Entered Set a is = "+a);
        Set<String> b=new LinkedHashSet<>();
        b.add("Farhan");
        //b.add("Mahesh");
        System.out.println("Entered Set b is = "+b);
        System.out.println("Retain All a.retainAll(b) : "+a.retainAll(b));
        System.out.println("Print a : "+a);
        System.out.println("Retain All b.retainAll(a) : "+b.retainAll(a));
        System.out.println("Print b : "+b);
        
        
	}

}
