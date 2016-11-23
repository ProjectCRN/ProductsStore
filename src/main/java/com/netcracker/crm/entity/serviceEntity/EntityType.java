package com.netcracker.crm.entity.serviceEntity;

/**
 * Created by .. on 22.11.2016.
 */
public enum EntityType {

    Order(7), Telephone(8), Tablet(9);

    private int typeId;

    EntityType(int id) {
        typeId = id;
    }

    public int getTypeId() {
        return typeId;
    }
}
