package com.celcom.day6;

import java.util.Scanner;
class DuplicateNumber extends Exception{
    int a;
    DuplicateNumber(int a){
    	this.a=a;
    }
	@Override
	public String toString() {
		//return "DuplicateNumber [a=" + a + "]";
		return a+" = DuplicateNumber";
	}
   
	
}

public class Assignment1 {

	public static void main(String[] args) {
		int a[]=new int[10],i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter integers for array");
		for(i=0;i<10;i++) {
			a[i]=sc.nextInt();
			int temp=a[i];
			for(j=0;j<i;j++) {
				try {
			    if(a[j]==temp)
			    {
			    	throw new DuplicateNumber(a[j]);
			    }}catch(Exception e) {
			    	System.out.println(e);
			    }
			}
		}
		
		

	}

}
