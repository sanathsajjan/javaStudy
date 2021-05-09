package com.java.practice.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamNullTest {
    public static void main(String[] args) {
    	List<String> stringList = new ArrayList<>();
//    	stringList.add("sanath");
//    	stringList.add("A");
//    	stringList.add("B");
//    	stringList.add("C");
    	
    	//stringList.stream().forEach(System.out::println);
    	stringList.forEach(System.out::println);
    	System.out.println("HI");
    }
}
