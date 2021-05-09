package com.java.practice.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringConcatenationUsingStream {
	public static void main(String[] args) {
		System.out.println(Stream.of("Sanath ", null, "B", "T")
		        .filter(s -> s != null && !s.isEmpty())
		        .collect(Collectors.joining(".")));
	}
}
