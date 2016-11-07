package com.netcracker.crm.dao;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by egor on 03.11.2016.
 */
public interface IDao<T extends Entity> {
    int add(T entity) throws DaoException;
    List<T> getAll() throws DaoException;
    T getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    int getMaxId() throws DaoException;
    void setDataSource(DataSource dataSource);
    T update(int id, Map<String, String> newParams) throws DaoException;
}
