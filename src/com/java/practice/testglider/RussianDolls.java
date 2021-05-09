package com.java.practice.testglider;

import java.util.*;

class RussianDolls {

	public static void main(String[] args) {

		int n, k;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		System.out.print("Size "+ solution(array));
	}

	public static int solution(int[] array) {
		// Write your code below
		// Return the missing number
		
		List<Integer> list = new ArrayList<>();
		for(int i : array) {
			list.add(i);
		}
		
		Integer size = 0;
		List<Integer> arrayList = new ArrayList<>();
		while(list.size() > 0) {
			List<Integer> removeIndexes = new ArrayList<>();
			for(int i = 0; i<list.size(); i++) {
				if(!arrayList.contains(list.get(i))) {
					arrayList.add(list.get(i));
					removeIndexes.add(list.get(i));
				} 
			}
			
			for(Integer index : removeIndexes) {
				list.remove(index);
			}
			
			arrayList.clear();
			size += 1;
		}
		
		return size;
	}
}
