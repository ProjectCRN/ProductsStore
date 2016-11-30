package com.netcracker.crm.services.parser.exception;

import java.io.IOException;

/**
 * Created by egor on 27.11.2016.
 */
public class NoSuchTagXMLException extends IOException {
    public NoSuchTagXMLException(String message) {
        super(message);
    }

    public NoSuchTagXMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
