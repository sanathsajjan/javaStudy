package com.java.practice.oopsConcepts;

public class PassByValue2 {
	
	
	public static void main(String[] args) {
		C2 c2 = new C2(0, 0);
		System.out.println(c2.toString());
		PassByValue2.passByValueTest(c2);
		System.out.println(c2.toString());
	}
	
	public static void passByValueTest(C2 c2) {
		c2 = new C2(10, 10);
		c2.setV1(100);
		c2.setV2(100);
	}
}

class C2{
	private int v1;
	private int v2;
	public C2(int i, int j) {
		v1 = i;
		v2 = j;
	}
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		this.v1 = v1;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	
	@Override
	public String toString() {
		return v1 +" "+ v2;
	}
}
