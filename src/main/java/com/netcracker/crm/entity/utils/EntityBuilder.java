package com.netcracker.crm.entity.utils;

import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;

/**
 * Created by egor on 06.11.2016.
 */
public class EntityBuilder {
    private EntityBuilder() {
    }

    public static User buildUser(int userId, String login, String password, String userName, String contactPhone, String contactAddress, String roleId) {
        User user = new User();
        user.setId(userId);
        user.setLogin(login);
        user.setPassword(password);
        user.setUserName(userName);
        user.setContactPhone(contactPhone);
        user.setContactAddress(contactAddress);
        user.setRoleId(roleId);
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

}
