package com.Assignment2;

class Animal{
	public void makeSound() {
		
	}
}

class Cat extends Animal{
	public void makeSound() {
		System.out.println("Cat says meow");
	}
}

public class MasterQ8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Cat();
		a.makeSound();

	}

}
