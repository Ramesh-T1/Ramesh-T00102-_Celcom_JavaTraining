package com.celcom.day7;

class MyThread1 implements Runnable {
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

public class ThreadExample3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyThread1());
		System.out.println(t1.getState());
		//System.out.println(t1.getName());
		t1.setName("T1");
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		//To Start thread
		t1.start(); //Starting or running my thread T1 //It gets executed and thread starts
		//after start main thread and thread t1 both will execute simultaneously
		Thread.sleep(2000);//After MyThread1 goes to sleep this line gets executed and main thread goes to sleep/waiting state
		System.out.println("Main End");
		t1.suspend();
		System.out.println(t1.getState());
		t1.resume();
		System.out.println(t1.getState());  
	/*	Thread t1=new Thread(new MyThread1());
		t1.setName("T1");
		Thread t2=new Thread(new MyThread1());
		t2.setName("T2");
		t1.start();
		t2.start(); */
		
	}
}
