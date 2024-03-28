package com.davis.practice;

public class UsingRunnableInterface implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0;i< 5; i++) {
			System.out.println("THread name :"+Thread.currentThread().getName()+ " counter :"+i);
		}
		
	}

	public static void main(String[] args) {
		
		UsingRunnableInterface thread1 = new UsingRunnableInterface();
		Thread t1 = new Thread(thread1);
		
		UsingRunnableInterface thread2 = new UsingRunnableInterface();
		Thread t2 = new Thread(thread2);
		
		t1.start();
		t2.start();
		
		
	}

	

}
