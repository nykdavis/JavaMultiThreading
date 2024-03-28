package com.davis.chatgpt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//find the factorial of a given number using thread pool 

public class ThreadPoolPratice implements Callable<Integer> {

	private int number;

	public ThreadPoolPratice(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 5;
		ExecutorService service = Executors.newFixedThreadPool(3);
		// Executors.newSingleThreadExecutor();
		// Executors.newCachedThreadPool();
		// Executors.newScheduledThreadPool(2);
		Future<Integer> future = service.submit(new ThreadPoolPratice(number));
		try {
			int result = future.get();
			System.out.println("Factorial of " + number + " is : " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.shutdown();

	}

}


//Read Me: 

/* Executor framework: Task execution
 *                     Thread Management
 *                     Concurrency Control 
 * ------------------------------------------------------------------------------------------------------
 * FixedThreadPool: *Executes tasks using a fixed number of threads.
 *                  *If all threads are busy, tasks are queued until a thread becomes available.
 * 
 * CachedThreadPool: *Dynamically adjusts the number of threads based on the workload.
 *                   *Creates new threads as needed and reuses existing ones.
 *                      
 * SingleThreadPool: *Uses a single thread to execute tasks sequentially.
 *                   *Guarantees that tasks are executed in the order they are submitted.
 * ------------------------------------------------------------------------------------------------------- 
 *                   
 *  ScheduledThreadPool: *Executes tasks after a specified delay or periodically.
 *                       *Useful for tasks that need to be executed periodically, 
 *                           such as cleanup tasks, cron jobs, or timed operations.
 *   
 * -------------------------------------------------------------------------------------------------------                                       
 *                                        
 *                                        
 *  ExecutorService:   *Interface that represents an asynchronous execution service. 
 *                     *Can be implemented by various types of thread pools, 
 *                        such as ThreadPoolExecutor and ScheduledThreadPoolExecutor.
 *                     
 *  ThreadPoolExecutor: *Implements ExecutorService and manages a pool of worker threads.
 *                      *Allows customization of core pool size, maximum pool size,
 *                        thread keep-alive time, and task queue type.                                                        
 *                                                          
 *  ScheduledThreadPoolExecutor: *Extends ThreadPoolExecutor and provides support for 
 *                                 scheduling tasks to execute after a delay or at fixed intervals.                                                      
 *                               *Allows scheduling of tasks using methods like schedule(),
 *                                 scheduleAtFixedRate(), and scheduleWithFixedDelay().  
 * -------------------------------------------------------------------------------------------------------                                
 *  shutdown():  * Initiates an orderly shutdown of the ExecutorService.
 *               * Waits for previously submitted tasks to complete execution.
 *               * Prevents new tasks from being submitted for execution. 
 *               
 *  shutdownNow(): * Attempts to stop the ExecutorService immediately.
 *                 * Interrupts the executing threads and cancels pending tasks.
 * -------------------------------------------------------------------------------------------------------
 * Runnable:  * Represents a task that can be executed asynchronously.
 *            * Defined by the java.lang.Runnable interface, which contains a single method: run().
 *            * Cannot return a result or throw checked exceptions directly.
 *            * Used primarily for fire-and-forget tasks or tasks that don't need to return a value.

 * Callable:  * Similar to Runnable, but allows the task to return a result and throw checked exceptions.
 *            * Defined by the java.util.concurrent.Callable interface, which contains a single method: call().
 *            * The call() method returns a result of a specified type (<V>), and can throw checked exceptions.
 *            * Used when the task needs to return a result, such as when performing computation or fetching data asynchronously.                 
 * ----------------------------------------------------------------------------------------------------------                                                         
 *  Future:   * Represents the result of an asynchronous computation.                                                        
 *            * Defined by the java.util.concurrent.Future interface.  
 *            
 *                                                        
 *   Methods: * get(): Waits for the computation to complete and returns the result. It can optionally specify a timeout.
 *            * isDone(): Checks if the computation is complete.
 *            * cancel(boolean mayInterruptIfRunning): Attempts to cancel the computation. Returns true if successful. 
 *               The mayInterruptIfRunning parameter specifies whether the thread executing the task should be interrupted.                                                        
 *                                                          
 */
