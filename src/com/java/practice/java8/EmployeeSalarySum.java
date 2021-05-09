package com.java.practice.java8;

import java.util.ArrayList;
import java.util.List;

import com.java.practice.objects.Employee;

public class EmployeeSalarySum {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "sanath", 12, 100L));
		employees.add(new Employee(2, "sanath", 12, 200L));
		Long totalSalaryExpense = employees.stream().map(emp -> emp.getSalary()).reduce(0L, (a, b) -> a + b);

		System.out.println(totalSalaryExpense);
	}
}
