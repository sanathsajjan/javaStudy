package com.java.practice.oopsConcepts;

import java.util.Arrays;
import java.util.List;

/**
 * Creating a generic class where it accepts any class
 * To achieve Type safety
 * T is type and it's applicable only for classes not for primitives (int, boolean...)
 * @param <T>
 */
class GenericClass<T> {
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void display() {
		System.out.println("Generic class of type: " + value.getClass().getName());
		System.out.println("value: " + value.toString());
	}
}

/**
 * Creating a class where a class extends a class/interface. The caller should
 * pass the class type as a type safety check.
 * In this example: Here it should be of type Number
 * @param <T>
 */
class GenericExtendsClass<T extends Number> {
	T value;

	// Generic method
	// For generic method we need to used ?
	public void show(List<? extends T> a) {
		// a.stream().filter( s -> (s.intValue()>2)).collect(Collectors.toList());
		a.stream().forEach(s -> System.out.println(s));
	}
	
	
	/**
	 * We can use super also, in this case we can pass super classes.. but sub classes of T won't allow
	 */
	public void display(List<? super T> a) {
		// a.stream().filter( s -> (s.intValue()>2)).collect(Collectors.toList());
		a.stream().forEach(s -> System.out.println(s));
	}

}

public class GenericsDemo {
	public static void main(String[] args) {

		GenericClass<Integer> integerClass = new GenericClass<>();
		integerClass.setValue(1);
		integerClass.display();

		GenericClass<String> stringClass = new GenericClass<>();
		stringClass.setValue("sanath");
		stringClass.display();

		GenericExtendsClass<Integer> genericExtendClass = new GenericExtendsClass<>();
		Integer[] integerArray = new Integer[10];
		for (int i = 0; i < integerArray.length; i++) {
			integerArray[i] = i;
		}
		genericExtendClass.show(Arrays.asList(integerArray));

	}

}
