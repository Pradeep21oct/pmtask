package com.cts.pmapps.dao;

import com.cts.pmapps.domain.Task;
import com.cts.pmapps.domain.User;
import com.cts.pmapps.repo.TaskRepository;
import com.cts.pmapps.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskDao {
    private static final  String INSERT_SQL=" insert into TASK(PARENT_ID,PROJECT_ID,TASK_NAME,START_DATE,END_DATE,STATUS,PRIORITY)\n" +
            "    values(?,?,?,?,?,?,?)";
    private static final  String SELECT_SQL="SELECT * FROM TASK ";
    private static final  String SEARCH_SQL="SELECT * FROM TASK where PROJECT_ID like %'?'%";
    private static final  String SELECT_BY_ID_SQL="SELECT * FROM USERS where  USER_ID=?";
    private static final  String UPDATE_SQL=" update USERS set FIRST_NAME=? ,LAST_NAME=?,EMP_ID=?\n" +
            " where  USER_ID=?";

    private static final  String DELETE_SQL=" delete from where  USER_ID=?\n";
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Task> findAll(){
        return  jdbcTemplate.query(SELECT_SQL, new TaskRowMapper() );

    }
    public List<Task> search(String project){
        return  jdbcTemplate.query(con->{

           PreparedStatement ps = con.prepareStatement("SELECT * FROM TASK where PROJECT_ID like '%"+project+"%'");
                  return ps;
        }, new TaskRowMapper() );

    }

    public Optional<Task> findById(int id){
        return  taskRepository.findById(id);

    }

    public  List<Task> addTask(Task task){

        KeyHolder holder=new GeneratedKeyHolder();
        jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, task.getParent());
            ps.setString(2,  task.getProject());
            ps.setString(3, task.getTaskName());
            ps.setDate(4, new java.sql.Date(task.getStartDate().getTime()));
            ps.setDate(5,new java.sql.Date(task.getEndDate().getTime()));
            ps.setString(6, "Open");
            ps.setInt(7, task.getPriority());
           return ps;
        },holder);
        task.setTaskId(holder.getKey().intValue());

        return findAll();
    }

    public  List<Task> updateTask(Task user){


        return findAll();
    }

    public  List<Task> deleteTask(int taskId){
          jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement("update TASK set STATUS='End' where  TASK_ID= '"+taskId+"'");
            return ps;
        } );
        return findAll();
    }
}


