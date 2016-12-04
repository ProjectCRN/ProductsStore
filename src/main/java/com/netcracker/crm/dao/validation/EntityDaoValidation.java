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
    private static final List<String> operators = (Arrays.asList(">","<","<=",">=","=","like","isnull"));


    public static void updateValidation(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
       validEntity(id,entityName,isActive,userId,valuesArr);
    }


    public static void addValidation(Entity entity) {
        validEntity(entity.getId(),entity.getEntityName(), entity.getisActive(),entity.getEntityUserId(),entity.getValueList());
    }

    public static void getByIdValidation(int id) {
        if (!idInTable(TABLE_ENTITY,id))
            throw new DaoException("Invalid Id");
    }

    public static void updateByEntityValidation(Entity entity) {

    }

    public static void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize) {
        if(pageNumber<1 || pageSize<1) {
            throw new DaoException("Invalid pageNumber or pageSize");
        }
        getListValidation(typeId, atributesId, values, operators, atributesIdView);
    }

    public static void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView) {
        rowCounterValidation(typeId,atributesId,values,operators);
        if(!atributesIdView.equals("")) {
            String[] arr = atributesIdView.split(",");
            for (String ss : arr) {
                if (!validAttribute(typeId, Integer.valueOf(ss))) {
                    throw new DaoException("Invalid attribute for View string");
                }
            }
        }
    }

    public static void getByUserAndTypeValidation(Integer userID, Integer entityTypeID, String atributesIdView) {

    }

    public static void rowCounterValidation(int typeId, String atributesId, String values, String operators) {
        String[] arr;
        int attributeCount=0,valueCount=0,operatorCount=0;
        if (!idInTable(TABLE_ENTITYTYPE,typeId)){
            throw new DaoException("Invalid TypeId");
        }
        if(!atributesId.equals("")){
            arr = atributesId.split(",");
            for ( String ss : arr) {
                attributeCount++;
                if(!validAttribute(typeId,Integer.valueOf(ss))){
                    throw new DaoException("Invalid attribute string");
                }
            }
        }
        if(!values.equals("")) {
            arr = values.split(",");
            for (String ss : arr) {
                valueCount++;
                if (!validValues(typeId, Integer.valueOf(ss))) {
                    throw new DaoException("Invalid value string");
                }
            }
        }
        if(!operators.equals("")) {
            arr = operators.split(",");
            for (String ss : arr) {
                operatorCount++;
                if (!operators.contains(ss)) {
                    throw new DaoException("Invalid operator string");
                }
            }
        }
        if(attributeCount!=valueCount || attributeCount!=operatorCount){
            throw new DaoException("Invalid count of attribute, value or operator string");
        }
    }

    public static boolean idInTable(String tableName, int id) {
        return true;
    }
    private static void validEntity(int id, String entityName, int isActive, int userId, List<Value> valuesArr){
        if (!idInTable(TABLE_ENTITY, id))
            throw new DaoException("Invalid Id");
        if (entityName == null)
            throw new DaoException("Invalid entityName. Can't be null");
        if (isActive != 0 && isActive != 1)
            throw new DaoException("Invalid isActive. Must be 1 or 0");
        if (valuesArr != null) {
            for (Value val : valuesArr) {
                if(val.getValue()==null){
                    throw new DaoException("Invalid value. Can't be null");
                }
                if (!idInTable(TABLE_VALUE, val.getId())) {
                    throw new DaoException("Invalid value id");
                }
                if (val.getEntityId() != id) {
                    throw new DaoException("Value doesn't match entity");
                }
                if(!idInTable(TABLE_ATRIBUTE, val.getAtributeId())){
                    throw new DaoException("Invalid atribute id");
                }
            }
        }
    }

    private static boolean validAttribute (int typeId, int attributeId){
        return true;
    }
    private static boolean validValues (int typeId, int attributeId){
        return true;
    }
}
