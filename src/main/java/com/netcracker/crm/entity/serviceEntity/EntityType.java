package com.netcracker.crm.entity.serviceEntity;

/**
 * Created by пк on 22.11.2016.
 */
public enum EntityType {
    //id должны быть фиксированы у всех
    Order(6), Phone(8), Tablet(9);

    private int typeId;

    EntityType(int id) {
        typeId = id;
    }

    public int getTypeId() {
        return typeId;
    }
}
