package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Project;

import com.cts.pmapps.domain.User;
import com.cts.pmapps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("/users")
    public  @ResponseBody
    List<User> getUserDetails(){

        logger.info("inside getUserDetails");
        return userService.getUserDetails();
    }
    @GetMapping("/allusers")
    public  @ResponseBody  List<String> getUserNames(){
        return userService.getUserNames();
    }

    @GetMapping("/users/{userId}")
    public  @ResponseBody User getUserById(@PathVariable int userId){
        logger.info("inside getUserDetails getUserById "+userId);
            return userService.getUserById(userId);
    }

    @PostMapping("/users/add")
    public @ResponseBody  List<User> addUser(@RequestBody User user)
    {             return userService.addUser(user);
    }


    @GetMapping("/users/delete/{userId}")
    public void deleteUser(@PathVariable int userId){
        logger.info("inside deleteUser user id "+userId);
            userService.deleteUser(userId);
    }

    @GetMapping("/users/update/{user}")
    public   void updateUser(@PathVariable User user){
         logger.info("inside updateUser"+user);
         userService.updateUser(user);
    }
}
