package com.cts.pmapps.dao;

import com.cts.pmapps.domain.Project;
import com.cts.pmapps.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ProjectRepository projectRepository;
    public List<Project> findAll(){
        return  jdbcTemplate.query("SELECT * FROM PROJECT ", new ProjectRowMapper() );

    }

    public  List<Project> addProject(Project project){
        String sql=" insert into PROJECT(PROJECT_NAME,START_DATE,END_DATE,PRIORITY,PROJECT_STATUS,PROJECT_MANAGER)\n" +
                "    values(?,?,?,?,?,?)";
        KeyHolder holder=new GeneratedKeyHolder();
        jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getProjectName());
            ps.setDate(2, new java.sql.Date(project.getStartDate().getTime()));
            ps.setDate(3,new java.sql.Date(project.getEndDate().getTime()));
             ps.setInt(4, project.getPriority());
            ps.setString(5, "Open");
            ps.setString(6,  project.getProjectManager());
           return ps;
        },holder);
        int newLeaveId = holder.getKey().intValue();
        project.setProjectId(holder.getKey().intValue());

        return findAll();
    }
    public Optional<Project> getProjectById(int id){
        return projectRepository.findById(id);

    }



}


