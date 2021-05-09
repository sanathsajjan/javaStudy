package com.java.practice.java8;

import java.util.Arrays;

//Convert arrays to streams in java8
public class ConvertingArraysToStream {
public static void main(String[] args) {
	String[] array = {"12","23"};
	Arrays.stream(array).forEach(System.out::println);
}
}
