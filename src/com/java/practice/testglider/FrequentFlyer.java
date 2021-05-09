package com.java.practice.testglider;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Glider
class FrequentFlyer {
	private static final Map<String, String> customer_map;
	static {
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("Sophia", "Jacob");
		aMap.put("Isabella", "Mason");
		aMap.put("Emma", "William");
		aMap.put("Olivia", "Jayden");
		aMap.put("Ava", "Noah");
		aMap.put("Emily", "Michael");
		aMap.put("Abigail", "Ethan");
		aMap.put("Madison", "Alexander");
		aMap.put("Mia", "Aiden");
		aMap.put("Chloe", "Daniel");
		aMap.put("Elizabeth", "Anthony");
		aMap.put("Ella", "Matthew");
		aMap.put("Addison", "Elijah");
		aMap.put("Natalie", "Joshua");
		aMap.put("Lily", "Liam");
		aMap.put("Grace", "Andrew");
		aMap.put("Samantha", "James");
		aMap.put("Avery", "David");
		aMap.put("Sofia", "Benjamin");
		aMap.put("Aubrey", "Logan");
		aMap.put("Brooklyn", "Christopher");
		aMap.put("Lillian", "Joseph");
		aMap.put("Victoria", "Jackson");
		aMap.put("Evelyn", "Gabriel");
		aMap.put("Hannah", "Ryan");
		aMap.put("Alexis", "Samuel");
		aMap.put("Charlotte", "John");
		aMap.put("Zoey", "Nathan");
		aMap.put("Leah", "Lucas");
		aMap.put("Amelia", "Christian");
		aMap.put("Zoe", "Jonathan");
		aMap.put("Hailey", "Caleb");
		aMap.put("Layla", "Dylan");
		aMap.put("Gabriella", "Landon");
		aMap.put("Nevaeh", "Isaac");
		aMap.put("Kaylee", "Gavin");
		aMap.put("Alyssa", "Brayden");
		aMap.put("Anna", "Tyler");
		aMap.put("Sarah", "Luke");
		aMap.put("Allison", "Evan");
		aMap.put("Savannah", "Carter");
		aMap.put("Ashley", "Nicholas");
		aMap.put("Audrey", "Isaiah");
		aMap.put("Taylor", "Owen");
		aMap.put("Brianna", "Jack");
		aMap.put("Aaliyah", "Jordan");
		aMap.put("Riley", "Brandon");
		aMap.put("Camila", "Wyatt");
		aMap.put("Khloe", "Julian");
		aMap.put("Claire", "Aaron");
		customer_map = Collections.unmodifiableMap(aMap);
	}

	private static List<Boolean> checkCustomers(List<String> customers) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		ArrayDeque<String> deque = new ArrayDeque<String>();
		// TODO
		for (String customer : customers) {
			if (customer_map.containsKey(customer)) {
				deque.add(customer_map.get(customer));
				result.add(true);
			} else {
				if(deque.contains(customer)) {
					result.add(true);
				} else {
					result.add(false);
				}
			}

		}

		return result;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String list_string = in.nextLine();
		List<String> arrivals = Stream.of(list_string.split(",")).collect(Collectors.toList());
		List<Boolean> results = checkCustomers(arrivals);
		String resultString = results.stream().map(m -> m.toString()).collect(Collectors.joining(","));
		System.out.println(resultString);
	}
}