package com.gsheng.homeapi.components.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterMapper implements RowMapper<Integer> {
    @Override
    public Integer mapRow(ResultSet rs, int row) throws SQLException{
        return rs.getInt("counter");
    }
}
