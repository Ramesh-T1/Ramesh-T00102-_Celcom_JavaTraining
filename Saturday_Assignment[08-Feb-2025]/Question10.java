package com.Assignment2;

class Shape{
	int length,breadth,area;
	Shape(int length,int breadth){
		this.length=length;
		this.breadth=breadth;
	}
	public void getArea() {
		
	}
}
class Rectangle1 extends Shape{
	Rectangle1(int length, int breadth) {
		super(length, breadth);
	}

	public void getArea() {
		area=length*breadth;
		System.out.println("Area = "+area);
	}
}
public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle1 r=new Rectangle1(10,10);
		r.getArea();
		Shape s=new Shape(20,20);
		s.getArea();//It calls superClass get area method which prints nothing
		Shape s1=new Rectangle1(5,5);
		s1.getArea();

	}

}
