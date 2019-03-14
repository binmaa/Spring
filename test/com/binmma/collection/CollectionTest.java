package com.binmma.collection;

import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void BlockingQueue(){
		final LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<String>(2);
		new Thread(){
			@Override
			public void run(){
				try {
					this.sleep(1000*10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String poll = linkedBlockingDeque.poll();
				System.out.println("队首移除了："+poll);
				
				for (String string : linkedBlockingDeque) {
					System.out.println("linkedBlockingDeque:"+string);
				}
			}
		}.start();
		try {
			linkedBlockingDeque.put("1");
			linkedBlockingDeque.put("2");
			System.out.println("----------2");
			linkedBlockingDeque.put("3");
			System.out.println("----------3");
			linkedBlockingDeque.put("4");
			System.out.println("----------4");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------");
//		linkedBlockingDeque.add("1");
//		linkedBlockingDeque.add("1");
//		linkedBlockingDeque.add("1");
	}

}
