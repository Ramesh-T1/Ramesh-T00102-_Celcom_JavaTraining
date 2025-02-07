package com.celcom.day4;

public class MethodOverloadingExample2 {
	void addition(int a,int b) {
		System.out.println("Integer Addition : "+(a+b));
	}
	void addition(double a,double b) {
		System.out.println("Double addition : "+(a+b));
	}
   void addition(long a,long b) {
	   System.out.println("Long Addition : "+(a+b));
   }
    
	public static void main(String[] args) {
		MethodOverloadingExample2 obj=new MethodOverloadingExample2();
		obj.addition(10.5,20.0);
		obj.addition(10,20);
		obj.addition(20L,30L);

	}

}
