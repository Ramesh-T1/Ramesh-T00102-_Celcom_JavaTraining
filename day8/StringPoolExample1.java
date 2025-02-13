package com.celcom.day8;

public class StringPoolExample1 {

	public static void main(String[] args) {
		// == vs equals()
		String s1 = new String("Java");
		String s2 = new String("Java");
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		String s3="Java";
		String s4="Java";
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
	}
}
