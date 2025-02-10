package com.celcom.day5;

interface VehiclePlan{
	void noOfEngine();//public abstract
	void noOfWheels();
	void brandName();
}

abstract class VehicleZ implements VehiclePlan{
	public void noOfEngine() {
		System.out.println("I have one Engine");
	}
}

class CarZ extends VehicleZ{
	public void noOfWheels() {
		System.out.println("I have Four Wheels");
	}
	public void brandName() {
		System.out.println("My Brand Name Benz");
	}
}
public class InterfaceExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehiclePlan v=new CarZ();
		v.noOfEngine();
		v.noOfWheels();
		v.brandName();
	}

}
