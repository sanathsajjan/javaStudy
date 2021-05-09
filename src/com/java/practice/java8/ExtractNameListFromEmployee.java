package com.java.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.java.practice.objects.Employee;

public class ExtractNameListFromEmployee {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Sanath", 29, 100L));
		list.add(new Employee(2, "Ananth", 30, 900L));
		list.add(new Employee(3, "Gopal", 28, 99L));
		List<String> nameList = list.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(nameList);
	}
}
