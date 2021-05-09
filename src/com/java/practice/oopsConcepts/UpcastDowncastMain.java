package com.java.practice.oopsConcepts;

/**
 * @author sanath.bt<p>
 *
 Upcasting: When we want to cast a Sub class to Super class, we use Upcasting(or widening). 
  It happens automatically, no need to do anything explicitly.<p>

Downcasting : When we want to cast a Super class to Sub class, we use Downcasting(or narrowing), 
and Downcasting is not directly possible in Java, explicitly we have to do.
 */
class Animal {
	public int duration() {
		System.out.println("Duation of animal is: 0");
		return 0;
	}
}

class Dog extends Animal {
	public int duration() {
		System.out.println("Duation of dog is: 20");
		return 20;
	}
}

public class UpcastDowncastMain {

	public static void main(String[] args) {
		Animal dog = new Dog();// Upcasting
		Dog d = (Dog) dog;//Downcasting
		d.duration();

		//Not valid
		
		  Dog animal = (Dog) new Animal(); 
		  if(animal instanceof Animal) {
			  animal.duration(); 
		  }
		 
	}

}
