package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.AbstractDao;
import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.rowmapper.EntityRowMapper;
import com.netcracker.crm.dao.rowmapper.UserRowMapper;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static com.netcracker.crm.dao.constants.DaoConstants.*;

/**
 * Created by �� on 12.11.2016.
 */
public class EntityDaoImpl extends AbstractDao<Entity> implements IEntityDao {

    public void addValue(List<Value> valuesArr,int idEntity){
        final String sql = "INSERT INTO TBL_VALUE (" +
                COLUMN_VALUE_ID + ", " +
                COLUMN_VALUE + ", " +
                COLUMN_VALUE_ENTITY_ID + ", " +
                COLUMN_VALUE_ATRIBUTE_ID  +
                ") VALUES (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        for (Value item : valuesArr){
            int id = getKey();
            Object[] args = new Object[] {
                    id,
                    item.getValue(),
                    idEntity,
                    item.getAtributeId()
            };
            jdbcTemplate.update(sql, args);
        }
    }

    @Override
    public int add(Entity entity) {
        final String sql = "INSERT INTO TBL_ENTITY (" +
                COLUMN_ENTITY_ID + ", " +
                COLUMN_ENTITY_NAME + ", " +
                COLUMN_ENTITY_ISACTIVE + ", " +
                COLUMN_ENTITY_TYPE_ID + ", " +
                COLUMN_ENTITY_USER_ID  +
                ") VALUES (?, ?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int id = getKey();
        Object[] args = new Object[] {
                id,
                entity.getEntityName(),
                entity.getisActive(),
                entity.getEntityTypeId(),
                entity.getEntityUserId()
        };
        jdbcTemplate.update(sql, args);
        addValue(entity.getValueList(),id);

        return id;
    }


    @Override
    public Entity getById(int id) {
        String sql = "SELECT E.ENTITYID ,E.ENTITYNAME ,E.ISACTIVE ,E.ENTITYTYPEID,T.ENTITYTYPENAME ,E.USERID  " +
                "FROM TBL_ENTITY E" +
                "    INNER JOIN TBL_ENTITYTYPE T" +
                "    ON E.ENTITYTYPEID=T.ENTITYTYPEID" +
                "    WHERE (E.ENTITYID = ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Entity entity = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EntityRowMapper());
        return entity;
    }

    public void updateEntity(int id, String entityName, int isActive, int userId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        final String sqlUpdateEntity = "UPDATE TBL_ENTITY SET ENTITYNAME = ?, ISACTIVE = ?, " +
                "USERID = ? WHERE ENTITYID = ?";
        Object[] args  = new Object[]{
             entityName,
             isActive,
             userId,
             id
        };
        jdbcTemplate.update(sqlUpdateEntity, args);
    }

    public void updateValue(List<Value> valuesArr){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        StringBuilder sqlUpdateValueB = new StringBuilder("UPDATE TBL_VALUE SET VALUE = CASE ");
        for (int i = 0; i < valuesArr.size(); i++) {
            sqlUpdateValueB.append("WHEN VALUEID = ? THEN ? ");
        }
        sqlUpdateValueB.append("END WHERE VALUEID BETWEEN ? AND ?");
        final String sqlUpdateValue = sqlUpdateValueB.toString();
        Object[] args = new Object[valuesArr.size() * 2 + 2];
        for (int i = 0; i < valuesArr.size(); i++) {
            int j = i * 2;
            args[j] = valuesArr.get(i).getId();
            args[j + 1] = valuesArr.get(i).getValue();
        }
        args[valuesArr.size() * 2] = valuesArr.get(0).getId();
        args[valuesArr.size() * 2 + 1] = valuesArr.get(valuesArr.size() - 1).getId();
        jdbcTemplate.update(sqlUpdateValue, args);
    }

    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        //update entity table
        updateEntity(id, entityName, isActive, userId);
        //update value table
        updateValue(valuesArr);
    }

    @Override
    public void delete(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //final String sqlDeleteValue = "DELETE FROM TBL_VALUE WHERE ENTITYID = ?";
        final String sqlDeleteEntity = "UPDATE TBL_ENTITY SET ISACTIVE = 0 WHERE ENTITYID = ?";
        Object[] args = new Object[]{
                id
        };
        jdbcTemplate.update(sqlDeleteEntity, args);
    }

    private int getKey() {
        final String sql = "SELECT SQ_MAIN.NEXTVAL from dual";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int out = jdbcTemplate.queryForObject(sql, Integer.class);
        return out;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
