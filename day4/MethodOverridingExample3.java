package com.celcom.day4;

class Animal1 {
	int a=10;
	void move() {
		System.out.println("Cannot define");
	}
}

class Cat1 extends Animal1 {
	int b=20;
	void move() {
		System.out.println("Cat will move by walk");
	}
}



public class MethodOverridingExample3 {

	public static void main(String[] args) {
		Animal1 animal;
		animal = new Cat1();
		animal.move();
		System.out.println(animal.a);//Animal is refernce of superclass so we get 10
	}

}
