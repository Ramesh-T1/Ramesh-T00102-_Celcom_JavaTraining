package com.celcom.day5;

abstract class Vehicle {
	void noOfEngine() {
		System.out.println("I have one");
	}

	abstract void noOfWheels();

	abstract void brandName();

}

class Car extends Vehicle {
	void noOfWheels() {
		System.out.println("I have two wheels");
	}

	void brandName() {
		System.out.println("My brand name Benz");
	}
}

public class AbstractClassExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vec = new Car();
		vec.noOfEngine();
		vec.noOfWheels();
		vec.brandName();

	}

}
