package com.java.practice.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * A java.util.concurrent.CountDownLatch is a concurrency construct that allows
 * one or more threads to wait for a given set of operations to complete.
 * 
 * A CountDownLatch is initialized with a given count. This count is decremented
 * by calls to the countDown() method. Threads waiting for this count to reach
 * zero can call one of the await() methods. Calling await() blocks the thread
 * until the count reaches zero.
 * 
 * Below is a simple example. After the Decrementer has called countDown() 3
 * times on the CountDownLatch, the waiting Waiter is released from the await()
 * call.
 * 
 * Best example is: Cab waiting for all 4 passengers to get in then only car will start.
 * 
 * 
 * Difference between cyclic barrier and countown latch is:
 * https://codepumpkin.com/countdownlatch-vs-cyclicbarrier/
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter = new Waiter(latch);
		Cook decrementer = new Cook(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}
}

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Cook implements Runnable {

	CountDownLatch latch = null;

	public Cook(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
