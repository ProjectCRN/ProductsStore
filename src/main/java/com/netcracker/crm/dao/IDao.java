package com.netcracker.crm.dao;

import com.netcracker.crm.entity.AbstractEntity;

import javax.sql.DataSource;

/**
 * Created by egor on 03.11.2016.
 */
public interface IDao<T extends AbstractEntity> {
    int add(T abstractEntity);
    T getById(int id);
    void delete(int id);
    //void setDataSource(DataSource dataSource);
}
