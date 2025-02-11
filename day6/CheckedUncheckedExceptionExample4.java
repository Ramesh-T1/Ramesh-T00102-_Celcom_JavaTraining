package com.celcom.day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class InvalidAgeException extends Exception{
	int age;
	InvalidAgeException(int age){
		this.age=age;
	}

	@Override
	public String toString() {
		//return "InvalidAgeException [toString()=" + super.toString() + "]";
		return age+" Invalid Age for Voting";
	}
}
public class CheckedUncheckedExceptionExample4 {
	 public static void main(String[] args) {
		 System.out.println("Enter your age");
		 int age=new Scanner(System.in).nextInt();
		 if(age>18) {
			 System.out.println("Welcome to vote");
		 }else {
			 try {
				 throw new InvalidAgeException(age);
			 }catch(InvalidAgeException e) {
				 System.out.println(e);
			 }
		 }
	 }
}
