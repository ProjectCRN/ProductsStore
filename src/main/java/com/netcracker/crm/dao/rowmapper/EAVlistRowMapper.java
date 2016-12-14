package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EAVlistRowMapper implements RowMapper<Entity> {
    private List<String> entiyIdList;

    @Override
    public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
        EAVlistExtractor eaVlistExtractor = new EAVlistExtractor(this.entiyIdList);
        return eaVlistExtractor.extractData(resultSet);
    }

    public EAVlistRowMapper(List<String> entiyIdList) {
        this.entiyIdList = new ArrayList<>(entiyIdList);
    }
}
