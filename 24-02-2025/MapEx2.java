package com.celcom.day12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapEx2 {

	public static void main(String[] args) {
		Map<Integer,String> m=new LinkedHashMap<Integer,String>();
		m.put(1,"DairyMilk");
		m.put(2,"Eclair");
		m.put(3, "KitKat");
		System.out.println(m);
		System.out.println("Printing using For loop : ");
		for(Map.Entry<Integer,String> hm:m.entrySet()) {
			System.out.println("Key : "+hm.getKey()+",Value : "+hm.getValue());
			m.put(2,"Coconut");
			/*System.out.println("After Adding a new element");
			for(Map.Entry<Integer,String> hm1:m.entrySet()) {
				System.out.println("Key : "+hm1.getKey()+",Value : "+hm1.getValue());
			}*/
		}
		System.out.println("After Adding a new element");
		for(Map.Entry<Integer,String> hm1:m.entrySet()) {
			System.out.println("Key : "+hm1.getKey()+",Value : "+hm1.getValue());
		}
		//m.merge(3, "KitKat", "Umbrella");
		m.merge(3,"dairy",(oldValue,newValue)->oldValue+newValue);
		System.out.println("After merge");
		for(Map.Entry<Integer,String> hm1:m.entrySet()) {
			System.out.println("Key : "+hm1.getKey()+",Value : "+hm1.getValue());
		}
		m.putIfAbsent(4,"New");
		m.putIfAbsent(3,null);
		m.putIfAbsent(7,null);
		m.putIfAbsent(8,null);
		m.putIfAbsent(null,null);
		m.putIfAbsent(null,"Vikram");
		m.putIfAbsent(9,null);
		m.putIfAbsent(9,"Rajendra");
		System.out.println("After Put If Absent");
		for(Map.Entry<Integer,String> hm1:m.entrySet()) {
			System.out.println("Key : "+hm1.getKey()+",Value : "+hm1.getValue());
		}
		System.out.println("After Put If Absent after inserting null");
		m.putIfAbsent(5,null);
		for(Map.Entry<Integer,String> hm1:m.entrySet()) {
			System.out.println("Key : "+hm1.getKey()+",Value : "+hm1.getValue());
		}
		System.out.println("contains key"+m.containsKey(2));
		System.out.println("contains value"+m.containsValue("Ramesh"));
		System.out.println("Entry Set : "+m.entrySet());
		System.out.println("Entry Set : "+m.entrySet().contains("Coconut"));
		System.out.println("Equals : "+m.equals("V"));
		System.out.println("Equals : "+m.equals("Coconut"));
		Map<Integer,String> m1=new LinkedHashMap<Integer,String>();
		m1.putAll(m);
		System.out.println("Map m1 : ");
		for(Map.Entry<Integer,String> v:m1.entrySet()) {
			System.out.println("Key : "+v.getKey()+",Value : "+v.getValue());
		}
		System.out.println("Equals comparing entire object : "+m.equals(m1));
		System.out.println("Get : "+m1.get(2));//get takes only key
		System.out.println("HashCode : "+m1.hashCode());
		System.out.println("Is Empty : "+m.isEmpty());
		System.out.println("Size : "+m.size());
		System.out.println("Values : "+m.values());
		m1.putIfAbsent(6,"Cricket");
		System.out.println("Map m1 after putIfAbsent : ");
		for(Map.Entry<Integer,String> v:m1.entrySet()) {
			System.out.println("Key : "+v.getKey()+",Value : "+v.getValue());
		}

	}

}
