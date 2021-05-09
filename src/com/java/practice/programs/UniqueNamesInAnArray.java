package com.java.practice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueNamesInAnArray {

	public static String[] uniqueNames(String[] names1, String[] names2) {
        List<String> list1 = Arrays.asList(names1);
        List<String> list2 = Arrays.asList(names2);
        
        list2.stream().forEach(i -> {
        	if(list1.contains(i)) {
        		list1.remove(i);
        	} else {
        		list1.add(i);
        	}
        });
        
        String[] result = new String [list1.size()];
        
         list1.toArray(result);
         return result;
        
    }

	public static void main(String[] args) {
		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		System.out.println(String.join(", ", UniqueNamesInAnArray.uniqueNames(names1, names2))); // should print Ava,
																									// Emma, Olivia,
																									// Sophia
	}
}