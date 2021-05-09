package com.java.practice.threads;

public class JoinUsage {
	public static void main(String args[]) {
		Thread t1 = new Thread (new RunnableClass());
		Thread t2 = new Thread (new RunnableClass());
		
		t1.start();
		try {
			t1.join();//wait for T1 to gets completes
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
	}

}

class RunnableClass implements Runnable{

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(i);
		}
	}
	
}