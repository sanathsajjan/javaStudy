package com.java.practice.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//https://stackoverflow.com/questions/1220975/calling-a-function-every-10-minutes
//Running a task for specific time at regular intervals 
class BeeperControl {
	
	ScheduledExecutorService scheduler1 = Executors.newSingleThreadScheduledExecutor();
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private AtomicInteger integer = new AtomicInteger(0);
	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
//				System.out.println("beep");
				System.out.println(integer.getAndIncrement());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(integer.get() == 30) {
					//beeperHandle.cancel(true);
					System.out.println("Calling shutdown!!!");
					scheduler.shutdownNow();
				}
			}
		};
		
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, 2, TimeUnit.SECONDS);
		// Terminate the job after 10 seconds 
		scheduler.schedule(new Runnable() {
			public void run() {
				System.out.println("Cancelling the scheduler..");
				System.out.println("Is schduler shutdown:"+scheduler.isShutdown());
				System.out.println("Is schduler terminated:"+scheduler.isTerminated());
				beeperHandle.cancel(true);
				System.out.println("Is schduler terminated:"+scheduler.isTerminated());
				scheduler.shutdownNow();
				System.out.println("Is schduler cancelled:"+scheduler.isShutdown());
			}
		}, 10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		BeeperControl control = new BeeperControl();
		control.beepForAnHour();
	}
}