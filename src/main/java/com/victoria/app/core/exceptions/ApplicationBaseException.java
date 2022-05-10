package com.victoria.app.core.exceptions;

abstract public class ApplicationBaseException extends RuntimeException {
    protected ApplicationBaseException(String message) {
        super(message);
    }
}
