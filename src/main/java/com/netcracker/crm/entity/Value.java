package com.netcracker.crm.entity;

/**
 * Created by οκ on 12.11.2016.
 */
public class Value extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String valueName;
    private int entityId;
    private int atributeId;

    public Value() {
    }

    public Value(int valueId, String valueName, int entityId, int atributeId) {
        super(valueId);
        this.valueName = valueName;
        this.entityId = entityId;
        this.atributeId = atributeId;
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

    public void setValueName(String valueName) {
        this.valueName = valueName;
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
        result = prime * result + valueName.hashCode();
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
        if (!valueName.equals(other.valueName)) return false;
        if(entityId != other.entityId) return false;
        if(atributeId != other.atributeId) return false;
        return true;
    }

}
