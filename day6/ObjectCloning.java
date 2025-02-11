package com.celcom.day6;

public class ObjectCloning implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		ObjectCloning obj1 = new ObjectCloning();
		System.out.println(obj1.hashCode());
		ObjectCloning obj2 = (ObjectCloning) obj1.clone();//Object Cloning
		System.out.println(obj2.hashCode());

	}

}
