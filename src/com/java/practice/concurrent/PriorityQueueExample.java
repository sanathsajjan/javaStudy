package com.java.practice.concurrent;



import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 
 * <pre>
 * Welcome to Priority Queue in Java tutorial. We know that Queue follows First-In-First-Out model but sometimes we need to process the objects in the queue based on the priority. That is when Java PriorityQueue is used.

For example, let’s say we have an application that generates stocks reports for daily trading session. This application processes a lot of data and takes time to process it. So customers are sending request to the application that is actually getting queued but we want to process premium customers first and standard customers after them. So in this case PriorityQueue implementation in java can be really helpful.

PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue are ordered by default in natural order. We can provide a Comparator for ordering at the time of instantiation of priority queue.

Java Priority Queue doesn’t allow null values and we can’t create PriorityQueue of Objects that are non-comparable. We use java Comparable and Comparator for sorting Objects and Priority Queue use them for priority processing of it’s elements.

The head of the priority queue is the least element based on the natural ordering or comparator based ordering, if there are multiple objects with same ordering, then it can poll any one of them randomly. When we poll the queue, it returns the head object from the queue.

Java Priority Queue size is unbounded but we can specify the initial capacity at the time of it’s creation. When we add elements to the priority queue, it’s capacity grows automatically.

PriorityQueue is not thread safe, so java provides PriorityBlockingQueue class that implements the BlockingQueue interface to use in java multithreading environment.

Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.

Let’s see an example of java PriorityQueue for natural ordering as well as with Comparator.

We have our custom class Customer that doesn’t provide any type of ordering, so when we will try to use it with PriorityQueue we should provide a comparator object for that.

We will use java random number generation to generate random customer objects. For natural ordering, I will use Integer that is also a java wrapper class.

Here is our final test code that shows how to use priority queue in java.

Notice that I am using java anonymous class for implementing Comparator interface and creating our id based comparator.

From output it’s clear that least element was at head and got polled first. If we won’t provide comparator while creating customerPriorityQueue, it will throw ClassCastException at runtime.

</pre>


 * @author sanath.bt
 *
 */
public class PriorityQueueExample {

	public static void main(String[] args) {
		
		//natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
		Random rand = new Random();
		for(int i=0;i<7;i++){
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		for(int i=0;i<7;i++){
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing Integer:"+in);
		}
		
		//PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
		addDataToQueue(customerPriorityQueue);
		
		pollDataFromQueue(customerPriorityQueue);
		
	}
	
	//Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>(){
		
		@Override
		public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
	};

	//utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for(int i=0; i<7; i++){
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
		}
	}
	
	//utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while(true){
			Customer cust = customerPriorityQueue.poll();
			if(cust == null) break;
			System.out.println("Processing Customer with ID="+cust.getId());
		}
	}

}

//In a file only one class can be declared as public
class Customer {
	
	private int id;
	private String name;
	
	public Customer(int i, String n){
		this.id=i;
		this.name=n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
