package com.celcom.day7;

public class InnerClassExample1 {
	// 1-Non-Static Inner Class
	class InnerClass1 {
		void myMethod1() {
			System.out.println("Non-Static inner class");
		}
	}
    //2-Static Inner Class
	static class InnerClass2{
		void myMethod2() {
			System.out.println("Static Inner Class");
		}
	}
	
	void myMethod() {
		//3-Local inner class
		class InnerClass3{
			void myMethod3() {
				System.out.println("Local Inner Class");
			}
		}
		InnerClass3 inner3=new InnerClass3();
		inner3.myMethod3();
	}
	public static void main(String[] args) {
		InnerClassExample1 obj = new InnerClassExample1();
		// InnerClassExample1.InnerClass1 inner1=obj.new InnerClass1();
		InnerClass1 inner1 = obj.new InnerClass1();
		inner1.myMethod1();
		
		InnerClassExample1.InnerClass2 inner2=new InnerClassExample1.InnerClass2();
		inner2.myMethod2();
		
	}

}
