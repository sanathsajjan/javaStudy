package com.java.practice.java8;

/**
 * Diamond problem states that: If we have two classes defined in both parent
 * and child class extending both the class then ambiguity will happen. But we
 * can achieve multiple inheritance by implementing the interface.
 * 
 * But in java8 they introduce default method
 *
 */

interface I11 { 
	void show();

	default void display() {
		System.out.println("Display method from I11");
	}
}

interface I12 {
	void show();

	default void display() {
		System.out.println("Display method from I12");
	}
}

// If a class is extending both class and implementing an interface then priority
// will be for the class.
class AbstractClass {

	public void display() {
		System.out.println("Display method from abstractClass");
	}
}

public class DiamondIssueProblem extends AbstractClass implements I11, I12 {

	public static void main(String[] args) {
		DiamondIssueProblem diamondIssueProblem = new DiamondIssueProblem();
		diamondIssueProblem.display();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public void display() { //In order to tell which method should be
	 * called then we need to call the super method here. //I11.super.display(); }
	 */

}
