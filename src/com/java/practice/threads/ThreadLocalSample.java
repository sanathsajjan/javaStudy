package com.java.practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalSample implements Runnable{
	private static final ThreadLocal<String> threadLocalVar = new ThreadLocal<>();

	public static void main(String[] args) {
		threadLocalVar.set("main value...");
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.execute(new ThreadLocalSample());
		es.execute(new ThreadLocalSample());
		es.execute(new ThreadLocalSample());
		es.shutdown();
	}

	@Override
	public void run() {
		threadLocalVar.set(Thread.currentThread().getName());
		System.out.println(threadLocalVar.get());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
