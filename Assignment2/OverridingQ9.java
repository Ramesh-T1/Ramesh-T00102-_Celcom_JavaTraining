package com.Assignment2;

class Vehicle{
	public void drive() {
		
	}
}
class Car extends Vehicle{
	public void drive() {
		System.out.println("Repairing a Car");
	}
}

public class OverridingQ9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c=new Car();
		c.drive();

	}

}
