package com.binmma.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
class MyRunnable implements Runnable{
	ThreadLocal l;
	public MyRunnable(ThreadLocal l) {
		this.l = l;
	}

	@Override
	public void run() {
		Object object = l.get();
		System.out.println(Thread.currentThread()+String.valueOf(object));
		l.set(2);
		
	}
}
public class Thread4Method {
	CountDownLatch down = new CountDownLatch(1);
	@Test
	public void threadLocal(){
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
			@Override
			public Integer initialValue(){
				return 1;
			}
		};
		new Thread(new MyRunnable(threadLocal)).start();
		new Thread(new MyRunnable(threadLocal)).start();
		
	}
	@Test
	public void single() throws InterruptedException{
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		MyThread A = new MyThread("A");
		MyThread B = new MyThread("B");
		executorService.submit(A);
		executorService.submit(B);
//		executorService.execute(B);
//		executorService.execute(A);
//		B.start();
//		A.start();
		Thread.currentThread().sleep(1000*5);
		new MyThread("C").start();
		down.await();
	}
	
	@Test
	public void join(){
		Thread A = new Thread("A"){
			public void run(){
				try {
					sleep(1000*15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() +" 执行结束");
			}
		};
		Thread B = new Thread("B"){
			public void run(){
				try {
					sleep(1000*10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() +" 执行结束");
			}
		};
		B.start();
		A.start();
		try {
			B.join();
			System.out.println("B执行结束啦");
			A.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test 执行结束");
	}
	
	@Test
	public void t4() throws InterruptedException, ExecutionException{
		Thread4 thread4 = new Thread4();
		FutureTask<Map<String, Integer>> futureTask = new FutureTask<Map<String,Integer>>(thread4);
		Thread thread = new Thread(futureTask);
		thread.start();
		Map<String, Integer> map = futureTask.get();
		System.out.println(map);
	}
	@Test
	public void t1() throws InterruptedException{
		Thread1 t1 = new Thread1(down);
		t1.start();
		down.await();
		System.out.println("执行结束");
	}
	@Test
	public void t3() throws InterruptedException{
		Thread3 t3 = new Thread3(down,"研发经理");
		Thread3 t1 = new Thread3(down,"小小程序员");
		t1.start();
		t3.start();
		Thread.currentThread().sleep(1000*3);
		down.countDown();
		Thread3 t2 = new Thread3(down,"需求");
		t2.start();
		System.out.println("执行结束");
	}
	@Test
	public void t2() throws InterruptedException{
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
		new Thread(new Thread2(cyclicBarrier, "部门经理")).start();
		Thread.currentThread().sleep(1000*10);
		new Thread(new Thread2(cyclicBarrier, "小小程序员")).start();
		
		new Thread(new Thread2(cyclicBarrier, "部门经理")).start();
		Thread.currentThread().sleep(1000*10);
		new Thread(new Thread2(cyclicBarrier, "小小程序员")).start();
		down.await();
	}
}
class Thread2 implements Runnable{
	private CyclicBarrier barrier;
	private String name;
	public Thread2(CyclicBarrier barrier,String name){
		this.barrier = barrier;
		this.name = name;
	}
	@Override
	public void run(){
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("开始执行："+name);
	}
}
class Thread1 extends Thread{
	private CountDownLatch countDownLatch;
	public Thread1(CountDownLatch down){
		countDownLatch = down;
	}
	@Override
	public void run(){
		System.out.println("方式1");
		countDownLatch.countDown();
	}
}

class Thread3 extends Thread{
	private CountDownLatch countDownLatch;
	public Thread3(CountDownLatch down,String name){
		countDownLatch = down;
		this.setName(name);
	}
	@Override
	public void run(){
		try {
			countDownLatch.await();
			long count = countDownLatch.getCount();
			System.out.println("count"+count);
			
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		};
		System.out.println("方式3："+getName());
	}
}

class Thread4 implements Callable<Map<String,Integer>>{
	@Override
	public Map<String, Integer> call() throws Exception {
		Map<String, Integer> result = new HashMap<String,Integer>();
		Thread.currentThread().sleep(1000*10);
		result.put(Thread.currentThread().getName(), 1);
		return result;
	}
	
}
class MyThread extends Thread{
	ReentrantLock lock = new ReentrantLock();
	Condition c = lock.newCondition();
	public MyThread(String name){
		setName(name);
	}
	public void run(){
		lock.lock();
			if(StringUtils.equals(getName(), "B")){
				try {
					System.out.println("B before");
					c.await();
//					MyThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(getName() +" end");
			if(StringUtils.equals(getName(), "A")||StringUtils.equals(getName(), "C")){
//				MyThread.class.notify();
				c.signal();
			}
		lock.unlock();
	}
}