package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum TabletAtribute {
    OrderID(36),
    Price(37),
    Summary(38),
    OperatingSystem(39),
    Processorspeed(40),
    Capacity(41),
    Display(42),
    Height(43),
    Width(44),
    Depth(45),
    Weight(46),
    Camera(47),
    Battery(48),
    SIMCard(49),
    Quantity(50),
    ImageURL(51),
    Fabricator(52);

    private int atributeId;

   TabletAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }
}
