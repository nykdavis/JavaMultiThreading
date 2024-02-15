package com.davis.piersqure.executors.misc;

public class ThreadLocalPractice {
	
	private static final ThreadLocal<Integer> threadLocalVariable = ThreadLocal.withInitial(()->0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task =()->{
			int value = threadLocalVariable.get();
			value++;
			threadLocalVariable.set(value);
			System.out.println("Thread Name :"+ Thread.currentThread().getName()+" Thread Value: "+threadLocalVariable.get());
		};
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();

	}

}
