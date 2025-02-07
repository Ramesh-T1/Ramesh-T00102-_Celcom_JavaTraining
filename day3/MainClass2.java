package com.celcom.day3;

/*Multilevel Inheritance */
class Vehicle1 {
	void noOfEngine() {
		System.out.println("I have one engine");
	}
}

class TwoWheeler1 extends Vehicle {
	void noOfWheels() {
		System.out.println("I have two wheels");
	}
}

class Bike extends TwoWheeler{
	void brandName() {
		System.out.println("My brand name is HONDA");
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		Bike two = new Bike();
		two.noOfEngine();
		two.noOfWheels();
		two.brandName();

	}

}
