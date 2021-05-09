package com.java.practice.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.java.practice.objects.Employee;

public class HashMapSample {
	public static void retainsTest() {
		
		Map<Integer, Employee> m1 = new HashMap<>();
		m1.put(1, new Employee(1, "sanath", 28));
		m1.put(2, new Employee(2, "John", 25));
		m1.put(3, new Employee(3, "Adam", 26));
		//System.out.println(m1);
		
		for(Entry<Integer, Employee> entry : m1.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		Map<Integer, Employee> m2 = new HashMap<>();
		m2.put(1, new Employee(1, "sanath", 28));
		m2.put(2, new Employee(2, "John", 25));
		m2.put(3, new Employee(3, "richard", 26));
		//System.out.println(m2);
		Iterator<Entry<Integer, Employee>> m2Iterator = m2.entrySet().iterator();
		while(m2Iterator.hasNext()) {
			Entry<Integer, Employee> entry =  m2Iterator.next();
			System.out.println( entry.getValue());
		}
		m1.entrySet().removeAll(m2.entrySet());
		System.out.println(m1);
		System.out.println(m2);
		m2.forEach((a,b) -> System.out.println(a + ":" + b.getName()));
		
	}

	public static void main(String[] args) {
		HashMapSample.retainsTest();
	}
}
