package com.java.practice.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author sanath.bt
 *
 *Only unchecked exceptions are propagated by default. Checked exceptions throw compilation error. But Propagating checked exception (FileNotFoundException) using throws keyword >
  After a method throws an exception, the runtime system searches the call stack for a method that contains a block of code(exception handler) that can handle the exception. 
 * 	The search begins with the method in which the error occurred and proceeds through the call stack in the reverse order in which the methods were called. 
 * 	When an appropriate handler is found, the runtime system passes the exception to the handler. Also, there's a note-worthy point:

Lets say, we have a chain of methods where method3() calls method2() and method2() calls method1(). So when

1) An exception occurs in the method3() and in method3() we don�t have any exception handler.

2) Uncaught exception will be propagated downward in stack i.e it will check appropriate exception handler in the method2().

3) Again in method2 if we don�t have any exception handler then again exception is propagated downward to method1() where it finds exception handler.
 */
class ExceptionPropagation {

	void method3() {
		int result = 100 / 0; // Exception Generated
	}

	void method2() {
		method3();
	}

	void method1() {
		try {
			method2();
		} catch (Exception e) {
			System.out.println("Exception is handled here");
			//Give us the cause of exception eg: / by zero
			System.out.println("detailMessage: " + e.getMessage());
			System.out.println("cause: " + e.getCause());
			//Stacktrace will give us the info saying at which lone number it got failed and the file name etc in the form of array of StackTraceElement.
			System.out.println("stacktrace: " + e.getStackTrace());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			StackTraceElement[] s = e.getStackTrace();//StackElement contains class name, method name, file name and line number
			for (int i = 0; i < s.length; i++) {
//				System.out.println(s[i]);
				ps.println(s[i]);
			}
			System.out.println(baos.toString());
			
		}
	}

	public static void main(String args[]) {
		ExceptionPropagation obj = new ExceptionPropagation();
		obj.method1();
		System.out.println("Continue with Normal Flow...");
	}
}
