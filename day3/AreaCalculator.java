package com.celcom.day3;

import java.util.Scanner;

class Shape {
	double radius,length,breadth;
	Shape(double radius)
	{
		this.radius=radius;
	}
	Shape(double length,double breadth){
		this.length=length;
		this.breadth=breadth;
	}
	public void calculate(){
		
	}
}
class Circle extends Shape{
	//double area;
	Circle(double r) {
		super(r);
		this.calculate();
	}
	public void calculate(){
		double area=3.14*radius*radius;
		System.out.println("Area of circle with radius "+radius+" = "+area);
	}
	
}
class Rectangle extends Shape{
	double area;
	Rectangle(double l,double b){
		super(l,b);
		this.calculate();
	}
	public void calculate() {
		area=length*breadth;
		System.out.println("Area of Rectangle with length "+length+" and breadth "+breadth+" = "+area);
	}
}
class Triangle extends Shape{
	double area;
	Triangle(double l,double b) {
		super(l,b);
		this.calculate();
	}
	public void calculate() {
		area=0.5*length*breadth;
		System.out.println("Area of Triangle with base "+length+" and height "+breadth+" = "+area);
	}
	
}

public class AreaCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1-Area of Circle,2-Area of Rectangle,3-Area of triangle");
		int c=sc.nextInt();
		switch(c) {
		case 1: Shape s=new Circle(3);
		        break;
		case 2:Shape s1=new Rectangle(3,4);
		       break;
		case 3:Shape s2=new Triangle(5,6);
		       break;
		default:System.out.println("Please Enter proper choice");
		}
	}
}
