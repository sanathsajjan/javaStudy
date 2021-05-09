package com.java.practice.exception;

import java.io.IOException;

/**
 * @author sanath.bt <p>
 *While creating user defined exception, if we are extending Exception class then it's checked Exception.<p>
If we are extending RunTimeException then it will be unchecked exception.<p>
While overriding a method if the parent is throwing unchecked exception then the exception rule like the overridden method should be of 
same level or it's child exception and it will be applicable only for checked exception.
 */
public class CustomException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5042909143428205869L;

	public CustomException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
