package com.ideas2it.employee.exception;

/**
 * <p>
 *   Implemented to create a custom exception
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Dhanesh Kumar
 * </p>
 */
public class IdDoesNotExistException extends Exception {

    public IdDoesNotExistException (String message) {
	super(message);
    }
}

