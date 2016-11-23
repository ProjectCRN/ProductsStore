package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.ConstraintViolatedDaoException;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.dao.rowmapper.UserRowMapper;
import com.netcracker.crm.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by egor on 11.11.2016.
 */
@Repository("userDao")
public class UserDaoImpl  extends AbstractDao<User> implements IUserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);


    @Override
    public int add(User user) {
        final String sql = "INSERT INTO TBL_USER (" +
                COLUMN_USER_ID + ", " +
                COLUMN_USER_LOGIN + ", " +
                COLUMN_USER_PASSWORD + ", " +
                COLUMN_USER_USERNAME + ", " +
                COLUMN_USER_PHONE + ", " +
                COLUMN_USER_ADDRESS + ", " +
                COLUMN_USER_ROLEID +
                ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int id = getKey();
        Object[] args = new Object[] {
                id,
                user.getLogin(),
                user.getPassword(),
                user.getUserName(),
                user.getContactPhone(),
                user.getContactAddress(),
                user.getRoleId()
        };
        try {
            jdbcTemplate.update(sql, args);
        } catch (DuplicateKeyException e){
            logger.error(e.getMessage());
            throw new ConstraintViolatedDaoException("Duplicate user login", e);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException("Data access Exception", e);
        }
       return id;
    }

    @Override
    public List<User> getAll() {
        final String sql = "SELECT * FROM TBL_USER";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList;
        try {
            userList = jdbcTemplate.query(sql, new UserRowMapper());
        } catch (EmptyResultDataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException("User table is empty", e);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException("Data access Exception", e);
        }
        return userList;
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT " +
                COLUMN_USER_ID + ", " +
                COLUMN_USER_LOGIN + ", " +
                COLUMN_USER_PASSWORD + ", " +
                COLUMN_USER_USERNAME + ", " +
                COLUMN_USER_PHONE + ", " +
                COLUMN_USER_ADDRESS + ", " +
                COLUMN_USER_ROLEID + " " +
                "FROM TBL_USER WHERE (" +
                COLUMN_USER_ID + " = ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User user;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        } catch (EmptyResultDataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException("Can't find user with id = " + id, e);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException("Data access Exception", e);
        }
        return user;
    }

    @Override
    public void delete(int id) {
        final String sql = "DELETE FROM TBL_USER WHERE +"
                + COLUMN_USER_ID + " = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.update(sql, new Object[]{id});
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
    }

    private int getKey(){
        final String sql = "SELECT SQ_MAIN.NEXTVAL from dual";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int out = -100;
        try {
            out = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
        return  out;
    }
    @Override
    public List<User> getAllByRole(String roleId) {
        final String sql = "SELECT * FROM TBL_USER WHERE ROLEID = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList;
        try {
            userList = jdbcTemplate.query(sql, new Object[]{roleId}, new UserRowMapper());
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
            return userList;
    }

    @Override
    public Map<Integer, String> login(String login) {
        return null;
    }

    @Override
    public void update(int id,String uLogin, String uPassword, String uName,
                       String uPhone, String uAddress) {
        final String sql = "UPDATE TBL_USER SET "+COLUMN_USER_LOGIN + "  = ?, " + COLUMN_USER_PASSWORD +" = ?, "+
                COLUMN_USER_USERNAME + " = ?, " + COLUMN_USER_PHONE +" = ?, " + COLUMN_USER_ADDRESS + " = ? " +
                "WHERE " + COLUMN_USER_ID + " = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {
                uLogin,
                uPassword,
                uName,
                uPhone,
                uAddress,
                id
        };
        try {
        jdbcTemplate.update(sql, args);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
    }

    @Override
    public boolean isLoginFree(String login) {
        final String sql = "SELECT " + COLUMN_USER_LOGIN + " FROM TBL_USER";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        List <String> loginList;
        try {
            loginList = jdbcTemplate.queryForList(sql, String.class);

        } catch (EmptyResultDataAccessException e) {
            return true;
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
    }

       return (!containsIgnoreCase(loginList, login));
    }



    private boolean containsIgnoreCase(List<String> list, String soughtFor) {
        for (String current : list) {
            if (current.equalsIgnoreCase(soughtFor)) {
                return true;
            }
        }
        return false;
    }


}
