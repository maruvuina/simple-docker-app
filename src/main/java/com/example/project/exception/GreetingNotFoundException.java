package com.example.project.exception;

public class GreetingNotFoundException extends RuntimeException {

    public GreetingNotFoundException(String message) {
        super(message);
    }
}
