package com.java.practice.java8.functionalpgming;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class FP01Iterate {

	private static Stream<String> stream;

	public static void main(String[] args) {
		List<Integer> integerList = List.of(1,2,3,6,9,8);
		List<String> courses = List.of("Spring","Spring Boot","API", "Microservices", "AWS","PCF", "Docker", "Kubernetes");
		//printListOfNumberInStructuredWay(integerList);
		printListOfNumberInFunctionaldWay(integerList);
		System.out.println("Printing even number using filters...........");
		printEvenNumbers(integerList);
		System.out.println("Printing Odd number using filters...........");
		printOddNumber(integerList);
		System.out.println("Print cources containing spring");
		printSourseWithGivenKeyword(courses, "Spring");
		System.out.println("Print even square even numbers:");
		printSquareOfEvenNumbers(integerList);
		System.out.println("Length of each word in course list::::::::");
		printCharacterCountOfEachElemnt(courses);
	}
	
	private static void printCharacterCountOfEachElemnt(List<String> courses) {
//		courses.stream().mapToInt(e -> e.length()).forEach(System.out::println);//Returning InputStream
		courses.stream().map(course -> course + ":"+course.length()).forEach(System.out::println);
	}

	private static void printSquareOfEvenNumbers(List<Integer> integerList) {
		integerList.stream().filter(e -> e % 2 == 0).map(e -> e*e).forEach(System.out::println);
	}

	private static void printSourseWithGivenKeyword(List<String> courses, String keyWord) {
		courses.stream().filter(e -> e.contains(keyWord)).forEach(System.out::println);
	}

	private static void printListOfNumberInFunctionaldWay(List<Integer> integerList) {
		// integerList.add(10);//List.of will return an unmodifiable List. If we try to
		// add an element it will throw UnsupportedOperationEcetion
		integerList.stream().forEach(System.out::println);
	}
	
	private static void printOddNumber(List<Integer> integerList) {
		integerList.stream().filter(e -> isOdd(e)).forEach(System.out::println);
	}
	
	
	private static Boolean isOdd(Integer element) {
		return element % 2 != 0;
	}

	private static void printEvenNumbers(List<Integer> integerList) {
		integerList.stream().filter(e-> e%2 ==0).forEach(System.out::println);
	}

	private static void printListOfNumberInStructuredWay(List<Integer> integerList) {
		Iterator<Integer> iterator = integerList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	
}
