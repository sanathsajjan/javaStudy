package com.java.practice.testglider;

//Click on "HELP" above to see examples of handling input/debug/output 
//Format the output as specified in the problem statement and write the result to stdout 
//IMPORTANT: Remove all debug statements for your final submission
class PerformanceWithAccuracy implements Runnable {
 private int n;
 private int sumTerms;
 private int count = 0;
 private double sum = 0.0;

 public int getCount() { return count; }
 public double getSum() { return sum; }

 public void reset() { 
		count = 0;
		sum = 0.0;
 }

	public void incr(int terms) {
		int oldCount = count;
		for (int i=0; i<terms; i++)
			sum+=Math.sin(i * (2 * Math.PI / 44100.0));
		count = oldCount + 1;
 }

 public PerformanceWithAccuracy(int n, int sumTerms) {
		this.n = n;
		this.sumTerms = sumTerms;
 }

 public void run () {
		for (int i=0; i<n; i++) {
			incr(sumTerms);
		}
 }

 public static void main(String [] args) {

		int n = 1000;
		int sumTerms = 1000;

		PerformanceWithAccuracy sol = new PerformanceWithAccuracy(n, sumTerms);
		Thread t1 = new Thread(sol);
		Thread t2 = new Thread(sol);
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ie) {
			System.out.println(ie);
			ie.printStackTrace();
		}
		System.out.printf("count=%d sum=%f\n", sol.getCount(), sol.getSum());
 }
}