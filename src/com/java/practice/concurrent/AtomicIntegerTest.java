package com.java.practice.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sanath.bt<br><br>
 AtomicInteger works with two concepts : CAS (Compare And Swap) and volatile variable.<br><br>

Using volatile variable insures that the current value will be visible to all threads and it will not be cached.<br><br>

The atomic objects make use of Compare and Swap mechanism to make them atomic - 
i.e. it is possible to guarantee that the value was as specified and is now at the new value.<br><br>

The code you posted continually tries to set the current value to one more than it was before. 
Remember that another thread could also have performed a get and is trying to set it too. 
If two threads race each other to change the value it is possible for one of the increments to fail.

Consider the following scenario:

Thread 1 calls get and gets the value 1.<br>
Thread 1 calculates next to be 2.<br>
Thread 2 calls get and gets the value 1.<br>
Thread 2 calculates next to be 2.<br>
Both threads try to write the value.<br>
Now because of atomics - only one thread will succeed, the other will receive false from the compareAndSet and go around again.<br><br>

If this mechanism was not used it would be quite possible for both threads to increment the value resulting in only one increment actually
being done.<br><br>

The confusing infinite loop for(;;) will only really loop if many threads are writing to the variable at the same time. <br>
Under very heavy load it may loop around several times but it should complete quite quickly.
 */
public class AtomicIntegerTest {
	public static void main(String[] args) {
		AtomicInteger atomic = new AtomicInteger(0);
		System.out.println(atomic.get());
		atomic.getAndSet(10);//To set the initial value
		System.out.println(atomic.get());
		System.out.println(atomic.incrementAndGet());//Pre increment
		System.out.println(atomic.getAndIncrement());//Post increment
		System.out.println(atomic.get());
	}
}