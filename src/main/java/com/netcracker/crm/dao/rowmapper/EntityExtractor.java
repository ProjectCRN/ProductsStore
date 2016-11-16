package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.utils.EntityBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by Nastya on 11/13/2016.
 */
public class EntityExtractor implements ResultSetExtractor<Entity> {
    @Override
    public Entity extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return EntityBuilder.buildEntity(
                resultSet.getInt(COLUMN_ENTITY_ID),
                resultSet.getString(COLUMN_ENTITY_NAME),
                resultSet.getString(COLUMN_ENTITY_ISACTIVE),
                resultSet.getString(COLUMN_ENTITY_TYPE_ID),
                resultSet.getString(COLUMN_ENTITY_TYPE_NAME),
                resultSet.getString(COLUMN_ENTITY_USER_ID));

    }
}
