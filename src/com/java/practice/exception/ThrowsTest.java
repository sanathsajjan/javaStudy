package com.java.practice.exception;

public class ThrowsTest {
	
	public static int division(int a, int b) {
		return a/b;
	}
	
	public void callDivision() throws CustomException {
		try {
			ThrowsTest.division(1, 0);
		} catch(ArithmeticException ae) {
			throw(new CustomException("Custom exception with Exception chaining..",ae)); //Throwing the custom exception
		}
	} 
	public static void main(String[] args) {
		ThrowsTest throwsTest = new ThrowsTest();
		try {
			throwsTest.callDivision();
		} catch(CustomException ae) {
			System.out.println("cause: "+ ae.getCause());
		}
		System.out.println("continue..");
	}
}