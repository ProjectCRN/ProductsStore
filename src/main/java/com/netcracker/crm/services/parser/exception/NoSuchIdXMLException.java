package com.netcracker.crm.services.parser.exception;

import java.io.IOException;


public class NoSuchIdXMLException extends IOException {

    public NoSuchIdXMLException(String message) {
        super(message);
    }

    public NoSuchIdXMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
