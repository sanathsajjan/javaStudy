package com.java.practice.oopsConcepts;

/**
 * @author sanath.bt
 * Association is relation between two separate classes which establishes through their Objects. 
 * Association can be one-to-one, one-to-many, many-to-one, many-to-many.
In Object-Oriented programming, an Object communicates to other Object to use functionality 
and services provided by that object. 
Composition and Aggregation are the two forms of association.
 */
public class CompositionExample {
	
	public static void main(String[] args) {
		Car car = new Car();
		car.carDetails();
	}

}

class Engine{
	private String engineType;
	
	public Engine(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
}


class Car{
	
	//to achieve composition we need to use final 
	private final Engine engine;
	
	{
		engine = new Engine("");
	}
	public Car(){
		//engine = new Engine("Car engine");
	}
	
	public void carDetails() {
		System.out.println(engine.getEngineType());
	}
}