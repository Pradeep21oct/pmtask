package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Project;

import com.cts.pmapps.domain.User;
import com.cts.pmapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/users")
    public  @ResponseBody
    List<User> getUserDetails(){

        System.out.println("geting");
        return userService.getUserDetails();
    }
    @GetMapping("/allusers")
    public  @ResponseBody  List<String> getUserNames(){
        return userService.getUserNames();
    }

    @GetMapping("/users/{userId}")
    public  @ResponseBody User getUserById(@PathVariable int userId){

        System.out.println("geting");
        return userService.getUserById(userId);
    }

    @PostMapping("/users/add")
    public @ResponseBody  List<User> addUser(@RequestBody User user)
    {             return userService.addUser(user);
    }


    @PostMapping("/users/delete/{userId}")
    public void deleteUser(@PathVariable int userId){
        System.out.println("deleting");
         userService.deleteUser(userId);
    }

    @PostMapping("/users/update")
    public   void updateUser(@RequestBody User user){
        System.out.println("updating");
         userService.updateUser(user);
    }
}
