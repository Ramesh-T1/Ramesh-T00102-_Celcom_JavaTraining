package com.celcom.day8;

import java.util.Calendar;

public class CalendarExample1 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));

	}

}
