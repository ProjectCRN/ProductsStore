package com.netcracker.crm.dao.rowmapper;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nastya on 11/14/2016.
 */
public class AtributeValueRowMapper implements RowMapper<Pair<Atribute,Value>> {
    @Override
    public Pair<Atribute,Value> mapRow(ResultSet resultSet, int i) throws SQLException {
        AtributeValueExtractor atributeValueExtractor=new AtributeValueExtractor();
        return atributeValueExtractor.extractData(resultSet);
    }
}
