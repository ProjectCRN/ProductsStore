package com.netcracker.crm.dao;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by egor on 03.11.2016.
 */
public interface IDao<T extends Entity> {
    void add(T entity) throws DaoException;
    List<T> getAll() throws DaoException;
    T getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    int getMaxId() throws DaoException;
    void setDataSource(DataSource dataSource);
}
