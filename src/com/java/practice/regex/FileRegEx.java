package com.java.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRegEx {
	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("^(?!#!.*\\.\\.)[a-zA-Z0-9%^{}\\[\\]()_+\\-=,.~'` #]{1,255}$");
		Matcher matcher = pattern.matcher("a.az#!");
		System.out.println(matcher.matches());
	}
}
