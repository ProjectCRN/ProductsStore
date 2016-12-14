package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.utils.EntityBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.netcracker.crm.dao.constants.DaoConstants.*;


public class UserExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return EntityBuilder.buildUser(
                resultSet.getInt(COLUMN_USER_ID),
                resultSet.getString(COLUMN_USER_LOGIN),
                resultSet.getString(COLUMN_USER_PASSWORD),
                resultSet.getString(COLUMN_USER_USERNAME),
                resultSet.getString(COLUMN_USER_PHONE),
                resultSet.getString(COLUMN_USER_ADDRESS),
                resultSet.getString(COLUMN_USER_ROLEID),
                resultSet.getString(COLUMN_USER_EMAIL));
    }
}
