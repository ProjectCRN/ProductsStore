package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by egor on 11.11.2016.
 */

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        UserExtractor userExtractor = new UserExtractor();
        return userExtractor.extractData(resultSet);
    }
}
