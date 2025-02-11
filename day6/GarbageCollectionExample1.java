package com.celcom.day6;

public class GarbageCollectionExample1 {
	static int count;
	GarbageCollectionExample1(){
		count++;
		System.out.println(count);
	}
	protected void finalize() {
		count--;
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GarbageCollectionExample1 obj1=new GarbageCollectionExample1();
		GarbageCollectionExample1 obj2=new GarbageCollectionExample1();
		obj1=null;
		System.gc();
		obj2=null;
		Runtime.getRuntime().gc();

	}

}
