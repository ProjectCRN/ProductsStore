package com.netcracker.crm.entity.utils;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;

/**
 * Created by egor on 06.11.2016.
 */
public class EntityBuilder {
    private EntityBuilder() {
    }

    public static User buildUser(int userId, String login, String password, String userName, String contactPhone, String contactAddress, String roleId, String email) {
        User user = new User();
        user.setId(userId);
        user.setLogin(login);
        user.setPassword(password);
        user.setUserName(userName);
        user.setContactPhone(contactPhone);
        user.setContactAddress(contactAddress);
        user.setRoleId(roleId);
        user.setEmail(email);
        return user;
    }

    public static Entity buildEntity(int id, String entityName, String isActive, String entityTypeId, String entityTypeName, String  userId) {
        Entity entity = new Entity();
        entity.setId(id);
        entity.setEntityName(entityName);
        entity.setIsActive(((Integer.valueOf(isActive)) == 1));
        entity.setEntityTypeId(Integer.valueOf(entityTypeId));
        entity.setEntityTypeName(entityTypeName);
        entity.setUserId(Integer.valueOf(userId));

        return entity;
    }
    public static Atribute buildAtribute(int id, String atributeName, String atributeTypeId,String atributeTypeName, String isActive, String entityTypeId, String isRequired){
        Atribute atribute = new Atribute();
        atribute.setId(id);
        atribute.setAtributeName(atributeName);
        atribute.setAtributeTypeId(Integer.valueOf(atributeTypeId));
        atribute.setAtributeTypeName(atributeTypeName);
        atribute.setIsActive(((Integer.valueOf(isActive)) == 1));
        atribute.setEntityTypeId(Integer.valueOf(entityTypeId));
        atribute.setIsRequired(((Integer.valueOf(isRequired)) == 1));

        return atribute;
    }
    public static Value buildValue(int valueId, String strvalue, String entityId, int atributeId){
        Value value=new Value();
        value.setId(valueId);
        value.setValue(strvalue);
        value.setEntityId(Integer.valueOf(entityId));
        value.setAtributeId(atributeId);

        return value;
    }

}
