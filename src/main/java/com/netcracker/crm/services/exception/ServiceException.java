package com.netcracker.crm.services.exception;

/**
 * Created by egor on 19.11.2016.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }

}
