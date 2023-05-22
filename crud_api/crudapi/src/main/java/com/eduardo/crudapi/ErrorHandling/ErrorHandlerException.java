package com.eduardo.crudapi.ErrorHandling;

public class ErrorHandlerException extends RuntimeException{

    public ErrorHandlerException() {
    }

    public ErrorHandlerException(String message) {
        super(message);
    }

    public ErrorHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorHandlerException(Throwable cause) {
        super(cause);
    }
}
