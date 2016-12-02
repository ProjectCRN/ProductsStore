package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 22.11.2016.
 */
public enum EntityType {
    Order(7), Telephone(8), Tablet(9), SmartWatch(10), BoughtProduct(11);

    private int typeId;

    EntityType(int id) {
        typeId = id;
    }

    public int getTypeId() {
        return typeId;
    }
}
