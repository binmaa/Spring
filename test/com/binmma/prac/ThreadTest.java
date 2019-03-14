package com.binmma.prac;

import org.junit.Test;

class MyThread extends Thread{
	public MyThread(){}
	public MyThread(String name) {
		this.setName(name);
	}
	private int count = 5;
	@Override
	public void run(){
		while(count>0){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count--;
			System.out.println(getName()+"...."+String.valueOf(count)+"..."+this.isAlive());
		}
	}
}

class MyRunnable implements Runnable{
	private int count = 5;
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName());
		while(count>0){
			count--;
//			System.out.println(get);
		}
	}
}
public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		MyThread thread = new MyThread();
		Thread threadA = new Thread(thread,"A");
		Thread threadB = new Thread(thread,"B");
		Thread threadC = new Thread(thread,"C");
		threadA.start();
		threadB.start();
		threadC.start();
		Thread.currentThread().wait(10*1000);
		System.out.println(Thread.currentThread()+"..."+threadA.isAlive());
//		MyThread myThread1 = new MyThread("A");
//		MyThread myThread2 = new MyThread("B");
//		MyThread myThread3 = new MyThread("C");
//		myThread1.start();
//		myThread2.start();
//		myThread3.start();
	}

}
