package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Project;
import com.cts.pmapps.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProjectController {
     @Autowired
    ProjectService projectService;
   Logger logger= LoggerFactory.getLogger(this.getClass());
    @GetMapping("/projects")
    public  @ResponseBody  List<Project> getProjectDetails(){
        logger.info("Inside getProjectDetails");
          return projectService.getProjectDetails();

    }

    @GetMapping("/allprojects")
    public  @ResponseBody  List<String> getProjectNames(){
        logger.info("Inside getProjectNames");
        return projectService.getProjectNames();
    }


    @GetMapping("/projects/{id}")
    public  @ResponseBody Project getProjectById(@PathVariable int id){

        logger.info("Inside getProjectById");
        return projectService.getProjectById(id);
    }

    @PostMapping("/projects/add")
    public @ResponseBody  List<Project> addProject(@RequestBody Project project){
        logger.info("Inside addProject");
              return projectService.addProject(project);
    }

    @GetMapping("/projects/suspends/{projectId}")
    public void suspend(@PathVariable int projectId){
        logger.info("Inside Suspends project Id:"+projectId);
        projectService.suspendsProject(projectId);
    }

}
