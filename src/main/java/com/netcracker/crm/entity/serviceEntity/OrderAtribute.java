package com.netcracker.crm.entity.serviceEntity;

/**
 * Created by on 30.11.2016.
 */

public enum OrderAtribute {

    OrderNumber(11),
    ContactName(12),
    ContactPhone(13),
    ContactAdress(14),
    Total(15),
    CreatedDate(16),
    PaidDate(17),
    Description(18);

    private int atributeId;

    OrderAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}
