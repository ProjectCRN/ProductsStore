package com.netcracker.crm.entity.enums;

/**
 * Created by пк on 02.12.2016.
 */
public enum TabletAtribute{
    Price(38),
    Summary(39),
    OperatingSystem(40),
    Processorspeed(41),
    Capacity(42),
    Display(43),
    Height(44),
    Width(45),
    Depth(46),
    Weight(47),
    Camera(48),
    Battery(49),
    SIMCard(50),
    ImageURL(51),
    Fabricator(52);

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
