package com.celcom.day7;

public class ThreadExample1 {

	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		System.out.println(t);
		System.out.println("Current Thread ID : "+t.getId());
		System.out.println("Current Thread Name : "+t.getName());
		System.out.println("Current Thread Priority : "+t.getPriority());
		System.out.println("Current Thread Group Name : "+t.getThreadGroup());

	}

}
