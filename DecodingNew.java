package com.celcom.day11;

import java.util.Scanner;

public class DecodingNew {
	static String text;
	public static String check(int temp) {
		switch (temp) {
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
		    return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		case 9:
			return "I";
		case 10:
			return "J";
		case 11:
			return "K";
		case 12:
			return "L";
		case 13:
			return "M";
		case 14:
			return "N";
		case 15:
			return "O";
		case 16:
			return "P";
		case 17:
			return "Q";
		case 18:
			return "R";
		case 19:
			return "S";
		case 20:
			return "T";
		case 21:
			return "U";
		case 22:
			return "V";
		case 23:
			return "W";
		case 24:
			return "X";
		case 25:
			return "Y";
		case 26:
			return "Z";
		}
		
		return text;
		
	}
	public static String decodeOneDigit(String sn) {
		String s,result3 = "",sn1,result1="";
		s=sn;
		char temp;
		int rev = 0, t1,n,i,count=0,m,j;
		for(i=0;i<s.length();i++) {
			temp=s.charAt(i);
			t1=Character.getNumericValue(temp);
			result3=result3+check(t1);
		}
		return result3;
	}

	public static void main(String[] args) {
		String s,result = "",sn,result1="",result2="",result3="",temp2;
		char temp;
		int rev = 0, t,n,i,count=0,m,j,t1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String or Code of Numbers upto 6 digits : ");
		s = sc.next();
		//Single digit combination
		for(i=0;i<s.length();i++) {
			temp=s.charAt(i);
			t=Character.getNumericValue(temp);
			result=result+check(t);
		}
		System.out.println("Code formed by single digit :"+result);
		if(result!=null) {
			count++;
		}
		//Sequential two digit combination
		j=1;
		for(i=0;i<s.length();i++) {
			++j;
			if(j<=s.length()) {
				sn=s.substring(i,j);		
			t=Integer.parseInt(sn);
			  if(t>=10&&t<=26) {
				result1=result1+check(t);
			   }
			}		
		}
		System.out.println("Code formed by two digit :"+result1);
		if(result1!=null) {
			count=count+result1.length();
			System.out.println("Number of Possibilities : "+count);
		}
		//Remaining two digits posibilities with one at a time for more than three digits and three digits
		if(result1.length()!=1){
		if (s.length() % 2 == 0) {
			j = 2;
			for (i = 0; i < s.length(); i++) {
				if (j <= s.length()) {
					temp2 = s.substring(i, j);
					//System.out.println("Temp2:" + temp2);
					t1 = Integer.parseInt(temp2);
					//System.out.println("t1:" + temp2);
					if (t1 > 10 && t1 < 26) {
						result3 = result3 + check(t1);
					}
				}
				i++;
				j++;
				j++;
			}
		} else {
			j = 2;
			for (i = 0; i < s.length(); i++) {
				if (j <= s.length()) {
					temp2 = s.substring(i, j);
					//System.out.println("Temp2:" + temp2);
					t1 = Integer.parseInt(temp2);
					//System.out.println("t1:" + temp2);
					if (t1 >= 10 && t1 <= 26) {
						result3 = result3 + check(t1);
					}
				}
				i++;
				j++;
				j++;
			}
			int t2 = Integer.parseInt(s);
			int temp3 = t2;
			int g = temp3 % 100;
			System.out.println("Temp3/g:" + g);
			if (g >= 10 && g <= 26) {
				result3 = result3 + check(g);
			}
		}
		}

		System.out.println("Remaining Code formed by two digit :" + result3);
		if (result3 != null) {
			count = count + result3.length();
			System.out.println("Number of Possibilities : " + count);
		}
      //Correct answer with 12123--->8 possibilities
		//correct answer with 12521--->6 possibilities
		//correct answer with 81727--->1 possibilities,80727--->1,14344--->2,333--->1
		//15326-->5,11111---->8
		
	}

}
