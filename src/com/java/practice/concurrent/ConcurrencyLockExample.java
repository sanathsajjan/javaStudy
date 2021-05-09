package com.java.practice.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.java.practice.objects.SampleResource;
//https://howtodoinjava.com/java/multi-threading/how-to-use-locks-in-java-java-util-concurrent-locks-lock-tutorial-and-example/
//https://www.tutorialspoint.com/java_concurrency/concurrency_readwritelock.htm
public class ConcurrencyLockExample implements Runnable {

	private SampleResource resource;
	private Lock lock;

	public ConcurrencyLockExample(SampleResource r) {
		this.resource = r;
		this.lock = new ReentrantLock();
	}

	@Override
	public void run() {
		try {
			//Locking the resource for specific time interval
			if (lock.tryLock(10, TimeUnit.SECONDS)) {
				resource.doSomething();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// release lock
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		SampleResource sr = new SampleResource(0);
		ConcurrencyLockExample target = new ConcurrencyLockExample(sr);
		Thread t1 = new Thread(target);
		t1.setName("Thread1");
		Thread t2 = new Thread(target);
		t2.setName("Thread2");
		
		t1.start();
		t2.start();
		
	}

}
