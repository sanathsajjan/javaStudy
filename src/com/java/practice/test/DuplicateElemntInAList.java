package com.java.practice.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateElemntInAList {
	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 6 };
		List<Integer> list = new ArrayList<>(Arrays.asList(intArray));
		int total = list.stream().reduce(0, Integer::sum);
		System.out.println("sum: " + total);
		int size = intArray.length - 1;
		System.out.println("size:" + list.size());
		int actualSum = size * (size + 1) / 2;
		System.out.println("actualSum: " + actualSum);
		System.out.print("Duplicate element: ");
		System.out.println(total - actualSum);

	}
}
