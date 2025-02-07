package com.celcom.day3;

public class ThisKeywordExample2 {
	ThisKeywordExample2(){
		this("Valan");
		System.out.println("A");
	}
	ThisKeywordExample2(String name){
		this(10);
		System.out.println("B");
	}
	ThisKeywordExample2(int a){
		System.out.println("C");
	}

	public static void main(String[] args) {
		ThisKeywordExample2 obj1=new ThisKeywordExample2();

	}

}
