package com.celcom.day7;

interface MyInterface {
	public void display();
}

public class AnonymousInnerClass implements MyInterface {
	public void display() {
      System.out.println("Normal way");
	}

	public static void main(String[] args) {
		AnonymousInnerClass obj = new AnonymousInnerClass();
		obj.display();
		MyInterface obj1 = new MyInterface() {
			@Override
			public void display() {
				System.out.println("Display");
			}
		};
		obj1.display();
		/* Alternate way 
		new MyInterface() {

			@Override
			public void display() {
				System.out.println("Display");
			}
		}.display();*/
		//Lambda Expression
		MyInterface obj2=()->System.out.println("Display Lambda Expression");
		obj2.display();
	}

}
