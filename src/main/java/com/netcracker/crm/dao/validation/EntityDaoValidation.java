package com.netcracker.crm.dao.validation;

import com.netcracker.crm.dao.IEntityDao;
import static com.netcracker.crm.dao.constants.DaoConstants.*;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nastya on 12/4/2016.
 */
public class EntityDaoValidation implements IEntityValidation  {
    private final List<String> operators = (Arrays.asList(">","<","<=",">=","=","like","isnull"));

    @Override
    public void updateValidation(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {

    }

    @Override
    public void addValidation(Entity entity) {

    }

    @Override
    public void getByIdValidation(int id) {

    }

    @Override
    public void updateByEntityValidation(Entity entity) {

    }

    @Override
    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize) {
        if(pageNumber<1 || pageSize<1)
            throw new DaoException("Invalid pageNumber or pageSize");
        this.getListValidation(typeId, atributesId, values, operators, atributesIdView);
    }

    @Override
    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView) {
        /*if (!idInTable(TABLE_ENTITYTYPE,typeId))    // TABLE_ENTITYTYPE - error, can not find
            throw new DaoException("Invalid TypeId");
        */
    }

    @Override
    public void getByUserAndTypeValidation(Integer userID, Integer entityTypeID, String atributesIdView) {

    }

    @Override
    public void rowCounterValidation(int typeId, String atributesId, String values, String operators) {

    }

    @Override
    public boolean idInTable(String tableName, int id) {
        return true;
    }

    private boolean validAttribute (int typeId, int attributeId){
        return true;
    }
    private boolean validValues (int typeId, int attributeId,int entityId){
        return true;
    }
}
