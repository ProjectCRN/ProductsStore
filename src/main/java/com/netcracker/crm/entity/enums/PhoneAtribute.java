package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum PhoneAtribute {
    OrderID(19),
    Price(20),
    Summary(21),
    OperatingSystem(22),
    Processorspeed(23),
    Capacity(24),
    Display(25),
    Height(26),
    Width(27),
    Depth(28),
    Weight(29),
    Camera(30),
    Battery(31),
    SIMCard(32),
    Quantity(33),
    ImageURL(34),
    Fabricator(35);

    private int atributeId;

    PhoneAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}
