package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum BoughtProductAtribute {

    Price(60), OrderID(61), ProductID(62), Quantity(63);

    private int atributeId;

    BoughtProductAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}
