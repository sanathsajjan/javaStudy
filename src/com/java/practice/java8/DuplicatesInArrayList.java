package com.java.practice.java8;

import java.util.ArrayList;

public class DuplicatesInArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> duplicateList = new ArrayList<>();
		ArrayList<Integer> uniqueList = new ArrayList<>();
		duplicateList.add(1);
		duplicateList.add(1);
		duplicateList.add(2);

		System.out.println("List having duplicate list..");
		duplicateList.forEach(i -> System.out.println(i));

		duplicateList.forEach(i -> {
			if (!uniqueList.contains(i)) {
				uniqueList.add(i);
			}
		});

		System.out.println("List not having duplicate list..");
		uniqueList.forEach(i -> System.out.println(i));
	}
}
