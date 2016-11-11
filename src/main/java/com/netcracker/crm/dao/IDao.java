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
    int add(T entity);
    List<T> getAll();
    T getById(int id);
    void delete(int id);
    void setDataSource(DataSource dataSource);
    void update(int id, Map<String, String> newParams);
}
