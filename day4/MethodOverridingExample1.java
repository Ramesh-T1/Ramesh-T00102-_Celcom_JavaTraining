package com.celcom.day4;

class SuperClass{
	void myMethod() {
		System.out.println("I am from Super Class");
	}
}
class SubClass extends SuperClass{
	void myMethod() {
		System.out.println("I am from SubClass");
	}
}
public class MethodOverridingExample1 {

	public static void main(String[] args) {
		//Method calling depends on the object getting created
		SubClass obj=new SubClass();
		obj.myMethod();
		SuperClass obj1=new SuperClass();
		obj1.myMethod();
		SuperClass obj2=new SubClass();//DMD
		obj2.myMethod();

	}

}
