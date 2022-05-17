package com.victoria.app.core.exceptions;

public class RoleNotFoundException extends ApplicationBaseException{
    final static String MESSAGE = "Role Not Found Exception";

    public RoleNotFoundException() {
        super(MESSAGE);
    }
}
