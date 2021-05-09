package com.java.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[abc]$");
		Matcher matcher = pattern.matcher("..");
		System.out.println(matcher.matches());
	}
}
