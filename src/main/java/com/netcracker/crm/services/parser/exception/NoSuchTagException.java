package com.netcracker.crm.services.parser.exception;

import java.io.IOException;

/**
 * Created by egor on 27.11.2016.
 */
public class NoSuchTagException extends IOException {
    public NoSuchTagException(String message) {
        super(message);
    }

    public NoSuchTagException(String message, Throwable cause) {
        super(message, cause);
    }
}
