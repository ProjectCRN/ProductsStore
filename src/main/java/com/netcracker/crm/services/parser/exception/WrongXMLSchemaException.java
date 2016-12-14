package com.netcracker.crm.services.parser.exception;

import com.netcracker.crm.services.exception.ServiceException;


public class WrongXMLSchemaException extends ServiceException {
    public WrongXMLSchemaException(String message) {
        super(message);
    }

    public WrongXMLSchemaException(String message, Throwable cause) {
        super(message, cause);
    }
}
