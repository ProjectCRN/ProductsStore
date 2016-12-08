package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.utils.EntityBuilder;
import javafx.util.Pair;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by Nastya on 11/14/2016.
 */
public class AtributeValueExtractor implements ResultSetExtractor <Pair<Atribute,Value>> {
    private int atributeId=0;
    @Override
    public Pair<Atribute,Value> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return new Pair<>(
        EntityBuilder.buildAtribute(
                atributeId=resultSet.getInt(COLUMN_ATRIBUTE_ID),
                resultSet.getString(COLUMN_ATRIBUTE_NAME),
                resultSet.getString(COLUMN_ATRIBUTE_TYPEID),
                resultSet.getString(COLUMN_ATRIBUTE_TYPENAME),
                resultSet.getString(COLUMN_ATRIBUTE_ISACTIVE),
                resultSet.getString(COLUMN_ATRIBUTE_ENTITY_TYPE_ID),
                resultSet.getString(COLUMN_ATRIBUTE_ISREQUIRED),
                resultSet.getString(COLUMN_ATRIBUTE_REGULAREXPRESSION))
                ,
        EntityBuilder.buildValue(
                resultSet.getInt(COLUMN_VALUE_ID),
                resultSet.getString(COLUMN_VALUE),
                resultSet.getString(COLUMN_VALUE_ENTITY_ID),
                atributeId)
        );
    }

}
