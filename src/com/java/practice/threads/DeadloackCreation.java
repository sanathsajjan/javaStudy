package com.java.practice.threads;

/**
 * @author sanath.bt 
 * 
 * 		   <p>Deadlock in java is a part of multithreading. Deadlock can
 *         occur in a situation when a thread is waiting for an object lock,
 *         that is acquired by another thread and second thread is waiting for
 *         an object lock that is acquired by first thread. Since, both threads
 *         are waiting for each other to release the lock, the condition is
 *         called deadlock</p>
 * 
 *         <p>Avoid the deadlock by following steps:</p> 
 *         <p>1. Avoid nested locks: This is
 *         the most common reason for deadlocks, avoid locking another resource
 *         if you already hold one. It�s almost impossible to get deadlock
 *         situation if you are working with only one object lock. For example,
 *         here is the another implementation of run() method without nested
 *         lock and program runs successfully without deadlock situation.</p> 
 *         
 *         <p>2. Lock Only What is Required: You should acquire lock only on the
 *         resources you have to work on, for example in above program I am
 *         locking the complete Object resource but if we are only interested in
 *         one of it�s fields, then we should lock only that specific field not
 *         complete object. </p>
 *         
 *         <p>3. Avoid waiting indefinitely: You can get deadlock
 *         if two threads are waiting for each other to finish indefinitely
 *         using thread join. If your thread has to wait for another thread to
 *         finish, it�s always best to use join with maximum time you want to
 *         wait for thread to finish.</p>
 *         
 *         <p> {@link ://vmlens.com/articles/5-ways-to-thread-safe-update-a-field-in-java-2/} </p>
 */
public class DeadloackCreation {
	public static void main(String[] args) {
		 String r1 = "Resource1";
		 String r2 = "Resource2";

		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread() {
			public void run() {
				synchronized (r1) {
					try {
						System.out.println("In T1 R1");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (r2) {
						try {
							System.out.println("In T1 R2");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread() {
			public void run() {
				synchronized (r2) {
					try {
						System.out.println("In T2 R2");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (r1) {
						try {
							System.out.println("In T2 R1");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t1.start();
		t2.start();

	}
}
