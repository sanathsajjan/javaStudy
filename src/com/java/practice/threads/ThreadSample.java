package com.java.practice.threads;

//Creating a thread by extending Thread class
public class ThreadSample extends Thread {
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getName()+" running and done");
	}
	
	public static void main(String[] args) {
		ThreadSample threadSample = new ThreadSample();
		for (int i = 0; i<3 ; i++) {
			threadSample.start();//If we call the start twice on the same thread it will throw java.lang.IllegalThreadStateException
		}
	}
}