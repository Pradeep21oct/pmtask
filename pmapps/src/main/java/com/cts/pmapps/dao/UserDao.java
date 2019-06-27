package com.cts.pmapps.dao;

import com.cts.pmapps.domain.Project;
import com.cts.pmapps.domain.User;
import com.cts.pmapps.repo.ProjectRepository;
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
public class UserDao {
    private static final  String INSERT_SQL=" insert into USERS(FIRST_NAME,LAST_NAME,EMP_ID)\n" +
            "    values(?,?,?)";
    private static final  String SELECT_SQL="SELECT * FROM USERS ";
    private static final  String SELECT_BY_ID_SQL="SELECT * FROM USERS where  USER_ID=?";
    private static final  String UPDATE_SQL=" update USERS set FIRST_NAME=? ,LAST_NAME=?,EMP_ID=?\n" +
            " where  USER_ID=?";
    private static final  String DELETE_SQL=" delete from where  USER_ID=?\n";
    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        return  jdbcTemplate.query(SELECT_SQL, new UserRowMapper() );

    }

    public Optional<User> findById(int id){
        return  userRepository.findById(id);

    }

    public  List<User> addUser(User user){

        KeyHolder holder=new GeneratedKeyHolder();
        jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getFirstName());
            ps.setString(2,  user.getLastName());
            ps.setString(3, user.getEmpId());
           return ps;
        },holder);
         user.setUserid(holder.getKey().intValue());

        return findAll();
    }

    public  List<User> updateUser(User user){
        jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement(UPDATE_SQL);

            ps.setString(1, user.getFirstName());
            ps.setString(2,  user.getLastName());
            ps.setString(3, user.getEmpId());
            ps.setInt(4, user.getUserid());
            return ps;
        });

        return findAll();
    }

    public  List<User> deleteUser(int userId){
        jdbcTemplate.update(con->{
            PreparedStatement ps = con.prepareStatement(DELETE_SQL);
            ps.setInt(1,userId);

            return ps;
        });

        return findAll();
    }
}


