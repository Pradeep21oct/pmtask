package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Task;
import com.cts.pmapps.domain.User;
import com.cts.pmapps.service.TaskService;
import com.cts.pmapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {
    @Autowired
    TaskService taskService;


    @GetMapping("/tasks")
    public  @ResponseBody
    List<Task> getTaskList(){

        System.out.println("geting");
        return taskService.getTaskList();
    }
    @GetMapping("/alltask")
    public  @ResponseBody  List<String> getTaskNames(){
        return taskService.getTaskNames();
    }

    @GetMapping("/tasks/{taskId}")
    public  @ResponseBody Task getTaskById(@PathVariable int taskId){

        System.out.println("geting");
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasks/search/{project}")
    public  @ResponseBody
    List<Task> getSearch(@PathVariable String project){

        System.out.println("search");
        return taskService.searchByProject(project);
    }
    @PostMapping("/tasks/add")
    public @ResponseBody  List<Task> addTask(@RequestBody Task task)
    {             return taskService.addTask(task);
    }


    @PostMapping("/tasks/delete/{taskId}")
    public void deleteUser(@PathVariable int taskId){
        System.out.println("deleting");
        taskService.deleteTask(taskId);
    }

    @PostMapping("/tasks/update")
    public   void updateTask(@RequestBody Task task){
        System.out.println("updating");
        taskService.updateTask(task);
    }


}
