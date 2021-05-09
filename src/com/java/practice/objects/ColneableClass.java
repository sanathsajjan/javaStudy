package com.java.practice.objects;

public class ColneableClass implements Cloneable {
	private String name;
	private Integer id;
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ColneableClass(String name, Integer id, Department d) {
		super();
		this.name = name;
		this.id = id;
		this.department = d;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ColneableClass cc = (ColneableClass) super.clone();// Below 3 lines are for deep copy. For shallow copy will be using only super.clone() 
		cc.setDepartment((Department)department.clone());//For deep copy we need to implement clone method in dependent classes.
		return cc;//Returning the deep cloned object. 
	}

	@Override
	public String toString() {
		return "ColneableClass [name=" + name + ", id=" + id + ", department=" + department + "]";
	}
	
	

}
