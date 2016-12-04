package com.netcracker.crm.dao.validation;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

/**
 * Created by Nastya on 12/4/2016.
 */
public class EntityDaoValidation implements IEntityValidation  {

    @Override
    public void updateValidation(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {

    }

    @Override
    public void addValidation(Entity entity) {

    }

    @Override
    public void updateByEntityValidation(Entity entity) {

    }

    @Override
    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize) {

    }

    @Override
    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView) {

    }

    @Override
    public void getByUserAndTypeValidation(Integer userID, Integer entityTypeID, String atributesIdView) {

    }

    @Override
    public void rowCounterValidation(int typeId, String atributesId, String values, String operators) {

    }
    private boolean validAttribute (int typeId, int attributeId){
        return true;
    }
}
