package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum PhoneAtribute {
    Price(23),
    Summary(24),
    OperatingSystem(25),
    Processorspeed(26),
    Capacity(27),
    Display(28),
    Height(29),
    Width(30),
    Depth(31),
    Weight(32),
    Camera(33),
    Battery(34),
    SIMCard(35),
    ImageURL(36),
    Fabricator(37);

    private int atributeId;

    PhoneAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}
