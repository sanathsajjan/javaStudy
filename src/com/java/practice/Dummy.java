package com.java.practice;

import java.util.*;

public class Dummy {
	public static void main(String[] args) {

		List<String> l1 = new ArrayList<>();
		l1.add("Sanath");
		l1.add("Nithan");
		List<String> l2 = new ArrayList<>();
		l2.add("Sanath");
		l1.removeAll(l2);
		Integer i = null;
		//System.out.println(Long.valueOf(null));
		//System.out.println(i!= null && i == l1.size());

		l2.removeAll(null);
	}

}
