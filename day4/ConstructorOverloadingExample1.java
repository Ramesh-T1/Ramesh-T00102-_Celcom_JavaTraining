package com.celcom.day4;

public class ConstructorOverloadingExample1 {
	ConstructorOverloadingExample1(int a,int b){
		this(45.22,89.34);
		System.out.println("Integer Overloading : "+(a+b));
	}
	ConstructorOverloadingExample1(double a,double b){
		this(4567L,1000L);
		System.out.println("Double Overloading : "+(a+b));
	}
	ConstructorOverloadingExample1(long a,long b){
		System.out.println("Long Overloading : "+(a+b));
	}
	public static void main(String[] args) {
		ConstructorOverloadingExample1 c=new ConstructorOverloadingExample1(19,23);
		//ConstructorOverloadingExample1 c2=new ConstructorOverloadingExample1(45.34,23.43);
		//ConstructorOverloadingExample1 c3=new ConstructorOverloadingExample1(3000L,4000L);
	}

}
