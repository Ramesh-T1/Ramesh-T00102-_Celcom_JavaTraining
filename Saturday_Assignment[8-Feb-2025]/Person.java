package com.Assignment2;

public class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name of Person : " + name);
		System.out.println("Age of Person : " + age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Ramesh", 30);
		p1.display();
		Person p2 = new Person("Varsha", 25);
		p2.display();
	}

}
