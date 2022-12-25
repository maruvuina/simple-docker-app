package com.example.project.exception;

/**
 * Exception to represent state with greeting not found.
 */
public class GreetingNotFoundException extends RuntimeException {

    public GreetingNotFoundException(String message) {
        super(message);
    }
}
