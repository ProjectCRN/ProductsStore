package com.netcracker.crm.entity.serviceEntity;

/**
 * Created by пк on 22.11.2016.
 */
public enum EntityType {
    Order(7), Phone(8), Tablet(9), SmartWatch(10);

    private int typeId;

    EntityType(int id) {
        typeId = id;
    }

    public int getTypeId() {
        return typeId;
    }
}
