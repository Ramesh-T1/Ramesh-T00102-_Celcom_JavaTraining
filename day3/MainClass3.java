package com.celcom.day3;

/*Hierarchial Inheritance */
class Vehicle2 {
	void noOfEngine() {
		System.out.println("I have one engine");
	}
}

class TwoWheeler2 extends Vehicle {
	void noOfWheels() {
		System.out.println("I have two wheels");
	}
}

class Bike1 extends TwoWheeler2{
	void brandName() {
		System.out.println("My brand name is HONDA");
	}
}
class Scooty extends TwoWheeler2{
	void brandName() {
		System.out.println("My brand name is Activa");
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		Bike1 two = new Bike1();
		two.noOfEngine();
		two.noOfWheels();
		two.brandName();
		Scooty s=new Scooty();
		s.brandName();

	}

}
