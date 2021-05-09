package com.java.practice.java8.functionalpgming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.practice.objects.Employee;

public class StreamExample {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee(1, "SAnath", 32);
		employees.add(e);

		employees.stream().forEach(i -> {
			i.setSalary(1000L);
		});
		//System.out.println(employees);

//		for (Employee emp : employees) {
//			emp.setSalary(2000L);
//		}
//
//		System.out.println(employees);
		Map<Integer, Employee> e1 = employees.stream().collect(Collectors.toMap(Employee::getId, ea -> ea));
		System.out.println(e1);
	}
}
