package com.celcom.day7;

class MyThread extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("My thread running......");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

public class ThreadExample2 {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		System.out.println(t1.getState());
		//System.out.println(t1.getName());
		t1.setName("T1");
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		//To Start thread
		t1.start(); //Starting or running my thread T1
		//after start main thread and thread t1 both will execute simultaneously
		Thread.sleep(2000);
		System.out.println("Main End");
	}
}
