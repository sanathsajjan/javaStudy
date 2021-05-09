package com.java.practice.threads;

//Here we are using Runnable interface  
public class RunnablePractice {
	
	public static void main(String args[]) {
		//Using lambda expression
		new Thread( () -> System.out.println("Runnable") ).start();
		
		//Using runnable Interface to define the task
		Thread t = new Thread(new RunnableClass());
		t.start();
	}
}
