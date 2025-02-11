package com.celcom.day6;

public class FinallyExample1 {
	public static void main(String[] args) {
		System.out.println("Before Exception");
		try {
			//int a = 10 / 0;
			 int a = Integer.parseInt("Hello");
			// int arr[] = new int[-5];
			// System.out.println("Hi");
			// int arr[]= {10,20,30};
			// System.out.println(arr[3]);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}/* catch (NumberFormatException e) {
			System.out.println(e);
		} */catch (NegativeArraySizeException e) {
			System.out.println(e);
		}finally {
			System.out.println("Inside Finally");
		}
		System.out.println("After Exception");
	}
}
