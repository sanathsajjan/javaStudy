package com.java.practice.test;

public class SecondHighestInAnArray {
	private static void secondHighestNumber(int[] array) {
		if(array.length < 2) {
			System.out.println("Array size should be atleast 2!!");
		}
		int i, first, second;
		first = second = Integer.MIN_VALUE;
		
		for(i=0; i<array.length; i++) {
			
			/* If current element is smaller than 
            first then update both first and second */
			if(array[i] > first) {
				second = first;
				first = array[i];
			}
			/* If arr[i] is in between first and 
            second then update second  */
			else if(array[i] > second && array[i] != first) {
				second = array[i];
			}
		}
		
		if(second == Integer.MIN_VALUE) {
			System.out.println("There is no second largest element!!!");
		}
		else {
			System.out.println("Second largest number:"+ second);
		}
	}
	public static void main(String args[]) {
//		System.out.println("Please enter the list of numbers to find the second highest in an array:");
//		int intArray[] = new int[args.length];
//		for ( int i=0; i<args.length; i++) {
//			intArray[i] = Integer.parseInt(args[i]);
//		}
//		SecondHighestInAnArray.secondHighestNumber(intArray);
		
		int intArray[] = {0,1};
		
		
		SecondHighestInAnArray.secondHighestNumber(intArray);
	}
}
