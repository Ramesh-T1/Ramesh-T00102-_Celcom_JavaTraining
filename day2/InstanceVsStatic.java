package com.celcom.day2;

public class InstanceVsStatic {
	static int a=10;
    int b=30;
	public static void main(String[] args) {
		InstanceVsStatic obj1=new InstanceVsStatic();
		InstanceVsStatic obj2=new InstanceVsStatic();
		System.out.println(obj1.a);//10
		System.out.println(obj2.a);//10
		obj1.a=20;
		System.out.println(obj1.a);//20
		System.out.println(obj2.a);	//10
		InstanceVsStatic obj3=new InstanceVsStatic();
		InstanceVsStatic obj4=new InstanceVsStatic();
		System.out.println(obj3.b);//20
		System.out.println(obj4.b);//20
		obj3.b=40;
		System.out.println(obj3.b);//30
		System.out.println(obj4.b);	//30

	}

}
