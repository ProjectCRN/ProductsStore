package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum PhoneAtribute {
    Price(25),
    Summary(26),
    OperatingSystem(27),
    Processorspeed(28),
    Capacity(29),
    Display(30),
    Height(31),
    Width(32),
    Depth(33),
    Weight(34),
    Camera(35),
    Battery(36),
    SIMCard(37),
    ImageURL(38),
    Fabricator(39);

    private int atributeId;

    PhoneAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public static PhoneAtribute findByKey(int i) {
        for (PhoneAtribute eEnum : values()) {
            if (eEnum.atributeId == i) {
                return eEnum;
            }
        }
        return null;
    }
}
