package com.celcom.day4;

class Animal2 {
	String a=move();
    String move() {
		return "A";
	}
}

class Cat2 extends Animal2 {
	String move() {
		return "B";
	}
}



public class MethodOverridingExample4 {

	public static void main(String[] args) {
		Animal2 animal = new Cat2();//DMD
		System.out.println(animal.a);
		Animal2 animal1=new Animal2();
		System.out.println(animal1.a);
		Cat2 c = new Cat2();
		System.out.println(c.a);
		
	}

}
