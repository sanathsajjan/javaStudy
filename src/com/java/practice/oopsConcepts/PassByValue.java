package com.java.practice.oopsConcepts;

public class PassByValue {
	public static void main(String[] args) {
		// t is a reference
		Test t = new Test(5);
		
		// Reference is passed and a copy of reference
		// is created in change()
		change(t);

		// Old value of t.x is printed
		System.out.println(t.x);
	}

	public static void change(Test t) {
		// We changed reference to refer some other location
		// now any changes made to the reference are not reflected
		// back in main
		t = new Test();
		t.x = 10;
	}
}

// A Java program to show that references are also passed
// by value.
class Test {
	int x;

	Test(int i) {
		x = i;
	}

	Test() {
		x = 0;
	}
}
