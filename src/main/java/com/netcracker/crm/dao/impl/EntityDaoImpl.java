package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.rowmapper.AtributeValueRowMapper;
import com.netcracker.crm.dao.rowmapper.EntityRowMapper;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by on 12.11.2016.
 */
@Repository("entityDao")
public class EntityDaoImpl extends AbstractDao<Entity> implements IEntityDao {


    public void addValue(List<Value> valuesArr, int idEntity) {
        final String sql = "INSERT INTO TBL_VALUE (" +
                COLUMN_VALUE_ID + ", " +
                COLUMN_VALUE + ", " +
                COLUMN_VALUE_ENTITY_ID + ", " +
                COLUMN_VALUE_ATRIBUTE_ID +
                ") VALUES (?, ?, ?, ?)";
        for (Value item : valuesArr) {
            int id = getKey();
            Object[] args = new Object[]{
                    id,
                    item.getValue(),
                    idEntity,
                    item.getAtributeId()
            };
            getJdbcTemplate().update(sql, args);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(Entity entity) {
        final String sql = "INSERT INTO TBL_ENTITY (" +
                COLUMN_ENTITY_ID + ", " +
                COLUMN_ENTITY_NAME + ", " +
                COLUMN_ENTITY_ISACTIVE + ", " +
                COLUMN_ENTITY_TYPE_ID + ", " +
                COLUMN_ENTITY_USER_ID +
                ") VALUES (?, ?, ?, ?, ?)";
        int id = getKey();
        Object[] args = new Object[]{
                id,
                entity.getEntityName(),
                entity.getisActive(),
                entity.getEntityTypeId(),
                entity.getEntityUserId()
        };
        getJdbcTemplate().update(sql, args);
        addValue(entity.getValueList(), id);

        return id;
    }


    @Override
    public Entity getById(int id) {
        String sql = "SELECT E.ENTITYID ,E.ENTITYNAME ,E.ISACTIVE ,E.ENTITYTYPEID,T.ENTITYTYPENAME ,E.USERID  " +
                "FROM TBL_ENTITY E" +
                "    INNER JOIN TBL_ENTITYTYPE T" +
                "    ON E.ENTITYTYPEID=T.ENTITYTYPEID" +
                "    WHERE (E.ENTITYID = ?)";

        Entity entity = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new EntityRowMapper());
        sql = "SELECT A.ATRIBUTEID ,A.ATRIBUTENAME ,A.ATRIBUTETYPEID ,T.ATRIBUTETYPENAME,A.ISACTIVE ,A.ENTITYTYPEID ,A.ISREQUIRED , V.VALUEID ,V.VALUE ,V.ENTITYID " +
                " FROM TBL_ATRIBUTE A " +
                " INNER JOIN TBL_ATRIBUTETYPE T " +
                " ON A.ATRIBUTETYPEID=T.ATRIBUTETYPEID" +
                " INNER JOIN TBL_VALUE V" +
                " ON A.ATRIBUTEID=V.ATRIBUTEID" +
                " WHERE (V.ENTITYID = ?)" +
                " ORDER BY A.SORTORDER";
        entity.setAtributeValueMap(getJdbcTemplate().query(sql, new Object[]{id}, new AtributeValueRowMapper()));
        return entity;
    }

    public void updateEntity(int id, String entityName, int isActive, int userId) {
        final String sqlUpdateEntity = "UPDATE TBL_ENTITY SET ENTITYNAME = ?, ISACTIVE = ?, " +
                "USERID = ? WHERE ENTITYID = ?";
        Object[] args = new Object[]{
                entityName,
                isActive,
                userId,
                id
        };
        getJdbcTemplate().update(sqlUpdateEntity, args);
    }

    public void updateValue(List<Value> valuesArr) {
        String sql = "UPDATE TBL_VALUE SET VALUE = ? WHERE VALUEID = ?";
        List<Object[]> args = new ArrayList<>(valuesArr.size());
        for (Value v : valuesArr) {
            args.add(new Object[]{v.getValue(), v.getId()});
        }
        getJdbcTemplate().batchUpdate(sql, args);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        //update entity table
        updateEntity(id, entityName, isActive, userId);
        //update value table
        if (valuesArr != null) {
            updateValue(valuesArr);
        }
    }

    @Override
    public void updateByEntity(Entity entity) {
        update(entity.getId(), entity.getEntityName(), entity.getisActive(),
                entity.getEntityUserId(), entity.getValueList());
    }

    @Override
    public List<Entity> getList(int typeId, String atributesId, String values, String operators) {
        getJdbcTemplate().setResultsMapCaseInsensitive(true);
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(PARAM_IN_ENTITY_ENTITYTYPEID, typeId)
                .addValue(PARAM_IN_ENTITY_ATRIBUTES, atributesId)
                .addValue(PARAM_IN_ENTITY_VALUES, values)
                .addValue(PARAM_IN_ENTITY_OPERATORS, operators);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(PROCEDURE_ENTITY_GET_LIST)
                .returningResultSet(PARAM_OUT_ENTITY_LIST, new EntityRowMapper());

        Map result = jdbcCall.execute(in);
        List<Entity> entiyList = new ArrayList<>((ArrayList) result.get(PARAM_OUT_ENTITY_LIST));

        return entiyList;
    }

    @Override
    public List<Entity> getByUserAndType(Integer userID, Integer entityTypeID) {

        String sql = "SELECT  E.ENTITYID ,E.ENTITYNAME ,E.ISACTIVE ,E.ENTITYTYPEID,T.ENTITYTYPENAME ,E.USERID " +
                " FROM TBL_ENTITY E INNER JOIN TBL_ENTITYTYPE T ON E.ENTITYTYPEID=" +
                "T.ENTITYTYPEID WHERE (E." + COLUMN_ENTITY_USER_ID
                + "=?) AND ((? IS NOT NULL AND E." + COLUMN_ENTITY_TYPE_ID + "=?) OR " +
                "(? IS NULL))";

        //maybe namedparameterjdbctemplate
//        Map<String, Object> params = new HashMap<>();
//        params.put("inUser", userID);
//        params.put("inType", entityTypeID);
        List<Entity> entiyList = getJdbcTemplate().query(sql, new Object[]{userID, entityTypeID,
                entityTypeID, entityTypeID}, new EntityRowMapper());
        return entiyList;
    }

    @Override
    public void delete(int id) {
        //final String sqlDeleteValue = "DELETE FROM TBL_VALUE WHERE ENTITYID = ?";
        final String sqlDeleteEntity = "UPDATE TBL_ENTITY SET ISACTIVE = 0 WHERE ENTITYID = ?";
        Object[] args = new Object[]{
                id
        };
        getJdbcTemplate().update(sqlDeleteEntity, args);
    }

    private int getKey() {
        final String sql = "SELECT SQ_MAIN.NEXTVAL from dual";
        int out = getJdbcTemplate().queryForObject(sql, Integer.class);
        return out;
    }

}
