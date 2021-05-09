package com.java.practice.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Refernce: https://www.baeldung.com/java-executor-service-tutorial
public class ExecutorPractice {

	public static void main(String[] args) {
		/*
		 * ExecutorService executor = Executors.newSingleThreadExecutor();
		 * executor.execute(() -> { System.out.println("Executing the executor task");
		 * executor.shutdown(); });
		 */
		WorkerThread workerThread = new WorkerThread();
		ExecutorService e = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			e.execute(workerThread);
			// For more information about Future see down
			// Future<String> future = e.submit(callable/runnable)//submits a Callable or a
			// Runnable task to an ExecutorService and returns a result of type Future.
			// String result = e.invokeAny(list of callbaleTasks)// assigns a collection of
			// tasks to an ExecutorService, causing each to be executed, and returns the
			// result of a successful execution of one task (if there was a successful
			// execution).
			// List<Future<String>> futures = e.invokeAll(list of callbaleTasks)//assigns a
			// collection of tasks to an ExecutorService, causing each to be executed, and
			// returns the result of all task executions in the form of a list of objects of
			// type Future.
		}

		// Initiates an orderly shutdown in which previously submitted tasks are
		// executed, but no new tasks will be accepted. Invocation has no additional
		// effect if already shut down.
		// This method does not wait for previously submitted tasks to complete
		// execution. Use awaitTermination to do that.
		e.shutdown();// See down
		System.out.println("adasdsad... ");
	}
}

class WorkerThread implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ": running....");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * Shutting Down an ExecutorService In general, the ExecutorService will not be
 * automatically destroyed when there is not task to process. It will stay alive
 * and wait for new work to do.
 * 
 * In some cases this is very helpful; for example, if an app needs to process
 * tasks which appear on an irregular basis or the quantity of these tasks is
 * not known at compile time.
 * 
 * On the other hand, an app could reach its end, but it will not be stopped
 * because a waiting ExecutorService will cause the JVM to keep running.
 * 
 * To properly shut down an ExecutorService, we have the shutdown() and
 * shutdownNow() APIs.
 * 
 * The shutdown() method doesn’t cause an immediate destruction of the
 * ExecutorService. It will make the ExecutorService stop accepting new tasks
 * and shut down after all running threads finish their current work.
 * 
 * executorService.shutdown(); The shutdownNow() method tries to destroy the
 * ExecutorService immediately, but it doesn’t guarantee that all the running
 * threads will be stopped at the same time. This method returns a list of tasks
 * which are waiting to be processed. It is up to the developer to decide what
 * to do with these tasks.
 * 
 * List<Runnable> notExecutedTasks = executorService.shutDownNow(); One good way
 * to shut down the ExecutorService (which is also recommended by Oracle) is to
 * use both of these methods combined with the awaitTermination() method. With
 * this approach, the ExecutorService will first stop taking new tasks, the wait
 * up to a specified period of time for all tasks to be completed. If that time
 * expires, the execution is stopped immediately:
 * 
 * executorService.shutdown(); try { if (!executorService.awaitTermination(800,
 * TimeUnit.MILLISECONDS)) { executorService.shutdownNow(); } } catch
 * (InterruptedException e) { executorService.shutdownNow(); }
 */

/*
 * The Future Interface The submit() and invokeAll() methods return an object or
 * a collection of objects of type Future, which allows us to get the result of
 * a task’s execution or to check the task’s status (is it running or executed).
 * 
 * The Future interface provides a special blocking method get() which returns
 * an actual result of the Callable task’s execution or null in the case of
 * Runnable task. Calling the get() method while the task is still running will
 * cause execution to block until the task is properly executed and the result
 * is available.
 * 
 * Future<String> future = executorService.submit(callableTask); String result =
 * null; try { result = future.get(); } catch (InterruptedException |
 * ExecutionException e) { e.printStackTrace(); } With very long blocking caused
 * by the get() method, an application’s performance can degrade. If the
 * resulting data is not crucial, it is possible to avoid such a problem by
 * using timeouts: ExecutionException (Exception thrown when attempting to
 * retrieve the result of a taskthat aborted by throwing an exception. This
 * exception can beinspected using the getCause() method.) String result =
 * future.get(200, TimeUnit.MILLISECONDS); If the execution period is longer
 * than specified (in this case 200 milliseconds), a TimeoutException will be
 * thrown.
 * 
 * The isDone() method can be used to check if the assigned task is already
 * processed or not.
 * 
 * The Future interface also provides for the cancellation of task execution
 * with the cancel() method, and to check the cancellation with isCancelled()
 * method:
 * 
 * boolean canceled = future.cancel(true); boolean isCancelled =
 * future.isCancelled();
 */