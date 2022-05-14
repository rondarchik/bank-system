package com.victoria.app.core.exceptions;

public class ManagerNotFoundException extends ApplicationBaseException{
    final static String MESSAGE = "Manager Not Found Exception";

    public ManagerNotFoundException() {
        super(MESSAGE);
    }
}
