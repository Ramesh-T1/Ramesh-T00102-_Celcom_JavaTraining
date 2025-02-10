package com.celcom.day5;

interface One{
	int a=10;//By default interface variable are public static final
}
interface Two{
	int b=20;
	//int a=20;
}
interface Three extends One,Two{
	void addition();
}
class Addition implements Three{

	@Override
	public void addition() {
		// TODO Auto-generated method stub
		System.out.println("Addition of Numbers = "+(a+b));
		//System.out.println("Addition of Numbers = "+(One.a+Two.a));//Calling using interface name as variable is static by default
	}	
}

public class MultipleInheritanceExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addition ex=new Addition();
		ex.addition();

	}

}
