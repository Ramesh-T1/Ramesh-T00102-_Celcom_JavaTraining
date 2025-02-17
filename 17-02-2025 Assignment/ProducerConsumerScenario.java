package com.self.assignment;

class MyData{
	int value;
	boolean flag=true;
	synchronized void set(int v) {
		while(flag!=true)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		value=v;
		flag=false;
		notify();
	}
	synchronized int get() {
		int x=0;
		while(flag!=false)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		x=value;
		flag=true;
		notify();
		return x;
	}
}

class Producer1 extends Thread{
	MyData d;
	Producer1(MyData data){
		d=data;
	}
	public void run() {
		int i=1;
		while(i<=100) {
			d.set(i);
			System.out.println("Producer : "+i);
			i++;
		}
	}
}
class Consumer1 extends Thread{
	MyData d;
	Consumer1(MyData data){
		d=data;
	}
	public void run() {
		while(true) {
			System.out.println("Consumer : "+d.get());
		}
	}
}

public class ProducerConsumerScenario {

	public static void main(String[] args) {
		MyData md=new MyData();
		Producer1 p=new Producer1(md);
		Consumer1 c=new Consumer1(md);
		p.start();
		c.start();
	}

}
