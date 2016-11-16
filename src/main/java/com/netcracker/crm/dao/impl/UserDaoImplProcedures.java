package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.entity.utils.EntityBuilder;
import com.netcracker.crm.entity.User;
import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by egor on 10.11.2016.
 */
@Repository
public class UserDaoImplProcedures extends AbstractDao<User> implements IUserDao{

    // protected dataSource есть у AbstractDao
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int add(User entity) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                 .withProcedureName(PROCEDURE_USER_INSERT);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(PARAM_IN_USER_LOGIN, entity.getLogin())
                .addValue(PARAM_IN_USER_PASSWORD, entity.getPassword())
                .addValue(PARAM_IN_USER_USERNAME, entity.getUserName())
                .addValue(PARAM_IN_USER_PHONE, entity.getContactPhone())
                .addValue(PARAM_IN_USER_ADDRESS, entity.getContactAddress())
                .addValue(PARAM_IN_USER_ROLEID, entity.getRoleId() );
        Map results = jdbcCall.execute(in);
        Integer outID = ((BigDecimal) results.get(PARAM_OUT_USER_ID)).intValue();
        return outID;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(int id){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SqlParameterSource in = new MapSqlParameterSource().addValue(PARAM_IN_USER_ID, id);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(PROCEDURE_USER_GET)
                .returningResultSet(PARAM_OUT_USER, rowMapper);
        Map result = jdbcCall.execute(in);
        List<User> userList= new ArrayList<>((ArrayList)result.get(PARAM_OUT_USER));
        if (userList.size() == 0){
            System.out.println("Cannot find user with id = " + id);
            return null;
        }
        User user = userList.get(0);
        return user;
    }

    @Override
    public void delete(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(PROCEDURE_USER_DELETE);
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(PARAM_IN_USER_ID, id);
        jdbcCall.execute(in);

    }


    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return EntityBuilder.buildUser(
                    resultSet.getInt(COLUMN_USER_ID),
                    resultSet.getString(COLUMN_USER_LOGIN),
                    new String("unknown"),
                    resultSet.getString(COLUMN_USER_USERNAME),
                    resultSet.getString(COLUMN_USER_PHONE),
                    resultSet.getString(COLUMN_USER_ADDRESS),
                    resultSet.getString(COLUMN_USER_ROLEID));
        }
    };

    @Override
    public List<User> getAllByRole(String roleId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SqlParameterSource in = new MapSqlParameterSource().addValue(PARAM_IN_USER_ROLEID, roleId);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(PROCEDURE_USER_GET_LIST)
                .returningResultSet(PARAM_OUT_USER_LIST, BeanPropertyRowMapper.newInstance(User.class));
        Map result = jdbcCall.execute(in);
        List<User> userList= new ArrayList<>((ArrayList)result.get(PARAM_OUT_USER_LIST));
        return userList;
    }

    @Override
    public Map<Integer, String> login(String login) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(PROCEDURE_USER_LOGIN);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(PARAM_IN_LOGIN, login, OracleTypes.NVARCHAR);

        Map results = jdbcCall.execute(in);
        final Integer outID = ((BigDecimal) results.get(PARAM_OUT_USER_ID)).intValue();
        final String outPassword = (String) results.get(PARAM_OUT_USER_PASSWORD);
        Map <Integer,String> idAndPassword = new HashMap(){{put(outID,outPassword);}};
        System.out.println(outID  + outPassword);
        return idAndPassword;
    }

    @Override
    public void update(int id, String uLogin, String uPassword, String uName, String uPhone, String uAddress) {

    }


}
