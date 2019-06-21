package com.cts.pmapps.service;

import com.cts.pmapps.dao.ProjectDao;
import com.cts.pmapps.domain.Project;
import com.cts.pmapps.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {

    //@Autowired
   // ProjectRepository projectRepository;
    @Autowired
    ProjectDao projectDao;
       public List<Project>  getProjectDetails(){
          return (List<Project>) projectDao.findAll();
       }

    public List<Project>  addProject(Project project){
        System.out.println(""+project);
           return projectDao.addProject(project);

    }


}
