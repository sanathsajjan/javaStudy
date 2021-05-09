package com.java.practice.programs;

import java.util.HashMap;

//Anagram means character count should be same using Java8
// Eg: Listen Silent
// Triangle Integral
public class Anagram {
	
	public boolean anagramTest(String s1, String s2) {
		HashMap<Character, Integer> s1Map = new HashMap<>();
		HashMap<Character, Integer> s2Map = new HashMap<>();
		
		for(Character ch : s1.toCharArray()) {
			s1Map.put(ch,s1Map.getOrDefault(ch, 0)+1);//Java8 method
		}
		
		for(Character ch : s2.toCharArray()) {
			s2Map.put(ch,s2Map.getOrDefault(ch, 0)+1);
		}
		
		return s1Map.equals(s2Map);
	}
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		System.out.println(anagram.anagramTest("aabcsdabc", "abcdbacsa"));
		System.out.println(anagram.anagramTest("triangle", "integral"));
	}

}
