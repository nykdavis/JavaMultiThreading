package com.davis.udany;

import java.util.Random;

public class GroceryWithThreads {

	// Class representing cashier functionality implemented as a thread Subclass
	static class CashierThread extends Thread {

		private int customerToServe;
		private String name;

		// Create thread which should work specific number of hours
		CashierThread(int workDuratioHours, String name) {
			this.customerToServe = workDuratioHours * 2;// 2 customers per hour
			this.name = name;
		}

		// Function emulating serving one customer by cashier
		private void serveCustomer() {
			int a = new Random().nextInt();
			int b = new Random().nextInt();

			for (int i = 0; i < 1_000_000_000; i++) {
				a = (a + b) * a;
			}

			System.out.println("Cashier " + name + " served the customer (recipt = " + a + ")");
		}

		@Override
		public void run() {
			System.out.println("!!!cashier " + name + "started working");
			for (int i = 0; i < customerToServe; i++) {
				serveCustomer();
			}
			System.out.println("!!! Cashier " + name + " is done with the work for today");
		}

	}

	// Function emulating serving one customer by cashier
	private static int doManagerWork(int durationHours) {
		int a = new Random().nextInt();
		int b = new Random().nextInt();

		for (int i = 0; i < 2_000_000_000; i++) {
			a = (a + b) * a;
		}
		return a;

	}

	// Main method -> grocery store is opening
	public static void man(String[] args) {

		// At this time , main thread (manager Jenny) is RUNNABLE state
		System.out.println("!!! Manager Jenny started working.");

		Thread alice = new CashierThread(4, "Alice"); // Alice is in new State
		alice.start(); // Alice is in RUNNABLE state

		int jennyWorkPart1 = doManagerWork(2); // Jenny is doing manager work for 2 hours

		Thread bob = new CashierThread(4, "Bob"); // Bob is in new State
		Thread chris = new CashierThread(4, "Chris"); // Chris is in new State

		bob.start();
		chris.start();

		int jennyWorkPart2 = doManagerWork(2);

		System.out.println(
				"!!! Manager Jenny is done with the work today (id = " + (jennyWorkPart1 + jennyWorkPart2) + ")");

	}
}
