package com.netcracker.crm.services;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by пк on 20.11.2016.
 */
public interface IEntityService<T extends AbstractEntity> extends IService<T> {
    void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr);
}
