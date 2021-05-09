package com.java.practice.threads;

import java.util.Date;

//Date is a Mutable class.
/**
 * @author sanath.bt 
 * 		   Immutable class is good for caching purpose because you
 *         don�t need to worry about the value changes. Other benefit of
 *         immutable class is that it is inherently thread-safe, so you don�t
 *         need to worry about thread safety in case of multi-threaded
 *         environment.
 * 
 *         Read: Java Thread Tutorial and Java Multi-Threading Interview
 *         Questions.
 * 
 *         Here I am providing a way to create immutable class in java via an
 *         example for better understanding.
 * 
 *         To create immutable class in java, you have to do following steps.
 * 
 *         1. Declare the class as final so it can�t be extended.
 *         2. Make all fields private, so that direct access is not allowed.
 *         3. Don�t provide setter methods for variables.
 *         4. Make all mutable fields final so that it�s value can be assigned only once.
 *         5. Initialize all the fields via a constructor performing deep copy.
 *         6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual
 *         object reference.
 */
public final class ImmutableDateClass {

	private final Date date;

	public ImmutableDateClass(Date date) {
		super();
		this.date = date;
	}

	// Restricting Mutable object by creating a new object by cloning/date.getTime
	// in getters.
	public Date getDate() {
		return (Date) date.clone();
	}
}

