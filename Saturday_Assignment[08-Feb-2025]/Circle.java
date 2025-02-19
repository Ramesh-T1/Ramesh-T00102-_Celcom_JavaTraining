package com.Assignment2;

import java.util.Scanner;

public class Circle {
	double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double calculateArea() {
		return 3.14 * radius * radius;
	}

	public double calculateCircumference() {
		return 2 * 3.14 * radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Circle c = new Circle(9.4);
		System.out.println("Area of circle with radius " + c.radius + " = " + c.calculateArea());
		System.out.println("Circumference of circle with radius " + c.radius + " = " + c.calculateCircumference());
		System.out.println("Enter Radius");
		double r=sc.nextDouble();
		c.setRadius(r);
		System.out.println("Area of circle with radius " + c.radius + " = " + c.calculateArea());
		System.out.println("Circumference of circle with radius " + c.radius + " = " + c.calculateCircumference());
	}

}
