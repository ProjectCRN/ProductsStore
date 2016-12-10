package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum TabletAtribute{
    Price(40),
    Summary(41),
    OperatingSystem(42),
    Processorspeed(43),
    Capacity(44),
    Display(45),
    Height(46),
    Width(47),
    Depth(48),
    Weight(49),
    Camera(50),
    Battery(51),
    SIMCard(52),
    ImageURL(53),
    Fabricator(54);

    private int atributeId;

   TabletAtribute(int id) {
        atributeId = id;
    }

    public int getAtributeId() {
        return atributeId;
    }

    public static TabletAtribute findByKey(int i) {
        for (TabletAtribute eEnum : values()) {
            if (eEnum.atributeId == i) {
                return eEnum;
            }
        }
        return null;
    }
}
