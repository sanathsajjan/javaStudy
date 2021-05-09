package com.java.practice.string;

public class StringFileExtension {
	public static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf('.'));
	}

	public static void main(String[] args) {

		String fileName = "Tavant Appraisal Letter 2020 Jan.pdf";
		System.out.println(getFileExtension(fileName));
	}
}