package com.celcom.day7;

public class ThreadWithAnonymousInnerClassExample1 {

	public static void main(String[] args) {
		//Creating Thread Using AnonymousInnerClass
		Runnable runnable=new Runnable() {

			@Override
			public void run() {
				for(int i=1;i<=5;i++) {
					//System.out.println("Thread t1 is running .....");
					System.out.println(i+" * 2 = "+(i*2));
					try {
						Thread.sleep(2000);
					}catch(InterruptedException e) {
						
					}
				}
				
			}
			
		};
		Thread t1=new Thread(runnable);
		t1.start();
		
		//Creating thread using Lambda expression
		Runnable runnable1=()->{
			for(int i=1;i<=5;i++) {
				//System.out.println("Thread t2 is running....");
				System.out.println(i+" * 5 = "+(i*5));
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					
				}
			}
		};
		Thread t2=new Thread(runnable1);
		t2.start();
	}

}
