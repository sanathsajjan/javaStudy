package com.java.practice.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileToByteArray {
public static void main(String[] args) throws IOException {
	//String path = System.getProperty("user.dir") + "\\src\\test.txt";
//		String path = "D:\\Visual Studio short cuts.pdf";
//	    try {
//	        byte[] encoded = Files.readAllBytes(Paths.get(path));
//	        System.out.println(Arrays.toString(encoded));
//	    } catch (IOException e) {
//	
//	    }
	    String fileAbsPath = "D:\\Visual Studio short cuts.pdf";
		String fileName = new File(fileAbsPath).getName();
		//byte[] data = Files.readAllBytes(Paths.get(fileAbsPath));
		System.out.println(Files.readAllBytes(Paths.get(fileAbsPath)));
}
}
