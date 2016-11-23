package com.netcracker.crm.services;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by пк on 20.11.2016.
 */
public interface IEntityService<T extends AbstractEntity> extends IService<T> {
    public void update(int id,  String entityName, int isActive, int userId, List<Value> valuesArr);
    public void updateByEntity(Entity entity);
    public List<T> getList(String atributesId,String values,String operators);
}
