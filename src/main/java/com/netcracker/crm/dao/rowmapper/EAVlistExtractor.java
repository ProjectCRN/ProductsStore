package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.utils.EntityBuilder;
import javafx.util.Pair;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.netcracker.crm.dao.constants.DaoConstants.*;
import static com.netcracker.crm.dao.constants.DaoConstants.COLUMN_ENTITY_TYPE_NAME;
import static com.netcracker.crm.dao.constants.DaoConstants.COLUMN_ENTITY_USER_ID;

/**
 * Created by Nastya on 11/30/2016.
 */
public class EAVlistExtractor implements ResultSetExtractor<Entity> {
    private List<String> entiyIdList;
    @Override
    public Entity extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        int entityId=0,atributeId=0;
        String entityTypeId="";
        List<Pair<Atribute,Value>> atributeValueMap=new ArrayList<>();
        Entity entity=  EntityBuilder.buildEntity(
                resultSet.getInt(COLUMN_ENTITY_ID),
                resultSet.getString(COLUMN_ENTITY_NAME),
                resultSet.getString(COLUMN_ENTITY_ISACTIVE),
                entityTypeId=resultSet.getString(COLUMN_ENTITY_TYPE_ID),
                resultSet.getString(COLUMN_ENTITY_TYPE_NAME),
                resultSet.getString(COLUMN_ENTITY_USER_ID));
        entityId=resultSet.getInt(COLUMN_ENTITY_ID);
        for(String item : this.entiyIdList){
            atributeValueMap.add(
                    new Pair<>(
                            EntityBuilder.buildAtribute(
                                    atributeId=resultSet.getInt(COLUMN_ATRIBUTE_ID+item),
                                    resultSet.getString(COLUMN_ATRIBUTE_NAME+item),
                                    "0",
                                    " ",
                                    "1",
                                    entityTypeId,
                                    "1")
                            ,
                            EntityBuilder.buildValue(
                                    resultSet.getInt(COLUMN_VALUE_ID+item),
                                    resultSet.getString(COLUMN_VALUE+item),
                                    String.valueOf(entityId),
                                    atributeId)
                    )
            );
        }
        entity.setAtributeValueMap(atributeValueMap);
        return entity;
    }
    public EAVlistExtractor(List<String> entiyIdList) {
        this.entiyIdList=new ArrayList<>(entiyIdList);
    }
}
