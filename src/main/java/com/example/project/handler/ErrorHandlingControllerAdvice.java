package com.example.project.handler;

import com.example.project.exception.GreetingFoundException;
import com.example.project.exception.GreetingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleGreetingNotFoundException(GreetingNotFoundException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(ex.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleGreetingFoundException(GreetingFoundException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .message(ex.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .message(ex.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
