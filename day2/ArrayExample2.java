package com.celcom.day2;

import java.util.Scanner;

public class ArrayExample2 {

	public static void main(String[] args) {
		int arr[]=new int[5];
		int sum=0,evenCount=0,oddCount=0;
		System.out.println("Initial values of an Array");
		for(int index=0;index<arr.length;index++) {
			System.out.println(arr[index]);
		}
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 5 values");
        for(int index=0;index<arr.length;index++) {
        	arr[index]=sc.nextInt();
        }
      /*  for(int index=0;index<arr.length;index++) {
        	sum=sum+arr[index];
        }
        System.out.println("Sum Array : "+sum);*/
        for(int index=0;index<arr.length;index++) {
        	sum=sum+arr[index];
        	if(arr[index]%2==0)
        		evenCount++;
        	else
        		oddCount++;
        }
        System.out.println("Sum Array : "+sum);
        System.out.println("Even Count :"+evenCount);
        System.out.println("odd Count :"+oddCount);
        sc.close();
	}

}
