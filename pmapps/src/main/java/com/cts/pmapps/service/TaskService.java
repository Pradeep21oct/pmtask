package com.cts.pmapps.service;

import com.cts.pmapps.dao.TaskDao;
import com.cts.pmapps.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public List<Task> getTaskList(){
        return (List<Task>) taskDao.findAll();
    }

    public List<Task> searchByProject(String prj){
        return (List<Task>) taskDao.search(prj);
    }

    public Task getTaskById(int id){
        return  taskDao.findById(id).get();
    }
    public List<String>  getTaskNames(){
        return taskDao.findAll().stream().map(u->u.getTaskName()).collect(Collectors.toList());
    }

    public List<Task>  addTask(Task tsk){
         return taskDao.addTask(tsk);

    }

    public List<Task>  updateTask(Task task){
            return taskDao.updateTask(task);

    }

    public List<Task>  deleteTask(int taskId){
             return taskDao.deleteTask(taskId);

    }




}
