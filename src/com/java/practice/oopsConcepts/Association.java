package com.java.practice.oopsConcepts;

/*Association is relation between two separate classes which establishes through their Objects. 
 * Association can be one-to-one, one-to-many, many-to-one, many-to-many.
In Object-Oriented programming, an Object communicates to other Object to use functionality and services provided 
by that object. Composition and Aggregation are the two forms of association.
Association,Aggregation and Composition*/

// Java program to illustrate the  
// concept of Association 

// class bank 
class Bank {
	private String name;

	// bank name
	Bank(String name) {
		this.name = name;
	}

	public String getBankName() {
		return this.name;
	}
}

// employee class
class Employee {
	private String name;

	// employee name
	Employee(String name) {
		this.name = name;
	}

	public String getEmployeeName() {
		return this.name;
	}
}

// Association between both the
// classes in main method
class Association {
	public static void main(String[] args) {
		Bank bank = new Bank("Axis");
		Employee emp = new Employee("Neha");

		System.out.println(emp.getEmployeeName() + " is employee of " + bank.getBankName());
	}
}
/*
 * In above example two separate classes Bank and Employee are associated
 * through their Objects. Bank can have many employees, So it is a one-to-many
 * relationship.
 */