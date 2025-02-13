package com.celcom.day8;

public class StringExample3 {

	public static void main(String[] args) {
		String s1="Java";
		//s1.concat("World");
		//System.out.println(s1);//Java
		s1=s1.concat("World");
		System.out.println(s1);//JavaWorld
		StringBuffer sb=new StringBuffer("Angular");
		sb.append(" Javascript");
		System.out.println(sb);
		StringBuilder sb1=new StringBuilder("Java");
		sb1.append("Programming");
		System.out.println(sb1);
	}
}
