package com.netcracker.crm.dao.impl;

import com.netcracker.crm.constants.ColumnName;
import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.EntityBuilder;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.util.JdbcUtils;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.proxy.annotation.Pre;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by egor on 06.11.2016.
 */
public class UserDaoImplCalls extends AbstractDao<User> {

    @Override
    public int add(User user) throws DaoException {
        CallableStatement callableStatement = null;
        int id;
        try{
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall(
                    "{ call sp_user_insert(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, user.getLogin());
            callableStatement.setString(2, user.getPassword());
            callableStatement.setString(3, user.getUserName());
            callableStatement.setString(4, user.getContactPhone());
            callableStatement.setString(5, user.getContactAddress());
            callableStatement.setString(6, user.getRoleId());
            callableStatement.registerOutParameter(7,OracleTypes.NUMBER);
            callableStatement.execute();
            id = callableStatement.getInt(7);
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(callableStatement);
        }
        return id;
    }
    public int add(String login, String password, String userName, String contactPhone, String contactAddress, String roleId)throws DaoException {
        CallableStatement callableStatement = null;
        int id;
        try{
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall(
                    "{ call sp_user_insert(?,?,?,?,?,?,?)}");
            callableStatement.setString(1,login);
            callableStatement.setString(2, password);
            callableStatement.setString(3, userName);
            callableStatement.setString(4, contactPhone);
            callableStatement.setString(5, contactAddress);
            callableStatement.setString(6, roleId);
            callableStatement.registerOutParameter(7,OracleTypes.NUMBER);
            callableStatement.execute();
            id = callableStatement.getInt(7);
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(callableStatement);
        }
        return id;
    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> resultList = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT USERID, LOGIN, PASSWORD, USERNAME, CONTACTPHONE,CONTACTADRESS, ROLEID FROM TBL_USER ORDER BY USERID");
            resultSet = statement.executeQuery();
            resultList = new ArrayList<>();
            while(resultSet.next()) {
                User result = buildUser(resultSet);
                 resultList.add(result);
            }
            connection.commit();
         } catch (SQLException e){
        throw new DaoException("some exception", e);
        } finally {
         JdbcUtils.closeQuietly(statement, resultSet );
        }
        return resultList;
    }

    @Override
    public User getById(int id) throws DaoException{
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        User result = null;
        try{
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{ call sp_get_user(?,?)}");
            callableStatement.setInt(1,id);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
            callableStatement.execute();
            resultSet = (ResultSet)callableStatement.getObject(2);
            if (!resultSet.next()){
                throw new DaoException("No account for id  = " + id);
            }
            result = buildUser(resultSet);
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(resultSet, callableStatement);
        }
        return result;
    }

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public User update(int id, Map<String,String> params) throws DaoException{
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try{
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{ call sp_update_user(?,?,?,?,?,?)}");


            callableStatement.setInt(1,id);
            callableStatement.setString(2,params.get("login"));
            callableStatement.setString(3,params.get("password"));
            callableStatement.setString(4,params.get("username"));
            callableStatement.setString(5,params.get("phone"));
            callableStatement.setString(6,params.get("address"));
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(resultSet, callableStatement);
        }
        return getById(id);
    }

    @Override
    public int getMaxId() throws DaoException {
        PreparedStatement preparedStatement= null;
        ResultSet rs = null;
        int id = -1;
        try{
            Connection connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT MAX(USERID) FROM TBL_USER");
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                id = rs.getInt(1);
            }
            connection.commit();
        } catch (SQLException e){
            throw new DaoException("some exception", e);
        } finally {
            JdbcUtils.closeQuietly(preparedStatement, rs );
        }
        return id;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private User buildUser(ResultSet resultSet) throws SQLException{
        User result;
        int userId = resultSet.getInt(ColumnName.USER_ID);
        String login = resultSet.getString(ColumnName.USER_LOGIN);
        String password = resultSet.getString(ColumnName.USER_PASSWORD);
        String userName = resultSet.getString(ColumnName.USER_USERNAME);
        String contactPhone = resultSet.getString(ColumnName.USER_PHONE);
        String contactAddress = resultSet.getString(ColumnName.USER_ADDRESS);
        String roleId = resultSet.getString(ColumnName.USER_ROLEID);
        result = EntityBuilder.buildUser(userId,login,password,userName,contactPhone,contactAddress,roleId);
        return result;
    }
}