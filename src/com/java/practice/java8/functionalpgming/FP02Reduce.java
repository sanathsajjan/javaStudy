package com.java.practice.java8.functionalpgming;

import java.util.Comparator;
import java.util.List;

public class FP02Reduce {
	public static void main(String[] args) {
		List<Integer> integerList = List.of(3,4,1,2,7,8);
		List<String> courses = List.of("Spring","Spring Boot","API", "Microservices", "AWS","PCF", "Docker", "Kubernetes");
		System.out.println("Sum of integer list using structured way:");
		System.out.println(sumOfIntegersStructured(integerList));
		System.out.println("Sum of integer list using functional way:");
		System.out.println(sumOfIntegersFunctional(integerList));
		System.out.println("Findout the largest number in a list using reduce");
		System.out.println(getargestNumber(integerList));
		System.out.println("Findout the smaleest number in a list using reduce");
		System.out.println(smallestNumber(integerList));
		System.out.println("Square the list and sum the sqauare.");
		System.out.println(sqareAndSum(integerList));
		System.out.println("Distinct and sorted in stream..");
		distinctNumbers(integerList);
		System.out.println("Sort numbers and string using sorted and comparator methods");
		sortIntegerList(integerList);
		sortStringList(courses);
		
	}

	private static void sortStringList(List<String> courses) {
		courses.stream().sorted().forEach(System.out::println);
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

	private static void sortIntegerList(List<Integer> integerList) {
		integerList.stream().sorted().forEach(System.out::println);
	}

	private static void distinctNumbers(List<Integer> integerList) {
		integerList.stream().distinct().forEach(System.out::println);
	}

	private static int sqareAndSum(List<Integer> integerList) {
		// TODO Auto-generated method stub
		return integerList.stream().map(e -> e*e).reduce(0, Integer::sum);
	}

	private static int smallestNumber(List<Integer> integerList) {
		// TODO Auto-generated method stub
		return integerList.stream().reduce(Integer.MAX_VALUE, (x,y)->x>y ? y:x);
	}

	private static int getargestNumber(List<Integer> integerList) {
		
		return integerList.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x : y);
	}

	private static int add(Integer a, Integer b) {
		return a+b;
	} 
	
	//Adding numbers in a list using reduce 
	private static int sumOfIntegersFunctional(List<Integer> integerList) {
		//int sum = integerList.stream().reduce(0, FP02Reduce::add);
		//int sum = integerList.stream().reduce(0, (a,b)-> a+b);
		int sum = integerList.stream().reduce(0, Integer::sum);
		return sum;
	}

	private static int sumOfIntegersStructured(List<Integer> integerList) {
		int sum = 0;
		for (Integer i : integerList) {
			sum += i;
		}
		return sum;
	}
	
	
	
}
