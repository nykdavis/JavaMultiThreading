package com.davis.practice;

public class UsingThreadClass extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(" Thread Name :" + Thread.currentThread().getName() + " count : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interupted Exception.");
			}
		}
	}

	public static void main(String[] args) {

		UsingThreadClass thread1 = new UsingThreadClass();
		UsingThreadClass thread2 = new UsingThreadClass();

		thread1.start();
		thread2.start();

	}

}
