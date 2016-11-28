package com.netcracker.crm.dao.exception;

/**
 * Created by egor on 20.11.2016.
 */
public class ConstraintViolatedDaoException extends DaoException {
    public ConstraintViolatedDaoException(String message) {
        super(message);
    }

    public ConstraintViolatedDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
