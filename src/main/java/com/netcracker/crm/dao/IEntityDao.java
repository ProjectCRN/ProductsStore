package com.netcracker.crm.dao;

import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by �� on 12.11.2016.
 */
public interface IEntityDao extends IDao<Entity> {
    public void update(int id,  String entityName, int isActive, int userId, List<Value> valuesArr);
    public List<Entity> getList(String atributesId,String values,String operators);

}
