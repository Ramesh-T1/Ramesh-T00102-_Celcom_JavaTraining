package com.celcom.day2;

import java.util.Arrays;

public class ArraySortingExample {

	public static void main(String[] args) {
		int arr[] = { 2, 6, 7, 8, 9, 5 };
		Arrays.sort(arr);
		// Ascending order
		for (int index = 0; index < arr.length; index++) {
			System.out.println(arr[index] + "");
		}
		System.out.println("Minimum Value : " + arr[0]);
		System.out.println("Second Minimum Value :" + arr[1]);
		System.out.println("Maximum value:" + arr[arr.length - 1]);
		System.out.println("Second Maximum Value :" + arr[arr.length - 2]);
		// Descending order
		for (int index = arr.length - 1; index >= 0; index--) {
			System.out.println(arr[index] + "");
		}

	}

}
