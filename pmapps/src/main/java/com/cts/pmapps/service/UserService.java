package com.cts.pmapps.service;

import com.cts.pmapps.dao.ProjectDao;
import com.cts.pmapps.dao.UserDao;
import com.cts.pmapps.domain.Project;
import com.cts.pmapps.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<User> getUserDetails(){
        return (List<User>) userDao.findAll();
    }

    public User getUserById(int id){
        return  userDao.findById(id).get();
    }
    public List<String>  getUserNames(){
        return userDao.findAll().stream().map(u->u.getFirstName()+" "+u.getLastName()).collect(Collectors.toList());
    }

    public List<User>  addUser(User user){
         return userDao.addUser(user);

    }

    public List<User>  updateUser(User user){
            return userDao.updateUser(user);

    }

    public List<User>  deleteUser(int userId){
             return userDao.deleteUser(userId);

    }




}
