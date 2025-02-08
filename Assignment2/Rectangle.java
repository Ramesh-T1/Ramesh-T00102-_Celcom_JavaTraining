package com.Assignment2;

public class Rectangle {
	float length, width, area, perimeter;

	public Rectangle(float length, float width) {
		super();
		this.length = length;
		this.width = width;
		this.calculateArea();
		this.calculatePerimeter();

	}

	public void calculateArea() {
		area = length * width;
		System.out.println("Area of rectangle with length " + length + " and width " + width + " = " + area);

	}

	public void calculatePerimeter() {
		perimeter = 2 * (length + width);
		System.out.println("Perimeter of rectangle with length " + length + " and width " + width + " = " + perimeter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle(3.4f, 5.6f);

	}

}
