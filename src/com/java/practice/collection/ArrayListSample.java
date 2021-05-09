package com.java.practice.collection;

import java.util.ArrayList;
import java.util.List;

import com.java.practice.objects.Employee;

public class ArrayListSample {
	public static void main(String[] args) {
		List<Employee> arrayList = new ArrayList<>();
		arrayList.add(null);
		arrayList.add(null);
		System.out.println(arrayList);
	}
}
