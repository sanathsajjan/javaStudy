package com.java.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.practice.objects.Employee;

public class StreamUsage {

	public static List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee(1, "Gopal", 28, 9000L);
		Employee e1 = new Employee(1, "sanath", 30, 10000L);
		Employee e2 = new Employee(2, "Ram", 40, 15000L);
		Employee e3 = new Employee(3, "sham", 41, 16000L);
		employees.add(e);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		return employees;
	}

	public static void main(String[] args) {
		List<Employee> employees = StreamUsage.getEmployeeList();
		// Filtering the list by salary >=10000
		Stream<Employee> employeesSalary = employees.stream().filter(e -> e.getSalary() >= 10000L);
		employeesSalary.forEach(e -> System.out.println(e.getName()));
		
		employees.stream().map(new Function<Employee, Employee>() {

			@Override
			public Employee apply(Employee t) {
				// TODO Auto-generated method stub
				return null;
			}

		});

		// Sublist using the main list by salary >=10000
		List<Employee> richEmployees = employees.stream().filter(e -> e.getSalary() >= 10000L)
				.collect(Collectors.toList());
		richEmployees.forEach(e -> System.out.println(e.getName()));

	}
}
