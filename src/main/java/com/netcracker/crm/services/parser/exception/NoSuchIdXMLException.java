package com.netcracker.crm.services.parser.exception;

import com.netcracker.crm.services.exception.ServiceException;

import java.io.IOException;

/**
 * Created by egor on 27.11.2016.
 */
public class NoSuchIdXMLException extends IOException {

    public NoSuchIdXMLException(String message) {
        super(message);
    }

    public NoSuchIdXMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
