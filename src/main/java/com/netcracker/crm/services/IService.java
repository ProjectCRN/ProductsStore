package com.netcracker.crm.services;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.services.exception.ServiceException;

public interface IService<T extends AbstractEntity> {
    int add(T abstractEntity) throws ServiceException;

    T getById(int id) throws ServiceException;

    void delete(int id) throws ServiceException;
}
