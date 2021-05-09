package com.java.practice.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "sample pdf file.pdf";
		System.out.println(URLEncoder.encode(s, StandardCharsets.UTF_8.toString()));
	}
}
