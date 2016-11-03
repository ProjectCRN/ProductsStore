package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by egor on 24.10.2016.
 */
public class UserDaoImpl extends AbstractDao<User>{

//наапример
    public static final String GET_BY_ID_SQL =
            "SELECT UserId, Login, Password, Username FROM TBL_USER WHERE UserId=?";


    @Override
    public void add(User entity) throws DaoException {

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
            result = new User(resultSet.getInt("UserId"),
                resultSet.getString("Login"),
                resultSet.getString("Password"),
                resultSet.getString("Username"),
                resultSet.getString("Username"),
                resultSet.getString("Username"));
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
}