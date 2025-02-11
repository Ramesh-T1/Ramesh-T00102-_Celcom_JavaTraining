package com.celcom.day6;

import java.util.Scanner;

class DoesnotContainsVowelsException extends Exception{

	@Override
	public String toString() {
		return "DoesnotContainsVowelsException";
	}
	
}

public class Assignment2 {
	public static boolean containsVowels(String string) {
		for(char i:string.toCharArray()) {
			char ch=Character.toLowerCase(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String s=sc.next();
		try {
			if(!containsVowels(s)) {
				throw new DoesnotContainsVowelsException();
			}
			else {
				System.out.println("String contains vowels");
			}
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		}

	}

}
