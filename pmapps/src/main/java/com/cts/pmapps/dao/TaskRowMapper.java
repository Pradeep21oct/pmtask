package com.cts.pmapps.dao;

import com.cts.pmapps.domain.Task;
import com.cts.pmapps.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    @Nullable
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task=new Task();
        task.setTaskId(rs.getInt("TASK_ID"));
        task.setParent(rs.getString("PARENT_ID"));
        task.setProject(rs.getString("PROJECT_ID"));
        task.setTaskName(rs.getString("TASK_NAME"));
        task.setStartDate(rs.getDate("START_DATE"));
        task.setEndDate(rs.getDate("END_DATE"));
        task.setStatus(rs.getString("STATUS"));
        task.setPriority(rs.getInt("PRIORITY"));

        return task;
    }
}
