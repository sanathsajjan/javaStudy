package com.java.practice.programs;

import java.util.HashMap;
import java.util.Map;

//getOrDefault for map
public class CharacterCountInStringUsingJava8 {
	public static void main(String[] args) {
		String s = "Character count";
		Map<Character, Integer> map = new HashMap<>();

		for (Character ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		map.forEach((x, y) -> System.out.println("key:" + x + " value:" + y));
		
	}
}
