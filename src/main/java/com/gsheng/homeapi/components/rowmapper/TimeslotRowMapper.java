package com.gsheng.homeapi.components.rowmapper;

import com.gsheng.homeapi.components.obj.DateTime;
import com.gsheng.homeapi.components.obj.Timeslot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeslotRowMapper implements RowMapper<Timeslot> {
    @Override
    public Timeslot mapRow(ResultSet rs, int row) throws SQLException{
        Timeslot slot = new Timeslot(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("repeated"),
                DateTime.parseDate(rs.getString("start")),
                DateTime.parseDate(rs.getString("end")));
        return slot;
    }
}
