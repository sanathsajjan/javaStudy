package com.java.practice.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreaceReplace {
	public static void main(String[] args) {
		
		String s = "name.value";
		String[] str = s.split(".");
		System.out.println(str[0]);
//		Map<String, String> map = new HashMap<>();
//		map.put("$name.value", "Tavant");
//		map.put("$temp.value", "Tavant");
//		List<String> stringList = map.keySet().stream().map( e -> e.split(".")[1]).collect(Collectors.toList());
//		System.out.println(stringList);
//		
	}
}
