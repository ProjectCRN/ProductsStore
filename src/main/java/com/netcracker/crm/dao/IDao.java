package com.netcracker.crm.dao;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.AbstractEntity;


public interface IDao<T extends AbstractEntity> {
    int add(T abstractEntity) throws DaoException;

    T getById(int id) throws DaoException;

    void delete(int id) throws DaoException;
}
