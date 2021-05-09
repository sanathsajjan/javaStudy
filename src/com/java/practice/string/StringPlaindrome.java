package com.java.practice.string;

public class StringPlaindrome {
	public static boolean isPalindrome(String input) {
		boolean isPlaindrome = true;
		int l = input.length();
		char[] charArray = input.toCharArray();
		System.out.println("Input length:"+charArray.length);
		for(int i=0; i<=charArray.length/2; i++) {
			if(input.charAt(i) != input.charAt(l-1-i)) {
				return false;
			}
		}
		return isPlaindrome;
	}
	public static void main(String[] args) {
		System.out.println(StringPlaindrome.isPalindrome("AABCDCBAA"));
	}
}
