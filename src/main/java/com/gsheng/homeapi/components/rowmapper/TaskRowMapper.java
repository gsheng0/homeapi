package com.gsheng.homeapi.components.rowmapper;

import com.gsheng.homeapi.components.obj.DateTime;
import com.gsheng.homeapi.components.obj.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    @Override
    public Article mapRow(ResultSet rs, int row) throws SQLException{
        Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getString("date"));

        return article;
    }
 */
public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int row) throws SQLException {
        Task task = new Task(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("repeated"),
                DateTime.parseDate(rs.getString("date")));
        return task;
    }
}
