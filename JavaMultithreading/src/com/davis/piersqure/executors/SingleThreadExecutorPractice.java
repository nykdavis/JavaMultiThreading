package com.davis.piersqure.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutorPractice {

	public static void main(String[] args) throws InterruptedException {

		// Creating a single thread Executors Service
		ExecutorService service = Executors.newSingleThreadExecutor();

		// Define 1st task
		Runnable task1 = () -> {
			System.out.println("Task 1 started.");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Task 1 ended.");
		};

		// Define 2nd task
		Runnable task2 = () -> {
			System.out.println("Task 2 started.");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Task 2 ended.");
		};
		
		
		//Submit task to Executors
		service.execute(task1);
		service.execute(task2);
		
		
		//shutdown the executors after 5 second
		service.shutdown();
		service.awaitTermination(5, TimeUnit.SECONDS);
		
		System.out.println("All task finished.");

	}

}
