package com.java.practice.string;

/**
 * <pre>
 * Guide to Java String Pool

by baeldungJava+Core Java


1. Overview
The String object is the most used class in the Java language.

In this quick article, we'll explore the Java String Pool — the special memory region where Strings are stored by the JVM.


2. String Interning
Thanks to the immutability of Strings in Java, the JVM can optimize the amount of memory allocated for them by storing only one copy of each literal String in the pool. This process is called interning.

When we create a String variable and assign a value to it, the JVM searches the pool for a String of equal value.

If found, the Java compiler will simply return a reference to its memory address, without allocating additional memory.

If not found, it'll be added to the pool (interned) and its reference will be returned.

Let's write a small test to verify this:

String constantString1 = "Baeldung";
String constantString2 = "Baeldung";
         
assertThat(constantString1)
  .isSameAs(constantString2);

  
3. Strings Allocated Using the Constructor
When we create a String via the new operator, the Java compiler will create a new object and store it in the heap space reserved for the JVM.

Every String created like this will point to a different memory region with its own address.

Let’s see how this is different from the previous case:

String constantString = "Baeldung";
String newString = new String("Baeldung");
  
assertThat(constantString).isNotSameAs(newString);


4. String Literal vs String Object
When we create a String object using the new() operator, it always creates a new object in heap memory. On the other hand, if we create an object using String literal syntax e.g. “Baeldung”, it may return an existing object from the String pool, if it already exists. Otherwise, it will create a new String object and put in the string pool for future re-use.

At a high level, both are the String objects, but the main difference comes from the point that new() operator always creates a new String object. Also, when we create a String using literal – it is interned.


This will be much more clear when we compare two String objects created using String literal and the new operator:

String first = "Baeldung"; 
String second = "Baeldung"; 
System.out.println(first == second); // True
In this example, the String objects will have the same reference.

Next, let's create two different objects using new and check that they have different references:

String third = new String("Baeldung");
String fourth = new String("Baeldung"); 
System.out.println(third == fourth); // False
Similarly, when we compare a String literal with a String object created using new() operator using the == operator, it will return false:


String fifth = "Baeldung";
String sixth = new String("Baeldung");
System.out.println(fifth == sixth); // False
In general, we should use the String literal notation when possible. It is easier to read and it gives the compiler a chance to optimize our code.

5. Manual Interning
We can manually intern a String in the Java String Pool by calling the intern() method on the object we want to intern.

Manually interning the String will store its reference in the pool, and the JVM will return this reference when needed.

Let's create a test case for this:


String constantString = "interned Baeldung";
String newString = new String("interned Baeldung");
 
assertThat(constantString).isNotSameAs(newString);
 
String internedString = newString.intern();
 
assertThat(constantString)
  .isSameAs(internedString);
6. Garbage Collection
Before Java 7, the JVM placed the Java String Pool in the PermGen space, which has a fixed size — it can't be expanded at runtime and is not eligible for garbage collection.

The risk of interning Strings in the PermGen (instead of the Heap) is that we can get an OutOfMemory error from the JVM if we intern too many Strings.

Why character array is better than String for Storing password in Java

 
Why character array is better than String for storing password in Java was recent question asked to one of my friend in a java interview. he was interviewing for a Technical lead position and has over 6 years of experience.Both Character array and String can be used to store text data but choosing one over other is difficult question if you haven't faced the situation already. But as my friend said any question related to String must have a clue on special property of Strings like immutability and he used that to convince interviewer. here we will explore some reasons on why should you used char[] for storing password than String.

character array over string storing password javaThis article is in continuation of my earlier interview question post on String e.g. Why String is immutable in Java or How Substring can cause memory leak in Java, if you haven't read those you may find them interesting.Here are few reasons which makes sense to believe that character array is better choice for storing password in Java than String:

1) Since Strings are immutable in Java if you store password as plain text it will be available in memory until Garbage collector clears it and since String are used in String pool for reusability there is pretty high chance that it will be remain in memory for long duration, which pose a security threat. Since any one who has access to memory dump can find the password in clear text and that's another reason you should always used an encrypted password than plain text. Since Strings are immutable there is no way contents of Strings can be changed because any change will produce new String, while if you char[] you can still set all his element as blank or zero. So Storing password in character array clearly mitigates security risk of stealing password.

2) Java itself recommends using getPassword() method of JPasswordField which returns a char[] and deprecated getText() method which returns password in clear text stating security reason. Its good to follow advice from Java team and adhering to standard rather than going against it.

From Java 7 onwards, the Java String Pool is stored in the Heap space, which is garbage collected by the JVM. The advantage of this approach is the reduced risk of OutOfMemory error because unreferenced Strings will be removed from the pool, thereby releasing memory.
 * </pre>
 * @author sanath.bt
 *
 */
public class StringWorkingExplained {

}
