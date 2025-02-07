package com.celcom.day3;
class A2{
	A2(){
		System.out.println("A");
	}
	A2(int a){
		System.out.println("A 1");
	}
}
class B2 extends A2{
	B2(){
		this(10);
		System.out.println("B");
	}
	B2(int a){
		super(10);
		System.out.println("B 1");
	}
}
public class SuperKeywordExample3 {

	public static void main(String[] args) {
		B2 b2=new B2();

	}

}
