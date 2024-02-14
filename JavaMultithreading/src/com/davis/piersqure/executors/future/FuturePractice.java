package com.davis.piersqure.executors.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//Calable use the call method
public class FuturePractice {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);

		Callable<String> task = () -> {
			return "Returning future Object";
		};

		Future<String> future = executor.submit(task);

		// Shutdown the executor gracefully
		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
	}

}
