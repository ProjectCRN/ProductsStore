package com.netcracker.crm.dao;

import com.netcracker.crm.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by egor on 03.11.2016.
 */
public abstract class AbstractDao<T extends AbstractEntity> extends JdbcDaoSupport implements IDao<T>{
    @Autowired
    protected DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
}
