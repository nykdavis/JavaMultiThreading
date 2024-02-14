package com.davis.piersqure.executors.concurrentUtilities;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(2);
		
		Runnable sharedTask = () ->{
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName()+" accessing resource. ");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" relaesing resource. ");
				semaphore.release();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		for(int i=1; i<=5; i++) {
			new Thread(sharedTask).start();
		}

	}

}
