package com.java.practice.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.practice.objects.Employee;

public class FilterClass {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Sanath", 29, 100L));
		list.add(new Employee(2, "ananth", 30, 900L));
		list.add(new Employee(3, "Sanath", 28, 99L));
		/*list.add(new Employee(2, "Sham", 38, 990L));
		list.add(new Employee(2, "Ram", 28, 99L));*/
		
		Map<Integer, Employee> employeeMap = new HashMap<>();
		try {
//			employeeMap = list.stream().collect(Collectors.toMap(Employee::getId, e->e));
			//If there is any duplicate record in the list it will throw IllegalStateException to avoid that we  have the below implementation
			employeeMap = list.stream()
	          .collect(Collectors.toMap(
	             Employee::getId,
	             e -> e,
	             (e1, e2) -> {// It's a binary operation. This menthod is for apply method
	            	 
            		 return e1;
	             }
	          ));
			
			System.out.println(employeeMap);
		} catch(Exception e) {
			System.out.println(e.getCause());
//			employeeMap.remove(e.)
		}
		
		List<String> nameList = list.stream().map(Employee::getName).collect(Collectors.toList());
		nameList.stream().allMatch(e -> e.contains("sanath"));
		System.out.println(nameList);
	}
}
