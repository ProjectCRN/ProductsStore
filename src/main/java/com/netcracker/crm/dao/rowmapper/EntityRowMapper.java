package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EntityRowMapper implements RowMapper<Entity> {

    @Override
    public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
        EntityExtractor entityExtractor = new EntityExtractor();
        return entityExtractor.extractData(resultSet);
    }
}
