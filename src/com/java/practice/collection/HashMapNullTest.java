package com.java.practice.collection;

import java.util.*;

/**
 * @author sanath.bt <br><br>
 * 
 * HashMap can have only null key and it will be stored in 0th index.<br><br>
 * In HashMap if we gave the same key twice then the second value will be stored.<br><br>
 */
public class HashMapNullTest {
	private Map<String, String> m  = new HashMap();
	{
		m.put("BT","Sanath");
		m.put("HO", "Nithan");
	}

	private Map<String, String> m2  = new HashMap();
	{
		m2.put("HO", "hosSwa");
	}

	private List<String> s = Arrays.asList("HO");

	public void m1 (){
		Map<String, String> m3 = new HashMap<>();
		m.forEach((k,v) -> {
			String str = m2.get(k);
//			System.out.println("str:"+str);
			if(str != null){
//				System.out.println(k + ":" + v);
				m3.put(str, v);

			}
		});
		System.out.println(m3);
	}
	public static void main(String[] args) {
		/*Map<String, String> map = new HashMap<>();
		map.put("one_1", "1");
		map.put("two_2", "2");
		map.put("three_3", "3");*/

		HashMapNullTest t = new HashMapNullTest();
//		System.out.println(t.m.get("BT"));
		t.m1();

	}

}
