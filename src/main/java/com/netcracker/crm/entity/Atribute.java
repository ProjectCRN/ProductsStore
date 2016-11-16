package com.netcracker.crm.entity;

/**
 * Created by �� on 13.11.2016.
 */
public class Atribute extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private String atributeName;
    private int atributeTypeId;
    private String atributeTypeName;
    private boolean isActive;
    private int entityTypeId;
    private String entityTypeName;
    private boolean isRequired;

    public Atribute() {}

    public Atribute(int id, String atributeName, int atributeTypeId, boolean isActive, int entityTypeId, boolean isRequired) {
        super(id);
        this.atributeName = atributeName;
        this.atributeTypeId = atributeTypeId;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.isRequired = isRequired;
    }

    public Atribute(int id, String atributeName, int atributeTypeId, String atributeTypeName,
                    boolean isActive, int entityTypeId, String entityTypeName, boolean isRequired) {
        super(id);
        this.atributeName = atributeName;
        this.atributeTypeId = atributeTypeId;
        this.atributeTypeName = atributeTypeName;
        this.isActive = isActive;
        this.entityTypeId = entityTypeId;
        this.entityTypeName = entityTypeName;
        this.isRequired = isRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Atribute atribute = (Atribute) o;

        if (atributeTypeId != atribute.atributeTypeId) return false;
        if (isActive != atribute.isActive) return false;
        if (entityTypeId != atribute.entityTypeId) return false;
        if (entityTypeName != atribute.entityTypeName) return false;
        if (isRequired != atribute.isRequired) return false;
        if (!atributeName.equals(atribute.atributeName)) return false;
        return atributeTypeName.equals(atribute.atributeTypeName);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int prime = 31;
        result = prime * result + atributeName.hashCode();
        result = prime * result + atributeTypeId;
        result = prime * result + atributeTypeName.hashCode();
        result = prime * result + (isActive ? 1 : 0);
        result = prime * result + entityTypeId;
        result = prime * result + entityTypeName.hashCode();
        result = prime * result + (isRequired ? 1 : 0);
        return result;
    }

    public String getAtributeName() {
        return atributeName;
    }

    public int getAtributeTypeId() {
        return atributeTypeId;
    }

    public String getAtributeTypeName() {
        return atributeTypeName;
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

    public boolean isRequired() {
        return isRequired;
    }

    public void setAtributeName(String atributeName) {
        this.atributeName = atributeName;
    }

    public void setAtributeTypeId(int atributeTypeId) {
        this.atributeTypeId = atributeTypeId;
    }

    public void setAtributeTypeName(String atributeTypeName) {
        this.atributeTypeName = atributeTypeName;
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

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public String toString() {
        return "Atribute{" +
                "atributeName='" + atributeName + '\'' +
                ", atributeTypeId=" + atributeTypeId +
                ", atributeTypeName='" + atributeTypeName + '\'' +
                ", isActive=" + isActive +
                ", entityTypeId=" + entityTypeId +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", isRequired=" + isRequired +
                '}';
    }
}
