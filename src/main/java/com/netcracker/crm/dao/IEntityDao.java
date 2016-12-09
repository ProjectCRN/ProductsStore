package com.netcracker.crm.dao;

import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by di on 12.11.2016.
 */
public interface IEntityDao extends IDao<Entity> {
    public int update(int id, String entityName, int isActive, int userId, List<Value> valuesArr);

    public int updateByEntity(Entity entity);

    public List<Entity> getList(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize, String role);

    public List<Entity> getList(int typeId, String atributesId, String values, String operators, String atributesIdView);

    public List<Entity> getByUserAndType(Integer userID, Integer entityTypeID, String atributesIdView);

    public int rowCounter(int typeId, String atributesId, String values, String operators, String role);

    public void restore(int id);
}
