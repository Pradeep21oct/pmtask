package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Project;
import com.cts.pmapps.service.ProjectService;
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

    @GetMapping("/projects")
    public  @ResponseBody  List<Project> getProjectDetails(){
          return projectService.getProjectDetails();
    }


    @PostMapping("/projects/add")
    public @ResponseBody  List<Project> addProject(@RequestBody Project project){
              return projectService.addProject(project);
    }
}
