package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 22.11.2016.
 */
public enum EntityType {
    Order(7), ProductInOrder(8), Telephone(9), Tablet(10), SmartWatch(11);

    private int typeId;

    EntityType(int id) {
        typeId = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public static EntityType findByKey(int i) {
        for (EntityType eEnum : values()) {
            if (eEnum.typeId == i) {
                return eEnum;
            }
        }
        return null;
    }
}
