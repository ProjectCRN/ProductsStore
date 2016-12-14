package com.netcracker.crm.dao.exception;


public class ConstraintViolatedDaoException extends DaoException {
    public ConstraintViolatedDaoException(String message) {
        super(message);
    }

    public ConstraintViolatedDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
