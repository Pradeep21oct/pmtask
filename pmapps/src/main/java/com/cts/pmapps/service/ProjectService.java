package com.cts.pmapps.service;

import com.cts.pmapps.dao.ProjectDao;
import com.cts.pmapps.domain.Project;
import com.cts.pmapps.domain.Task;
import com.cts.pmapps.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {


    @Autowired
    ProjectDao projectDao;
       public List<Project>  getProjectDetails(){
          return (List<Project>) projectDao.findAll();
       }


    public List<String>  getProjectNames(){
            return projectDao.findAll().stream().map(p->p.getProjectName()).collect(Collectors.toList());
      }

    public List<Project>  addProject(Project project){
             return projectDao.addProject(project);

    }

    public Project  getProjectById(int id){
          return projectDao.getProjectById(id).get();

    }
    public List<Project>  suspendsProject(int projectId){
        return projectDao.suspendsProject(projectId);

    }

}
