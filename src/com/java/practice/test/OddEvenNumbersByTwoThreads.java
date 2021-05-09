package com.java.practice.test;

/**
 * @author sanath.bt Printing Odd and even numbers by two threads
 *For this program no need to use wait and notify methods. If we use wait and notify methods the elements will
 *be picked up one by one by ech thread and it will pass the execution to the next thread.
 *
 */

public class OddEvenNumbersByTwoThreads {
	int[] intArray = { 0, 1, 11,111, 12, 201, 2, 3, 4, 5, 6, 101, 112};
	volatile boolean odd = true;

	public void printOdd() throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i < intArray.length; i++) {
				if (intArray[i] != 0 && intArray[i] % 2 != 0) {
					System.out.println(Thread.currentThread().getName() + ":" + intArray[i]);
					// System.out.println(Thread.currentThread().getName() + " waiting");
					//wait();
				}
				// System.out.println(Thread.currentThread().getName() + " notifying");
				//notify();
			}
		}
	}

	public void printEven() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			for (int i = 0; i < intArray.length; i++) {
				if (intArray[i] != 0 && intArray[i] % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + ":" + intArray[i]);
					// System.out.println(Thread.currentThread().getName() + " waiting");
					//wait();
				}
				// System.out.println(Thread.currentThread().getName() + " notifying");
				//notify();
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		OddEvenNumbersByTwoThreads o = new OddEvenNumbersByTwoThreads();
		Thread t1 = new Thread(() -> {
			try {
				o.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Used lambda expression to create runnable instance
		Thread t2 = new Thread(() -> {
			try {
				o.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}

