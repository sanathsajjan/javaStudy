package com.java.practice.string;

public class StringPoolSample {
	public static void main(String[] args) {
		String s1 = "a";//saved in StringPool
		String s2 = "a";//saved in StringPool
		String s3 = new String("a");
		String s5 = new String("a");
		System.out.println("s1 hashcode: "+s1.hashCode());
		System.out.println("s2 hashcode: "+s2.hashCode());
		System.out.println(s1==s2);//== will check the reference is same pr not?
		System.out.println(s3.hashCode());//Even though hashcodes are same == will return false.
		System.out.println(s5.hashCode());
		System.out.println(s3==s5);
		System.out.println(s1==s3);
		String s4 = s3.intern();//Intern will get the object from stringpool
		System.out.println(s1==s4);
		System.out.println(s3.equals(s5));
		
		
	}
}