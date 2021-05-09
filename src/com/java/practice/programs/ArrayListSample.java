package com.java.practice.programs;

import java.util.ArrayList;
import java.util.List;

import com.java.practice.objects.Employee;

public class ArrayListSample {
	public static void main(String[] args) {
		List<Employee> arrayList = new ArrayList<>();
		arrayList.add(null);
		System.out.println(arrayList);
		
		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		//remove we have 2 methods for list. One for delete based on index other one to delete the object.
		lists.remove(0);
		lists.remove(new Integer(2));
		System.out.println(lists);
	}
}
