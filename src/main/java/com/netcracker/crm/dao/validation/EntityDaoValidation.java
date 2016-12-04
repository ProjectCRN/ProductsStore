package com.netcracker.crm.dao.validation;

import com.netcracker.crm.dao.IEntityDao;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nastya on 12/4/2016.
 */
public class EntityDaoValidation implements IEntityValidation {
    private final List<String> operators = (Arrays.asList(">", "<", "<=", ">=", "=", "like", "isnull"));

    public static void updateValidation(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        if (!idInTable(TABLE_ENTITY, id))
            throw new DaoException("Invalid Id");
        if (entityName == null)
            throw new DaoException("Invalid entityName. Can't be null");
        if (isActive != 0 && isActive != 1)
            throw new DaoException("Invalid isActive. Must be 1 or 0");
        if (valuesArr != null) {
            for (Value val : valuesArr) {
                if (val.getValue() == null) {
                    throw new DaoException("Invalid value. Can't be null");
                }
                if (!idInTable(TABLE_VALUE, val.getId())) {
                    throw new DaoException("Invalid value id");
                }
                if (val.getEntityId() != id) {
                    throw new DaoException("Value doesn't match entity");
                }
                if (!idInTable(TABLE_ATRIBUTE, val.getAtributeId())) {
                    throw new DaoException("Invalid atribute id");
                }
            }
        }
    }

    public void addValidation(Entity entity) {

    }

    public void getByIdValidation(int id) {

    }

    public void updateByEntityValidation(Entity entity) {

    }

    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView, int pageNumber, int pageSize) {
        if (pageNumber < 1 || pageSize < 1)
            throw new DaoException("Invalid pageNumber or pageSize");
        this.getListValidation(typeId, atributesId, values, operators, atributesIdView);
    }

    public void getListValidation(int typeId, String atributesId, String values, String operators, String atributesIdView) {
        if (!idInTable(TABLE_ENTITYTYPE, typeId))
            throw new DaoException("Invalid TypeId");

    }

    public void getByUserAndTypeValidation(Integer userID, Integer entityTypeID, String atributesIdView) {

    }

    public void rowCounterValidation(int typeId, String atributesId, String values, String operators) {

    }

    public static boolean idInTable(String tableName, int id) {

        return true;
    }

    private boolean validAttribute(int typeId, int attributeId) {
        if (typeId == EntityType.valueOf("Telephone").getTypeId()) {
            return PhoneAtribute.findByKey(attributeId) != null ? true : false;
        } else if (typeId == EntityType.valueOf("Tablet").getTypeId()) {
            return TabletAtribute.findByKey(attributeId) != null ? true : false;
        } else if (typeId == EntityType.valueOf("ProductInOrder").getTypeId()) {
            return ProductInOrderAtribute.findByKey(attributeId) != null ? true : false;
        } else if (typeId == EntityType.valueOf("Order").getTypeId()) {
            return OrderAtribute.findByKey(attributeId) != null ? true : false;
        }
        else return false;
    }

    private boolean validValues(int typeId, int attributeId, int entityId) {
        return true;
    }
}
