package com.rest.httpRestPractice.rest.controller;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
        System.out.println("only message");
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
        System.out.println("message and cause");
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
        System.out.println("only cause");
    }
}
