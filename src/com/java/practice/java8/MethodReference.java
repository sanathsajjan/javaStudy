package com.java.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.practice.objects.Employee;

public class MethodReference {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Sanath", 29, 100L));
		employeeList.add(new Employee(2, "John", 30, 90L));
		employeeList.add(new Employee(3, "Jacob", 19, 80L));
		
		//Method reference(::) in Java 8
		
		//Get all the employee names into a list of names using method reference
		List<String> employeeNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		
		//Get all the employee ages into a list of ages not using method reference
		List<Integer> ages = employeeList.stream().map(e -> e.getAge()).collect(Collectors.toList());
		
		//Creating a map using the EmployeeList
		Map<Integer, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getId, e -> e));
		System.out.println(ages);
		System.out.println(employeeNames);
		System.out.println(employeeMap);
		
		
	}
}
