package com.celcom.day3;
/*Single Inheritance */
class Vehicle {
	void noOfEngine() {
		System.out.println("I have one engine");
	}
}

class TwoWheeler extends Vehicle {
	void noOfWheels() {
		System.out.println("I have two wheels");
	}
}

public class MainClass {

	public static void main(String[] args) {
		TwoWheeler two = new TwoWheeler();
		two.noOfEngine();
		two.noOfWheels();

	}

}
