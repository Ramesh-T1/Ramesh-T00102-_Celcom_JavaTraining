package com.celcom.day2;

public class TypesOfMethodsInJava {
	void m1() {
		System.out.println("Instance Method");
	}
	static void m2() {
		System.out.println("Static Method");
	}

	public static void main(String[] args) {
		TypesOfMethodsInJava obj=new TypesOfMethodsInJava();
		obj.m1();
		TypesOfMethodsInJava.m2();

	}

}
