package com.java.practice.collection;

import java.util.HashMap;
import java.util.Iterator;


/**
 * @author sanath.bt
 *
 *Fail-Fast Iterators In Java :<br><br>
Fail-Fast iterators, returned by most of the collection types, doesn�t tolerate any structural modifications to a collection while
iterating over it. (Structural modifications means add, remove or updating an element in the collection)
They throw <b>ConcurrentModificationException</b> if a collection is structurally modified while iteration is going on the collection.
But, they don�t throw any exceptions if the collection is modified by the iterator�s own methods like remove().<br><br>

How Fail-Fast Iterators Work?<br><br>

All Collection types maintain an internal array of objects ( Object[] ) to store the elements.
Fail-Fast iterators directly fetch the elements from this array. They always consider that this internal array is not modified while
iterating over its elements. To know whether the collection is modified or not, they use an internal flag called modCount which is updated
each time a collection is modified. Every time when an Iterator calls the next() method, it checks the modCount.
If it finds the modCount has been updated after this Iterator has been created, it throws ConcurrentModificationException.<br><br>

The iterators returned by the ArrayList, Vector, HashMap etc are all Fail-Fast in nature.
 */
public class FailFastMapExample {
	public static void main(String[] args) {
		//Fail fast
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("Apple", "Iphonex");
		hashMap.put("Samsung", "s9");
		hashMap.put("Oneplus", "6t");
		
		Iterator<String> iterator = hashMap.keySet().iterator();
		
		while(iterator.hasNext()) {
			hashMap.get(iterator.next());
			hashMap.put("Nokia", "1100");// Throw java.util.ConcurrentModificationException
		}

	}
}
