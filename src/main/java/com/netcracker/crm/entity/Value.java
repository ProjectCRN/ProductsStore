package com.netcracker.crm.entity;

import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.enums.TabletAtribute;


public class Value extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String value;
    private int entityId;
    private int atributeId;

    public Value() {
    }

    public Value(int valueId, String value) {
        super(valueId);
        this.value = value;
    }

    public Value(String value, int entityId, int atributeId) {
        this.value = value;
        this.entityId = entityId;
        this.atributeId = atributeId;
    }

    public Value(int valueId, String value, int entityId, int atributeId) {
        super(valueId);
        this.value = value;
        this.entityId = entityId;
        this.atributeId = atributeId;
    }

    public String getValue() {
        return value;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setAtributeId(int atributeId) {
        this.atributeId = atributeId;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int prime = 31;
        result = prime * result + value.hashCode();
        result = prime * result + entityId;
        result = prime * result + atributeId;
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

        Value other = (Value) obj;
        if (!value.equals(other.value)) return false;
        if (entityId != other.entityId) return false;
        if (atributeId != other.atributeId) return false;
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getAttrValue() {

        if (entityId == EntityType.Telephone.getTypeId()) {
            PhoneAtribute p = PhoneAtribute.findByKey(atributeId);
            return p.toString() + ": " + value;
        }
        TabletAtribute t = TabletAtribute.findByKey(atributeId);
        return t.toString() + ": " + value;
    }
}
