package com.netcracker.crm.entity;

/**
 * Created by egor on 23.10.2016.
 */

import java.io.Serializable;

public abstract class Entity extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String entityName;
    private boolean isActive;
    private int entityTypeId;
    private String entityTypeName;
    private int userId;

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int prime = 31;
        result = prime * result + entityName.hashCode();
        result = prime * result + (isActive ? 1 : 0);
        result = prime * result + entityTypeId;
        result = prime * result + entityTypeName.hashCode();
        result = prime * result + userId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) return false;

        Entity other = (Entity) obj;
        if (!entityName.equals(other.entityName)) return false;
        if (isActive != other.isActive) return false;
        if(entityTypeId != other.entityTypeId) return false;
        if(userId != other.userId) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Entity [id=" + getId() + "]";
    }

    public Entity() {
    }

    public Entity(int id) {
        super(id);
    }

    public Entity(int id, String entityName, boolean isActive, int entityTypeId, String entityTypeName, int userId) {
        super(id);
        this.entityName = entityName;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.entityTypeName = entityTypeName;
        this.userId = userId;
    }

    public String getEntityName() {
        return entityName;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getEntityTypeId() {
        return entityTypeId;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setEntityTypeId(int entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
