package com.java.practice.concurrent;

/**
 * Difference Between Volatile and Synchronized Keywords in Java
 * Want to learn more about the difference between volatile and synchronized keywords? Check out this post to learn more about different
 * keywords and variables in Java.
 *
 * volatile is a field modifier, while synchronized modifies code blocks and methods.
 *
 * So, we can specify three variations of a simple accessor using those two keywords:
 *
 * 1
 * int i1;
 * 2
 * int geti1() {return i1;}
 * 3
 * ​
 * 4
 * volatile int i2;
 * 5
 * int geti2() {return i2;}
 * 6
 * ​
 * 7
 * int i3;
 * 8
 * synchronized int geti3() {return i3;}
 *
 *
 * Above, we defined three integer variables:  i1 , i2,  and  i3 . And, we defined three corresponding getter methods:  geti1(), geti2(),
 * and geti3().
 *
 * geti1() accesses the value currently stored in i1 in the current thread.
 *
 * Threads can have local copies of variables, and the data does not have to be the same as the data held in other threads.
 * In particular, another thread may have updated i1 in it's thread, but the value in the current thread could be different
 * from that updated value. In fact, Java demonstrates the idea of a "main" memory, and this is the memory that holds the current "correct"
 * value for variables. Threads can have their own copy of data for variables, and the thread copy can be different from the "main" memory.
 *
 * Therefore, it is possible for the "main" memory to have a value of 1 for i1, for thread1 to have a value of 2 for i1,
 * and for thread3 to have a value of 3 for i1 if thread1 and thread2 have both updated i1. But, the updated values have not yet been propagated
 * to the "main" memory or other threads.
 *
 * On the other hand, geti2() effectively accesses the value of i2 from the "main" memory. A volatile variable is not allowed to have a
 * local copy of a variable that is different from the value currently held in "main" memory.
 * Effectively, a variable declared volatile must have its data synchronized across all threads, so that whenever you access or update the
 * variable in any thread, all other threads immediately see the same value. Generally, volatile variables have a higher access and update
 * overhead than "plain" variables. Typically, threads are allowed to have their own copy of data, which is for better efficiency.
 *
 * There are two differences between volatile and synchronized:
 *
 * First, synchronized obtains and releases locks on monitors, which can force only one thread at a time to execute a code block.
 * That's a fairly well-known aspect to synchronized. But synchronized also synchronizes memory. In fact, synchronized synchronizes the whole
 * of the thread memory with "main" memory. So, executing geti3() does the following:
 *
 * The thread acquires the lock on the monitor for the object this .
 * The thread memory flushes all its variables, i.e. it has all of its variables effectively read from the "main" memory.
 * The code block is executed. In this case, this means setting the return value to the current value of i3, which may have just been reset
 * from "main" memory.
 * Any changes to variables would normally be written out to the "main" memory, but for geti3(), we have no changes.
 * The thread releases the lock on the monitor for the object this.
 * So, where volatile only synchronizes the value of one variable between the thread memory and the "main" memory, synchronized synchronizes
 * the value of all variables between the thread memory and the "main" memory and locks and releases a monitor to control the ownership between
 * multiple threads.
 *
 * From this information, it can be concluded that synchronized is likely to have more overhead than volatile.
 */
public class VolatileAndSynchronizedDiff {
}
