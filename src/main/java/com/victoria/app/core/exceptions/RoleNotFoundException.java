package com.victoria.app.core.exceptions;

public class RoleNotFoundException extends ApplicationBaseException{
    final static String MESSAGE = "RoleNotFoundException";

    public RoleNotFoundException() {
        super(MESSAGE);
    }
}
