package com.celcom.day6;

public class ObjectAssignmentExample1 {

	public static void main(String[] args) {
		ObjectAssignmentExample1 obj1=new ObjectAssignmentExample1();
		System.out.println(obj1.hashCode());
		ObjectAssignmentExample1 obj2=obj1;//One object two reference
		//System.out.println(obj2);
		System.out.println(obj2.hashCode());
		

	}

}
