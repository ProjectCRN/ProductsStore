package com.netcracker.crm.dao;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.AbstractEntity;

/**
 * Created by egor on 03.11.2016.
 */
public interface IDao<T extends AbstractEntity> {
    int add(T abstractEntity) throws DaoException;
    T getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    //void setDataSource(DataSource dataSource);
}
