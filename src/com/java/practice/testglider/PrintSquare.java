package com.java.practice.testglider;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Math;
import java.math.BigInteger;

class PrintSquare {

	static boolean isPerfectSquare(long input) {
		long closestRoot = (long) Math.sqrt(input);
		return input == closestRoot * closestRoot;
	}

	public static void printPerfectSquares(List<Integer> numbers) {
		List<Integer> result = numbers.stream().filter(i -> isPerfectSquare(i)).collect(Collectors.toList());
		// String resultString =
		// result.stream().map(Integer::toString).collect(Collectors.joining(","));
		// System.out.println(resultString);
		result.forEach(System.out::println);
		// result.forEach(i -> System.out.print(i));
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(",");
			}

		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String list_string = in.nextLine();
		List<Integer> numbers = Stream.of(list_string.split(",")).map(Integer::parseInt).collect(Collectors.toList());

		printPerfectSquares(numbers);
	}
}
