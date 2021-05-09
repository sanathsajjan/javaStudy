package com.java.practice.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

//Program counter
public class FindNumberOfInstanceCreated {
	public static void main(String[] args) {
		/*System.out.println("Program to test the number of instance created in multi threaded environment....");
		Thread t1 = new Thread(() -> {
			new Dummy();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1");
		t1.start();
		Thread t2 = new Thread(() -> {
			new Dummy();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t2");
		t2.start();*/

		String s = "sftp://";
		System.out.println(s.startsWith("sftp:"));

//		System.out.println("Number of instances created: " + Dummy.getNumberOfInstancesCreated());
	}

}

class Dummy {
	private static AtomicInteger numberOfInstancesCreated = new AtomicInteger();// Should be Static

	// Note: Static variables can be accessible in non static methods as well. but
	// vice versa is not applicable i.e. inside static methods only static variables
	// and static methods are allowed.
	public Dummy() {
		numberOfInstancesCreated.incrementAndGet();// Increment the atomic value whenever we are creating a new
													// instance.
	}

	public static int getNumberOfInstancesCreated() {
		return numberOfInstancesCreated.get();// To return the number of instances created.
	}

}