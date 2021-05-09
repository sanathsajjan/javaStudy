package com.java.practice.programs;

public class EqualsTest {
	double d1 = 100;
	double d2 = 100;
	double d3 = 1000.00;
	double d4 = 1000.00;
	
	Double d5 = new Double(100.00);
	Double d6 = new Double(100.00);

	public void checkEquality() {
		System.out.println(d1);
		System.out.println(d3);
		System.out.println(d5);
		System.out.println(d1==d2);
		System.out.println(d3==d4);
	}

	public static void main(String[] args) {
		EqualsTest test = new EqualsTest();
		test.checkEquality();
	}
}
