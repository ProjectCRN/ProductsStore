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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(User user) throws DaoException {
        final String sql = "INSERT INTO TBL_USER (" +
                COLUMN_USER_ID + ", " +
                COLUMN_USER_LOGIN + ", " +
                COLUMN_USER_PASSWORD + ", " +
                COLUMN_USER_USERNAME + ", " +
                COLUMN_USER_PHONE + ", " +
                COLUMN_USER_ADDRESS + ", " +
                COLUMN_USER_ROLEID + ", " +
                COLUMN_USER_EMAIL +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int id = getKey();
        Object[] args = new Object[] {
                id,
                user.getLogin(),
                user.getPassword(),
                user.getUserName(),
                user.getContactPhone(),
                user.getContactAddress(),
                user.getRoleId(),
                user.getEmail()
        };
        try {
            getJdbcTemplate().update(sql, args);
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
    public List<User> getAll() throws DaoException {
        final String sql = "SELECT * FROM TBL_USER";
        List<User> userList;
        try {
            userList = getJdbcTemplate().query(sql, new UserRowMapper());
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
    public User getById(int id) throws DaoException{
        String sql = "SELECT " +
                COLUMN_USER_ID + ", " +
                COLUMN_USER_LOGIN + ", " +
                COLUMN_USER_PASSWORD + ", " +
                COLUMN_USER_USERNAME + ", " +
                COLUMN_USER_PHONE + ", " +
                COLUMN_USER_ADDRESS + ", " +
                COLUMN_USER_ROLEID + ", " +
                COLUMN_USER_EMAIL + " " +
                "FROM TBL_USER WHERE (" +
                COLUMN_USER_ID + " = ?)";

        User user;
        try {
            user = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new UserRowMapper());
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
    public void delete(int id) throws DaoException {
        final String sql = "DELETE FROM TBL_USER WHERE +"
                + COLUMN_USER_ID + " = ?";
        try {
            getJdbcTemplate().update(sql, new Object[]{id});
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getMessage(), e);
        }
    }

    private int getKey() throws DaoException{
        final String sql = "SELECT SQ_MAIN.NEXTVAL from dual";
        int out = -100;
        try {
            out = getJdbcTemplate().queryForObject(sql, Integer.class);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getMessage(), e);
        }
        return  out;
    }
    @Override
    public List<User> getAllByRole(String roleId) throws DaoException{
        final String sql = "SELECT * FROM TBL_USER WHERE ROLEID = ?";
        List<User> userList;
        try {
            userList = getJdbcTemplate().query(sql, new Object[]{roleId}, new UserRowMapper());
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getMessage(), e);
        }
            return userList;
    }

    @Override
    public Map<Integer, String> login(String login) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(int id,String uLogin, String uPassword, String uName,
                       String uPhone, String uAddress, String uEmail) throws DaoException {
        final String sql = "UPDATE TBL_USER SET "+
                COLUMN_USER_LOGIN + "  = ?, " +
                COLUMN_USER_PASSWORD +" = ?, "+
                COLUMN_USER_USERNAME + " = ?, " +
                COLUMN_USER_PHONE +" = ?, " +
                COLUMN_USER_ADDRESS + " = ? " +
                COLUMN_USER_EMAIL + " =? " +
                "WHERE " + COLUMN_USER_ID + " = ?";
        Object[] args = new Object[] {
                uLogin,
                uPassword,
                uName,
                uPhone,
                uAddress,
                uEmail,
                id
        };
        try {
            getJdbcTemplate().update(sql, args);
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
    }

    @Override
    public boolean isLoginFree(String login) throws DaoException {
        final String sql = "SELECT " + COLUMN_USER_LOGIN + " FROM TBL_USER";
        List <String> loginList;
        try {
            loginList = getJdbcTemplate().queryForList(sql, String.class);

        } catch (EmptyResultDataAccessException e) {
            return true;
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
    }
       return (!containsIgnoreCase(loginList, login));
    }


    @Override
    public boolean isEmailFree(String email) throws DaoException {
        final String sql = "SELECT " + COLUMN_USER_EMAIL + " FROM TBL_USER";
        List <String> emailList;
        try {
            emailList = getJdbcTemplate().queryForList(sql, String.class);
       } catch (EmptyResultDataAccessException e) {
            return true;
        } catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new DaoException(e.getCause().getMessage(), e);
        }
        return (!containsIgnoreCase(emailList, email));
    }




    private boolean containsIgnoreCase(List<String> list, String soughtFor) {
        for (String current : list) {
            if (current != null) {
                if (current.equalsIgnoreCase(soughtFor)) {
                    return true;
                }
            }
        }
        return false;
    }


}
