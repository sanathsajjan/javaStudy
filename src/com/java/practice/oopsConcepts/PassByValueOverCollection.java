package com.java.practice.oopsConcepts;

import java.util.ArrayList;
import java.util.List;

import com.java.practice.objects.Employee;

public class PassByValueOverCollection {
	public static void method1(List<String> dependents) {
		dependents.add("Sudha");
	}

	public static void main(String[] args) {
		Employee e = new Employee(1, "sanath", 31, 1000L);
		List<String> dependents = new ArrayList<>();
		dependents.add("Amulya");
		e.setDependents(dependents);
		System.out.println("Before method call: "+e.getDependents());
		PassByValueOverCollection.method1(e.getDependents());
		System.out.println("After method call: "+e.getDependents());
		

	}
}
