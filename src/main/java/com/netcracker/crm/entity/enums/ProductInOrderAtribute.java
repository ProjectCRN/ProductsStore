package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum ProductInOrderAtribute {

    Price(19), OrderID(21), ProductID(20), Quantity(22), ImageURL(23), Summary(24);

    private int atributeId;

    ProductInOrderAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public static ProductInOrderAtribute findByKey(int i) {
        for (ProductInOrderAtribute eEnum : values()) {
            if (eEnum.atributeId == i) {
                return eEnum;
            }
        }
        return null;
    }
}
