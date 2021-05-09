package com.java.practice.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ForEach {
	
	public void forEachListPractice() {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
				
		//Internally using consumer Interface
		intList.forEach(number -> System.out.println(number));
	}
	
	//Enhanced for loop used iterate the list prior to java 1.8
	public void enhancedForLoop() {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		for (int i : intList) {
			System.out.println(i);
		}
	}
	
	public void forEachMapPractice() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Sanath");
		map.put(2, "john");
		map.put(3, "Jacob");
		
		//Internally it's using BiConsumer
		map.forEach((id, name) -> System.out.println(id +" "+ name));
	}
	
	public static void main(String[] args) {
		ForEach each = new ForEach();
		each.forEachListPractice();
		each.forEachMapPractice();
	}
}
