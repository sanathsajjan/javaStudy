package com.java.practice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//5-10-2020 Incture
//Mere two sorted arraya and the result also should be sorted.
public class MergeArray {
public static void main(String[] args) {
	List<Integer> a1 = Arrays.asList(1,2,3);
	List<Integer> a2 = Arrays.asList(1,2,4);
	List<Integer> a3 = new ArrayList<>(a1.size()+a2.size());
	a3.addAll(a1);
	a3.addAll(a2);
	System.out.println(a3);
	Collections.sort(a3);
	System.out.println(a3);
}
}
