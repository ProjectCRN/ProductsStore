package com.netcracker.crm.entity;

/**
 * Created by egor on 23.10.2016.
 */

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Entity extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String entityName;
    private boolean isActive;
    private int entityTypeId;
    private String entityTypeName;
    private int userId;
    private List<Value> valueList;
    private List<Pair<Atribute,Value>> atributeValueMap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Entity entity = (Entity) o;

        if (isActive != entity.isActive) return false;
        if (entityTypeId != entity.entityTypeId) return false;
        if (userId != entity.userId) return false;
        if (!entityName.equals(entity.entityName)) return false;
        return entityTypeName.equals(entity.entityTypeName);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + entityName.hashCode();
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + entityTypeId;
        result = 31 * result + entityTypeName.hashCode();
        result = 31 * result + userId;
        return result;
    }

    public Entity() {
    }

    public Entity(int id) {
        super(id);
    }


    @Override
    public String toString() {
        String str= "Entity{" +
                "entityId="+getId()+
                "\nentityName='" + entityName + '\'' +
                ", isActive=" + isActive +
                ", entityTypeId=" + entityTypeId +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", userId=" + userId +
                '}';
        if(atributeValueMap!=null) {
            for (Pair<Atribute, Value> item : atributeValueMap) {
                str += "\n" + item.getKey().toString();
                str += "\n" + item.getValue().toString();
            }
        }
        return str;
    }

    public Entity(int id, String entityName, boolean isActive, int entityTypeId, String entityTypeName, int userId) {
        super(id);
        this.entityName = entityName;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.entityTypeName = entityTypeName;
        this.userId = userId;
    }

    public Entity(String entityName, boolean isActive, int entityTypeId, int userId, List<Value> valueList) {
        this.entityName = entityName;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.entityTypeName = entityTypeName;
        this.userId = userId;
        this.valueList = valueList;
    }

    public String getEntityName() {
        return entityName;
    }

    public int getisActive() {
        return ((isActive==true) ? 1 : 0);
    }

    public int getEntityTypeId() {
        return entityTypeId;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public int getEntityUserId() {
        return userId;
    }

    public List<Value> getValueList() {
        if(atributeValueMap!=null) {
            List<Value> values = new ArrayList<>();
            for (Pair<Atribute, Value> p : atributeValueMap) {
                values.add(p.getValue());
            }
            return values;
        } else return null;
        //return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }

    public List<Pair<Atribute,Value>> getAtributeValueMap() {
        return atributeValueMap;
    }

    public void setAtributeValueMap(List<Pair<Atribute,Value>> atributeValueMap) {
        this.atributeValueMap = atributeValueMap;
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
