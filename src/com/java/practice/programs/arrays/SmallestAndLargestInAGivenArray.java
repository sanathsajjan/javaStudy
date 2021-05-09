package com.java.practice.programs.arrays;

public class SmallestAndLargestInAGivenArray {
	public static void main(String[] args) {
		int[] a = { 1,1 };
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
// Todo if array size is 1 then both will be same
		for (int number : a) {
			if (number > largest) {
				largest = number;
			} else if (number < smallest) {
				smallest = number;
			}

		}
		System.out.println(smallest + ":" + largest);

	}
}
