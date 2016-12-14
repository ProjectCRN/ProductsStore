package com.netcracker.crm.services;


import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.enums.*;


public abstract class AbstractService<T extends AbstractEntity> implements IService<T> {
    protected String getAtributeIdByTypeId(int typeId, String atribute) {
        if (typeId == EntityType.valueOf("Telephone").getTypeId()) {
            return String.valueOf(PhoneAtribute.valueOf(atribute).getAtributeId());
        } else if (typeId == EntityType.valueOf("Tablet").getTypeId()) {
            return String.valueOf(TabletAtribute.valueOf(atribute).getAtributeId());
        } else if (typeId == EntityType.valueOf("ProductInOrder").getTypeId()) {
            return String.valueOf(ProductInOrderAtribute.valueOf(atribute).getAtributeId());
        } else if (typeId == EntityType.valueOf("Order").getTypeId()) {
            return String.valueOf(OrderAtribute.valueOf(atribute).getAtributeId());
        } else return null;
    }
}
