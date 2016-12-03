package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum ProductInOrderAtribute {

    Price(19), OrderID(21), ProductID(20), Quantity(22);

    private int atributeId;

    ProductInOrderAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}