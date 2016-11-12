package com.netcracker.crm.dao;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by egor on 03.11.2016.
 */
public abstract class AbstractDao<T extends AbstractEntity> implements IDao<T>{
    @Autowired
    protected DataSource dataSource;
}
