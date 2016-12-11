package com.netcracker.crm.dao;

import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by di on 12.11.2016.
 */
public interface IEntityDao extends IDao<Entity> {
    int update(int id, String entityName, int isActive, int userId, List<Value> valuesArr);

    int updateByEntity(Entity entity);

    List<Entity> getList(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize, String role, boolean orderSide);

    List<Entity> getList(int typeId, String atributesId, String values, String operators, String atributesIdView);

    List<Entity> getByUserAndType(Integer userID, Integer entityTypeID, String atributesIdView);

    int rowCounter(int typeId, String atributesId, String values, String operators, String role);

    void restore(int id);

    int countEntityName(int typeid, String name);
}
