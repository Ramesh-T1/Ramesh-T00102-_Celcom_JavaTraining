package com.celcom.day3;

public class ThisKeywordExample1 {
	String name;
	ThisKeywordExample1(){
		this("ramesh");
	}
	ThisKeywordExample1(String name){
		this.name=name;
		this.greeting();
	}
	void greeting() {
		System.out.println("Welcome "+name);
	}

	public static void main(String[] args) {
		ThisKeywordExample1 obj=new ThisKeywordExample1();

	}

}
