package com.java.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * On this page we will provide Java 8 Stream reduce() example. Stream reduce() performs a reduction on the elements of the stream. It uses identity and accumulator function for reduction. In parallel processing we can pass combiner function as additional parameter to this method. Stream reduce() can be used to get the sum of numbers stored in collection. It can also concatenate the string data stored in collection with given separator. Stream reduce() method can perform many more reducing task as required. We are providing here some examples.
Contents
Stream.reduce() with Accumulator
Stream.reduce() with Identity and Accumulator
Stream.reduce() with Identity, Accumulator and Combiner
Reduce List and Array into a String
Reduce List and Array into Sum

Stream.reduce() with Accumulator
Here we will pass BinaryOperator as accumulator. In case of numeric BinaryOperator, the start value will be 0. In case of string, the start value will be a blank string. 

reduce(BinaryOperator accumulator)

The method will return Optional instance. Find the example. 

ReduceDemo1.java
package com.concretepage;
import java.util.Arrays;
public class ReduceDemo1 {
    public static void main(String[] args) {
    	  int[] array = {23,43,56,97,32};
    	  Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
    	  Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
    	  Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));
    }
}  

StatisticsUtility.java
package com.concretepage;
public class StatisticsUtility {
	public static int addIntData(int num1, int num2) {
		return num1 + num2;
	}
} 
Output
251
251
251 
Stream.reduce() with Identity and Accumulator
Here we will use an identity and accumulator. We will pass the identity as start value. 

reduce(T identity, BinaryOperator<T> accumulator)

Find the example. 
ReduceDemo2.java
package com.concretepage;
import java.util.Arrays;
public class ReduceDemo2 {
    public static void main(String[] args) {
    	  int[] array = {23,43,56,97,32};
    	  //Set start value. Result will be start value + sum of array. 
    	  int startValue = 100;
    	  int sum = Arrays.stream(array).reduce(startValue, (x,y) -> x+y);
    	  System.out.println(sum);
    	  sum = Arrays.stream(array).reduce(startValue, Integer::sum);
    	  System.out.println(sum);
    	  sum = Arrays.stream(array).reduce(startValue, StatisticsUtility::addIntData);
    	  System.out.println(sum);
    }
}  Output
351
351
351 
Stream.reduce() with Identity, Accumulator and Combiner
Here we will pass three arguments identity, accumulator and combiner in reduce() method. The identity value must be an identity for the combiner function. This method with three arguments is used in parallel processing. Combiner works with parallel stream only, otherwise there is nothing to combine. 

reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

Find the example. 
ReduceDemo3.java
package com.concretepage;
import java.util.Arrays;
import java.util.List;
public class ReduceDemo3 {
    public static void main(String[] args) {
      List<Integer> list2 = Arrays.asList(5, 6, 7);
      int res = list2.parallelStream().reduce(1, (s1, s2) -> s1 * s2, (p, q) -> p * q);
      System.out.println(res);
    }
} Output
210 
Reduce List and Array into a String

ReduceToString.java
package com.concretepage;
import java.util.Arrays;
import java.util.List;
public class ReduceToString {
	public static void main(String[] args) {
		//Reduce Array to String.
		String[] array = {"Mohan", "Sohan", "Mahesh"};
		Arrays.stream(array).reduce((x, y) -> x +"," + y)
		       .ifPresent(s -> System.out.println("Array to String: "+ s));
		//Reduce List to String.
		List<String> list = Arrays.asList("Mohan", "Sohan", "Mahesh");
		list.stream().reduce((x, y) -> x +"," + y)
			       .ifPresent(s -> System.out.println("List to String: "+ s));
	}
} Output
Array to String: Mohan,Sohan,Mahesh
List to String: Mohan,Sohan,Mahesh 
Reduce List and Array into Sum

ReduceToSum.java
package com.concretepage;
import java.util.Arrays;
import java.util.List;
public class ReduceToSum {
	public static void main(String[] args) {
		//Reduce Array to sum.
		int[] array = {30, 10, 20, 40};
		int sum = Arrays.stream(array).reduce(0, (x, y) -> x + y);
		System.out.println("Sum of Array: "+ sum);
		//Reduce List to sum.
		List<Integer> list = Arrays.asList(30, 10, 20, 40);
		sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum of List: "+ sum);
	}
} Output
Sum of Array: 100
Sum of List: 100 
 *
 */
public class SumOfArraysUsingStreams {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int sum = 0;
		System.out.println(Arrays.stream(array).sum());
		
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		System.out.println(integers.stream().reduce(Integer::sum));
		
	}
}
