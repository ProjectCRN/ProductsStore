package com.netcracker.crm.dao;

import com.netcracker.crm.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by egor on 03.11.2016.
 */
public abstract class AbstractDao<T extends AbstractEntity> extends JdbcDaoSupport implements IDao<T> {


    /*@Required
    public void setSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*@PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }*/
}
