package com.netcracker.crm.entity;

/**
 * Created by egor on 23.10.2016.
 */

import com.netcracker.crm.services.parser.AbstractTag;
import com.netcracker.crm.services.parser.exception.NoSuchTagException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Entity extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String entityName;
    private boolean isActive;
    private Integer entityTypeId;
    private String entityTypeName;
    private Integer userId;
    private List<Value> valueList;
    private List<Pair<Atribute, Value>> atributeValueMap;


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
        String str = "Entity{" +
                "entityId=" + getId() +
                "\nentityName='" + entityName + '\'' +
                ", isActive=" + isActive +
                ", entityTypeId=" + entityTypeId +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", userId=" + userId +
                '}';
        if (atributeValueMap != null) {
            for (Pair<Atribute, Value> item : atributeValueMap) {
                str += "\n" + item.getKey().toString();
                str += ": " + item.getValue().toString();
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
        valueList = new ArrayList<>();
    }

    public Entity(int id, String entityName, boolean isActive, int entityTypeId, int userId, List<Value> valueList) {
        this(id, entityName, isActive, entityTypeId, AbstractTag.getTag(entityTypeId).getTypeName(), userId);
        this.valueList = valueList;
    }

    public Entity(String entityName, boolean isActive, int entityTypeId, int userId, List<Value> valueList) {
        this(entityName, isActive, entityTypeId, userId);
        this.valueList = valueList;
    }

    public Entity(String entityName, boolean isActive, int entityTypeId, int userId) {
        this.entityName = entityName;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.entityTypeName = AbstractTag.getTag(entityTypeId).getTypeName();
        this.userId = userId;
        valueList = new ArrayList<>();
    }

    public String getEntityName() {
        return entityName;
    }

    public int getisActive() {
        return ((isActive == true) ? 1 : 0);
    }

    public Integer getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(Integer entityTypeId) {
        this.entityTypeId = entityTypeId;
        this.entityTypeName =  AbstractTag.getTag(entityTypeId).getTypeName();
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEntityUserId() {
        return userId;
    }

    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }

    public List<Pair<Atribute, Value>> getAtributeValueMap() {
        return atributeValueMap;
    }

    public void setAtributeValueMap(List<Pair<Atribute, Value>> atributeValueMap) {
        this.atributeValueMap = atributeValueMap;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }


    protected Integer getAtributeId(String atribute){
        AbstractTag tag = AbstractTag.getTag(getEntityTypeId());
        if (tag != null) {
            try {
                return tag.getIdByName(atribute);
            } catch (NoSuchTagException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setValueInList(String atribute, String value){
        for (int i = 0; i < getValueList().size(); i++) {
            if (getValueList().get(i).getAtributeId() == getAtributeId(atribute)) {
                getValueList().get(i).setValue(value);
                return;
            }
        }
        getValueList().add(new Value(value, getId(), getAtributeId(atribute)));
    }

    public void setValueInList(int atributeId, String value){
        for (int i = 0; i < getValueList().size(); i++) {
            if (getValueList().get(i).getAtributeId() == atributeId) {
                getValueList().get(i).setValue(value);
                return;
            }
        }
        getValueList().add(new Value(value, getId(), atributeId));
    }

    public String getValueFromMap(String atribute) {
        for (int i = 0; i < getAtributeValueMap().size(); i++) {
            if (getAtributeValueMap().get(i).getKey().getAtributeName().equals(atribute)) {
                return getAtributeValueMap().get(i).getValue().getValue();
            }
        }
        return null;
    }

    public String getValueFromMap(int atributeId) {
        for (int i = 0; i < getAtributeValueMap().size(); i++) {
            if (getAtributeValueMap().get(i).getKey().getId()==atributeId) {
                return getAtributeValueMap().get(i).getValue().getValue();
            }
        }
        return null;
    }
}
