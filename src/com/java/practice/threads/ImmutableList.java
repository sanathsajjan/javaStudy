package com.java.practice.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Making a list as immutable by using the Collections.unmodifableList
public final class ImmutableList {
	private final List<String> immuatableList;
	
	public ImmutableList(List<String> list) {
		this.immuatableList = list;
	}
	
	public List<String> getImmutableList(){
		return Collections.unmodifiableList(immuatableList);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("sanath");
		ImmutableList immutableList = new ImmutableList(list);
		System.out.println(immutableList.getImmutableList());
		//Trying add an item to the immutable list we will get java.lang.UnsupportedOperationException
		immutableList.getImmutableList().add("Not allowed");
		System.out.println(immutableList.getImmutableList());
	}
}
