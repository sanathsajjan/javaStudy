package com.java.practice.oopsConcepts;

public class StaticExplained {
	int a = 0;
	public static void main(String[] args) {
		//System.out.println(a);//Compile time error. We can't access non-static variable inside static method.
		StaticExplained object = new StaticExplained();
		System.out.println(object.a);//In order to use non-static member inside static method we need to create an instance and we need to use.
	}

}
