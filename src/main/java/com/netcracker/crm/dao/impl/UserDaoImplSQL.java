package com.netcracker.crm.dao.impl;

import com.netcracker.crm.constants.ColumnName;
import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.EntityBuilder;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.util.JdbcUtils;

import javax.sql.DataSource;
import java.awt.peer.CanvasPeer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by egor on 24.10.2016.
 */
public class UserDaoImplSQL extends AbstractDao<User>{

//например
    public static final String GET_BY_ID_SQL =
            "SELECT * FROM TBL_USER WHERE UserId=?";


    @Override
    public int add(User entity) throws DaoException {
            return 0;
    }

    @Override
    public List<User> getAll() throws DaoException {
        return null;
    }

    @Override
    public User getById(int id) throws DaoException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User result = null;
        try{
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(GET_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()){
                throw new DaoException("No account for id  = " + id);
            }

            int userId = resultSet.getInt(ColumnName.USER_ID);
            String login = resultSet.getString(ColumnName.USER_LOGIN);
            String password = resultSet.getString(ColumnName.USER_PASSWORD);
            String userName = resultSet.getString(ColumnName.USER_USERNAME);
            String contactPhone = resultSet.getString(ColumnName.USER_PHONE);
            String contactAddress = resultSet.getString(ColumnName.USER_ADDRESS);
            String roleId = resultSet.getString(ColumnName.USER_ROLEID);
            result = EntityBuilder.buildUser(userId,login,password,userName,contactPhone,contactAddress,roleId);
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(resultSet, preparedStatement);
        }
        return result;
}

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public int getMaxId() throws DaoException {
        return 0;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User update(int id, Map<String, String> newParams) throws DaoException {
        return null;
    }
}