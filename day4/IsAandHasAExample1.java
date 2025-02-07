package com.celcom.day4;

class Vehicle{
	void engine() {
		System.out.println("All vehicle has a One engine");
	}
	void wheels() {
		System.out.println("All vehicles has a wheel");
	}
}
class Wheels{
	void wheelModel() {
		System.out.println("Wheel model is MRF");
	}
	void noOfWheels(String vehicleType) {
		if(vehicleType.equals("Two Wheeler")) {
			System.out.println("I have Two wheels");
		}else if(vehicleType.equals("Four Wheeler")){
			System.out.println("I have four wheels");
		}
	}
}
class Engine{
	void engineModel() {
		System.out.println("Engine model is XYZ");
	}
}
class Car extends Vehicle{//IS-A
	Wheels wheel=new Wheels();//HAS-A
	Engine engine=new Engine();//HAS-A
	void engineModel() {
		engine.engineModel();
	}
	void wheelModel() {
		wheel.wheelModel();
	}
	void noOfWheels() {
		wheel.noOfWheels("Four Wheeler");
	}
	
}
public class IsAandHasAExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.engine();
		car.engineModel();
		
		car.wheels();
		car.wheelModel();
		car.noOfWheels();

	}

}
