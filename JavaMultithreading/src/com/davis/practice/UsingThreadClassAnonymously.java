package com.davis.practice;

public class UsingThreadClassAnonymously {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(" Thread name : " + Thread.currentThread().getName() + " counter: " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted Exception.");
					}
				}

			}
		}.start();

		new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(" Thread name : " + Thread.currentThread().getName() + " counter: " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted Exception.");
					}
				}

			}
		}.start();
	}
}
