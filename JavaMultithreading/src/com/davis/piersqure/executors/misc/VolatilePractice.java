package com.davis.piersqure.executors.misc;

public class VolatilePractice {
	
	private static volatile boolean flag = false;

	public static void main(String[] args) {
		
		
		// Thread 1: Sets the flag to true
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Setting flag to true");
            flag = true;
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2: Reads the flag
        Thread thread2 = new Thread(() -> {
            while (!flag) {
                System.out.println("Inside while loop");
            }
            System.out.println("Thread 2: Flag is now true");
        });

        // Start both threads
        thread1.start();
        thread2.start();

	}

}
