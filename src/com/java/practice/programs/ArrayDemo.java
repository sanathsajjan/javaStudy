package com.java.practice.programs;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
	   public static void main (String args[]) {

	      // create an array of strings
	      String a[] = new String[]{"abc","klm","xyz","pqr"};
	      
	      String b[] = new String[]{"xyz", "zab"};

	      List list1 = Arrays.asList(a);
	      
	      Integer[] iA = new Integer[] {5,6,7};
	      
	      List intList = Arrays.asList(iA, 1);
	      
	      System.out.println("The list is:" + intList);
	      // printing the list
	      System.out.println("The list is:" + list1);
	   }
	}
