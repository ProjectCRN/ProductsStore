package com.netcracker.crm.entity;

/**
 * Created by οκ on 12.11.2016.
 */
public class Value extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private int valueId;
    private String valueName;
    private int entityId;
    private int atributeId;

    public Value() {
    }

    public Value(int valueId, String valueName, int entityId, int atributeId) {
        this.valueId = valueId;
        this.valueName = valueName;
        this.entityId = entityId;
        this.atributeId = atributeId;
    }

    public int getValueId() {
        return valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setAtributeId(int atributeId) {
        this.atributeId = atributeId;
    }
}
