package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.rowmapper.UserRowMapper;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.utils.EntityBuilder;
import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by egor on 11.11.2016.
 */
public class UserDaoImpl  extends AbstractDao<User> implements IUserDao {

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
        jdbcTemplate.update(sql, args);
        return id;
    }

    @Override
    public List<User> getAll() {
        final String sql = "SELECT * FROM TBL_USER";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList = new ArrayList<>();
        userList = jdbcTemplate.query(sql, new UserRowMapper());
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

        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        return user;
    }

    @Override
    public void delete(int id) {
        final String sql = "DELETE FROM TBL_USER WHERE +"
                + COLUMN_USER_ID + " = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{id});
    }

    private int getKey(){
        final String sql = "SELECT SQ_MAIN.NEXTVAL from dual";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int out = jdbcTemplate.queryForObject(sql, Integer.class);
        return  out;
    }
    @Override
    public List<User> getAllByRole(String roleId) {
        final String sql = "SELECT * FROM TBL_USER WHERE ROLEID = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList = new ArrayList<>();
        userList = jdbcTemplate.query(sql, new Object[]{roleId}, new UserRowMapper());
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
        jdbcTemplate.update(sql, args);
    }
}
