package com.java.practice.testglider;

//Problem setup code {
import java.util.Scanner;

class ThrowbleObjects {

	// The code in grey is problem setup code is read-only
	// Problem setup code {
	public static void main(String[] args) {
		ThrowbleObjects soln = new ThrowbleObjects();
		soln.processInput();
	}
	// }

	public void processInput() {
		Scanner in = new Scanner(System.in);
		System.out.println();
		while (in.hasNextLine()) {
			String s = in.nextLine();
			try {
				checkNumber(s);
				System.out.println(s);

			} catch (NotAnIntegerException naie) {
				System.out.println("NOT NUMBER");

			}
		}
	}

	/* TODO: Implement the checkNumber method here */
	public void checkNumber(String s) throws NotAnIntegerException {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			throw new NotAnIntegerException();
		}
	}
}

class NotAnIntegerException extends Exception {

}
