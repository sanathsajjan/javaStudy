package com.java.practice.oopsConcepts;

public class Class1 {
	public static void main(String[] args) {
		Class1 a = new Class1();
		Class2 b = new Class2();
		a = b;
		//b = a;
		b = (Class2) a;
	}
}

class Class2 extends Class1{}