package com.java.practice.string;

public class FetchFileName {
public static void main(String[] args) {
	String fullPath = "\\\\EC2AMAZ-PUEO1MV\\Users\\Administrator\\Desktop\\LE-Project\\Pending\\Batches\\LE-Test5\\CView\\CValidate-2_1247701_LE - COC_03_CV20200401144918.CV01.pdf";
//	String fullPath = "C:\\Hello\\AnotherFolder\\The File Name.PDF";
	int index = fullPath.lastIndexOf("\\");
	String fileName = fullPath.substring(index + 1);
	System.out.println("FileName:"+fileName);
}
}
