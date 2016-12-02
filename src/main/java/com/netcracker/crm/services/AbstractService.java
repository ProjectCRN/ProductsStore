package com.netcracker.crm.services;



import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;

/**
 * Created by egor on 11.11.2016.
 */
public abstract class AbstractService<T extends AbstractEntity> implements IService<T>{
    protected Integer getAtributeIdByTypeId(int typeId, String atribute){
        if(typeId== EntityType.valueOf("Telephone").getTypeId()){
            return PhoneAtribute.valueOf(atribute).getAtributeId();
        }
        else if(typeId== EntityType.valueOf("Tablet").getTypeId()){
            return PhoneAtribute.valueOf(atribute).getAtributeId();
        }
        else if(typeId== EntityType.valueOf("ProductInOrder").getTypeId()){
            return PhoneAtribute.valueOf(atribute).getAtributeId();
        }
        else return null;
    }
}
