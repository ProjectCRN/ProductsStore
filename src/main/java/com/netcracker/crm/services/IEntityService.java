package com.netcracker.crm.services;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Value;

import java.util.List;

public interface IEntityService<T extends AbstractEntity> extends IService<T> {
    int update(int id, String entityName, int isActive, int userId, List<Value> valuesArr);
}
