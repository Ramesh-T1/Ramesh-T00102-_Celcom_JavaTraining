package com.celcom.day3;

class Data {
	String os, brand;

	public void os(String obj) {
		os = obj;
	}

	public void brandName(String b) {
		brand = b;
	}

	public void display() {
		System.out.println("OS is = " + os);
		System.out.println("Brand is = "+brand);
	}
}

public class Mobile {

	public static void main(String[] args) {
		Data d = new Data();
		d.os("Android");
		d.brandName("Samsung");
		d.display();
		Data d1 = new Data();
		d1.os("IOS");
		d1.brandName("Iphone 15 pro");
		d1.display();

	}

}
