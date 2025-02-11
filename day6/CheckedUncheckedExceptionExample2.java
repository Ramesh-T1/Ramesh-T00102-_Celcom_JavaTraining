package com.celcom.day6;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedUncheckedExceptionExample2 {
	static void m1() throws FileNotFoundException {
		FileReader f = new FileReader("Test.txt");
	}

	static void m2() {
		try {
			m1();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)/* throws FileNotFoundException */ {
		// TODO Auto-generated method stub
	/*	try {
			CheckedUncheckedExceptionExample2.m1();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} */
		//CheckedUncheckedExceptionExample2.m1();
	}
}
