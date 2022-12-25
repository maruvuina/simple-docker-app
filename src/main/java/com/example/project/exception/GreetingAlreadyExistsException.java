package com.example.project.exception;

/**
 * Exception to represent state with greeting already exists.
 */
public class GreetingAlreadyExistsException extends RuntimeException {

    public GreetingAlreadyExistsException(String message) {
        super(message);
    }

}
