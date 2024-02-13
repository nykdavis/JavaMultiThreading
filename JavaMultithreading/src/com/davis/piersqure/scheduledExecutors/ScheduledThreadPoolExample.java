package com.davis.piersqure.scheduledExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	public static void main(String[] args) {
		
		// Create a ScheduledThreadPool with 2 threads
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		
		// Task to run with a delay
		Runnable delayedTask= () -> System.out.println("Delayed task executed after 5 second");
				
		// Schedule the delayed task to run after 5 seconds
		service.schedule(delayedTask, 5, TimeUnit.SECONDS);
		
		// Task to run with a delay
		Runnable periodicDelay= () -> System.out.println("Periodic task executed every 2 seconds");
		
		// Task to run periodically
		service.scheduleAtFixedRate(periodicDelay, 1, 2, TimeUnit.SECONDS);
		
		// Let the program run for 10 seconds
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the executor gracefully
        service.shutdown();

	}

}
