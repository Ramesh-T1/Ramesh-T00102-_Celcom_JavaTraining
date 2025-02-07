package com.celcom.day4;

public class MethodOverloadingExample3 {
	void concat(int a, int b) {
		//String s = a + "" + b;
		System.out.println("Integer concatenation : " +a+b);
	}

	void concat(String a, String b) {
		String s = a + b;
		System.out.println("Float concatenation : " + s);
	}

	void concat(double a, double b) {
		String s = a + "" + b;
		System.out.println("Double Concatenation :" + s);
	}

	public static void main(String[] args) {
		MethodOverloadingExample3 m = new MethodOverloadingExample3();
		m.concat(4, 6);
		m.concat("Ramesh", "Nadar");
		m.concat(20.5, 50.45);

	}

}
