package com.netcracker.crm.dao.exception;

/**
 * Created by egor on 24.10.2016.
 */
public class DaoException extends Exception{
    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }

}
