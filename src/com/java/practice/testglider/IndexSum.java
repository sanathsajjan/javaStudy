package com.java.practice.testglider;

import java.util.*;
//Glider


class IndexSum {

	public static void solve(int n, int k, int[] arr) {
		int ind1 = -1;
		int ind2 = -1;
		// Write your code here
		outer : for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (arr[i] + arr[j] == k) {
					ind1 = i;
					ind2 = j;
					break outer;
				}
			}
		}
		System.out.println(ind1 + " " + ind2);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Click HELP above to see examples of handling input/debug/output
		// INPUT: int n = in.nextInt();
		// DEBUG: System.out.println(n);
		// OUTPUT: System.out.println(result);

		// Write the code to solve the problem below,
		// format the "result" as specified in the problem statement
		// and finally, write the result to stdout
		// IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		solve(n, k, arr);
		in.close();
	}
}
