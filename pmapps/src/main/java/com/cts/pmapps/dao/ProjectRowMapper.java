package com.cts.pmapps.dao;

import com.cts.pmapps.domain.Project;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {

    @Nullable
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project prj=new Project();
        prj.setProjectId(rs.getInt("PROJECT_ID"));
        prj.setProjectName(rs.getString("PROJECT_NAME"));
        prj.setStartDate(rs.getDate("START_DATE"));
        prj.setEndDate(rs.getDate("END_DATE"));
        prj.setStatus(rs.getString("PROJECT_STATUS"));
        prj.setPriority(rs.getInt("PRIORITY"));
        prj.setProjectManager(rs.getString("PROJECT_MANAGER"));
        return prj;
    }
}
