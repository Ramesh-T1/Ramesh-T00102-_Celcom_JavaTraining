package com.celcom.day4;

public class JavaBlockExample1 {
	JavaBlockExample1(){
		System.out.println("constructor");
	}
	{
		System.out.println("Instance Block");
	}
	static {
		System.out.println("static block");
	}
	public String toString() {
		return "To String";
	}

	public static void main(String[] args) {
		System.out.println("Main method block");
		JavaBlockExample1 obj=new JavaBlockExample1();
		System.out.println(obj);

	}

}
