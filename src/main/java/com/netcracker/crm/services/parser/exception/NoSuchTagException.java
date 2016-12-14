package com.netcracker.crm.services.parser.exception;

import java.io.IOException;


public class NoSuchTagException extends IOException {
    public NoSuchTagException(String message) {
        super(message);
    }

    public NoSuchTagException(String message, Throwable cause) {
        super(message, cause);
    }
}
