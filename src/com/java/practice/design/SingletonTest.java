package com.java.practice.design;
// TCPL
public class SingletonTest {
	public static void main(String[] args) {
		Group instance = Group.getInstance("Group1");
		System.out.println(instance.getName());
		Group instance1 = Group.getInstance("Group2");
		System.out.println(instance1.getName());
	}
}


class Group{
	private static volatile Group instance;
	
	private String name;
	
	private Group(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Group getInstance(String name) {
		if(instance == null) {
			synchronized(Group.class) {
				if(instance == null) {
					instance = new Group(name);
				} else {
					return instance;
				}
			}
		} 
		return instance;
	}
}