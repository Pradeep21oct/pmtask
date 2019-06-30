package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Task;
import com.cts.pmapps.domain.User;
import com.cts.pmapps.service.TaskService;
import com.cts.pmapps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {
    @Autowired
    TaskService taskService;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("/tasks")
    public  @ResponseBody
    List<Task> getTaskList(){

        logger.info("Inside getTaskList");
        return taskService.getTaskList();
    }
    @GetMapping("/alltask")
    public  @ResponseBody  List<String> getTaskNames(){
        return taskService.getTaskNames();
    }

    @GetMapping("/tasks/{taskId}")
    public  @ResponseBody Task getTaskById(@PathVariable int taskId){

       logger.info("Inside getTaskList"+taskId);
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasks/search/{project}")
    public  @ResponseBody
    List<Task> getSearch(@PathVariable String project){
        logger.info("Inside getSearch "+project);
         return taskService.searchByProject(project);
    }
    @PostMapping("/tasks/add")
    public @ResponseBody  List<Task> addTask(@RequestBody Task task)
    {             return taskService.addTask(task);
    }


    @GetMapping("/tasks/endtask/{taskId}")
    public void EndTask(@PathVariable int taskId){
        logger.info("Inside EndTask task Id:"+taskId);
        taskService.deleteTask(taskId);
    }

    @PostMapping("/tasks/update")
    public   void updateTask(@RequestBody Task task){
        logger.info("Inside updateTask");
           taskService.updateTask(task);
    }


}
