package com.celcom.day5;

interface VehiclePlan1{
	void noOfEngine();//public abstract
}
interface VehiclePlan2{
	void noOfWheels();
	void brandName();
}

abstract class VehicleZ1 implements VehiclePlan1,VehiclePlan2{
	VehicleZ1(){
		System.out.println("Constructor");
	}
}

class CarZ1 extends VehicleZ1{
	public void noOfWheels() {
		System.out.println("I have one Engine");
	}
	public void brandName() {
		System.out.println("My Brand Name Benz");
	}
	@Override
	public void noOfEngine() {
		System.out.println("I have one engine");
	}
}
public class InterfaceExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleZ1 v=new CarZ1();
		v.noOfEngine();
		v.noOfWheels();
		v.brandName();
	}

}
