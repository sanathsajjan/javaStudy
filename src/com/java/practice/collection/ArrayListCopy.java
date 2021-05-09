package com.java.practice.collection;

import java.util.ArrayList;

import com.java.practice.objects.Employee;

public class ArrayListCopy {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<>();
		Employee e = new Employee(1, "Sanath", 31);
		list.add(e);
		System.out.println(list);
		ArrayList copy = new ArrayList(list);
		System.out.println(copy);
		
	}
}
