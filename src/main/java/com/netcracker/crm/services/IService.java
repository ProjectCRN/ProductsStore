package com.netcracker.crm.services;

import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.entity.AbstractEntity;

/**
 * Created by egor on 19.11.2016.
 */
public interface IService<T extends AbstractEntity> {
    int add(T abstractEntity);
    T getById(int id);
    void delete(int id);
}
