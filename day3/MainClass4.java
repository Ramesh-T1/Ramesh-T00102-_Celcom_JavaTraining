package com.celcom.day3;

class Vehicle4 {
	String name = "I am a SuperClass Variable";

	Vehicle4() {
		System.out.println("I am a super class construtor");
	}

	void noOfEngine() {
		System.out.println("I have one engine");
	}
}

class TwoWheeler4 extends Vehicle4 {
	TwoWheeler4() {
		super();
	}

	void noOfWheels() {
		super.noOfEngine();//Superclass method is called
		System.out.println("I have two wheels");
		System.out.println(super.name);//Superclass variable is called
	}
}

public class MainClass4 {

	public static void main(String[] args) {
		TwoWheeler4 two = new TwoWheeler4();
		two.noOfWheels();

	}

}
