package com.java.practice.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * @author sanath.bt
 * 
 * In this article, we will look at one of the most useful constructs java.util.concurrent to solve the concurrent producer-consumer problem. 
 * We�ll look at an API of the BlockingQueue interface and how methods from that interface make writing concurrent programs easier.<p>

Later in the article, we will show an example of a simple program that has multiple producer threads and multiple consumer threads.

2. BlockingQueue Types
We can distinguish two types of BlockingQueue:<p>

<b>unbounded queue</b> � can grow almost indefinitely<p>
<b>bounded queue</b> � with maximal capacity defined<p>
<pre>
2.1. Unbounded Queue
Creating unbounded queues is simple:

BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
The Capacity of blockingQueue will be set to Integer.MAX_VALUE. All operations that add an element to the unbounded queue will never block, 
thus it could grow to a very large size.

The most important thing when designing a producer-consumer program using unbounded BlockingQueue is that consumers should be able to
consume messages as quickly as producers are adding messages to the queue. Otherwise, the memory could fill up and we would get an OutOfMemory
exception.

2.2. Bounded Queue
The second type of queues is the bounded queue. We can create such queues by passing the capacity as an argument to a constructor:


BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
Here we have a blockingQueue that has a capacity equal to 10. It means that when a consumer tries to add an element to an already full queue, 
depending on a method that was used to add it (offer(), add() or put()), it will block until space for inserting object becomes available. 
Otherwise, the operations will fail.

Using bounded queue is a good way to design concurrent programs because when we insert an element to an already full queue, 
that operations need to wait until consumers catch up and make some space available in the queue. 
It gives us throttling without any effort on our part.

3. BlockingQueue API
There are two types of methods in the BlockingQueue interface � methods responsible for adding elements to a queue and methods that retrieve those elements. 
Each method from those two groups behaves differently in case the queue is full/empty.

3.1. Adding Elements<p>
<b>add()</b> � returns true if insertion was successful, otherwise throws an IllegalStateException
<b>put()</b> � inserts the specified element into a queue, waiting for a free slot if necessary
<b>offer()</b> � returns true if insertion was successful, otherwise false
<b>offer(E e, long timeout, TimeUnit unit) </b>� tries to insert element into a queue and waits for an available slot within a specified timeout<p>
3.2. Retrieving Elements<p>
<b>take()</b> � waits for a head element of a queue and removes it. If the queue is empty, it blocks and waits for an element to become available
<b>poll(long timeout, TimeUnit unit) </b>� retrieves and removes the head of the queue, waiting up to the specified wait time if necessary 
for an element to become available. Returns null after a timeout
These methods are the most important building blocks from BlockingQueue interface when building producer-consumer programs.
</pre>
 */
public class ProducerConsumerProblemUsingBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedResource = new LinkedBlockingDeque<>(10);
		
		Thread t1 = new Thread(new ProducerBQ(sharedResource));
		Thread t2 = new Thread(new ConsumerBQ(sharedResource));
		
		t1.start();
		t2.start();
	}
}


/**
 * @author sanath.bt
 * Put in BlockingQueue method will wait once the queue is full
 */
class ProducerBQ implements Runnable {

	private final BlockingQueue<Integer> sharedResource;

	public ProducerBQ(BlockingQueue<Integer> blockingQueue) {
		this.sharedResource = blockingQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Produced:"+i);
				sharedResource.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


/**
 * @author sanath.bt
 * Take method in BlockingQueue method will wait once the queue is empty
 */
class ConsumerBQ implements Runnable {

	private final BlockingQueue<Integer> sharedResource;

	public ConsumerBQ(BlockingQueue<Integer> blockingQueue) {
		this.sharedResource = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("consumed: "+sharedResource.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
