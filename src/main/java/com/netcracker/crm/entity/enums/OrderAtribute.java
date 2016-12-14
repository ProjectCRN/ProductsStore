package com.netcracker.crm.entity.enums;

public enum OrderAtribute {

    OrderNumber(12),
    ContactName(13),
    ContactPhone(14),
    ContactAdress(15),
    Total(16),
    CreatedDate(17),
    PaidDate(18);

    private int atributeId;

    OrderAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public static OrderAtribute findByKey(int i) {
        for (OrderAtribute eEnum : values()) {
            if (eEnum.atributeId == i) {
                return eEnum;
            }
        }
        return null;
    }
}
