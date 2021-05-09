package com.java.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.java.practice.objects.Employee;

public class OptionalPractice {
	List<Employee> prepareEmployeeList() {
		return null;
	} 
	
	Optional<List<Employee>> optionalEmployee(){
		return Optional.empty();
	}
	
	Optional<List<Employee>> optionalEmployees(){
		List<Employee> list =  new ArrayList<Employee>();
		list.add(new Employee(1, "sanath", 29, 100L));
		return Optional.ofNullable(list);
	}
	
	public static void main(String[] args) {
		OptionalPractice practice = new OptionalPractice();
		Optional<List<Employee>> emp = practice.optionalEmployee();
		//Arrays.asList(new Employee(1, "sa", 29));
		//Setting a value to the Optional variable
		emp = Optional.ofNullable(Arrays.asList(new Employee(1, "sa", 29, 90L)));
//		emp.
		if(emp.isPresent()) {
			System.out.println("Employee list is not empty...");
			System.out.println(emp.get());
		} else {
			System.out.println("Employee list is empty...");
		}
	}
}
