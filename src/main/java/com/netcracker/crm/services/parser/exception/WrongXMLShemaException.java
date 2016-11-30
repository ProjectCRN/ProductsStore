package com.netcracker.crm.services.parser.exception;

import com.netcracker.crm.services.exception.ServiceException;

/**
 * Created by egor on 27.11.2016.
 */
public class WrongXMLShemaException extends ServiceException {
    public WrongXMLShemaException(String message) {
        super(message);
    }

    public WrongXMLShemaException(String message, Throwable cause) {
        super(message, cause);
    }
}
