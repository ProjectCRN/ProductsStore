package com.netcracker.crm.services;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.services.exception.ServiceException;

/**
 * Created by egor on 19.11.2016.
 */
public interface IService<T extends AbstractEntity> {
    int add(T abstractEntity) throws ServiceException;
    T getById(int id) throws ServiceException;
    void delete(int id) throws ServiceException;
}
