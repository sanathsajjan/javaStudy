package com.java.practice.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sanath.bt
 * Callable can be used only in the context of Executors
 */
public class CallablePractice {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		Future<String> s = executorService.submit(new MyTask());
		Future<String> s = executorService.submit(()-> {
			System.out.println("Created a task using Callable");
			return "Callable task";
		});
		System.out.println(s.get());
		executorService.shutdown();
	}
}

class MyTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("Created a task using Callable");
		return "Callable task";
	}	
}