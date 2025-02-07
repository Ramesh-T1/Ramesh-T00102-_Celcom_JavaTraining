package com.celcom.day2;

public class ArrayExample1 {

	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50};
		int sum=0;
		System.out.println("Array Length : "+arr.length);
		System.out.println("Array Elements : ");
		for(int index=0;index<arr.length;index++) {
			System.out.println(arr[index]);
			sum=sum+arr[index];
		}
       System.out.println("Sum of Array : "+sum);
       for(int value:arr) {
    	   System.out.println("Array elements : "+value);
       }
	}

}
